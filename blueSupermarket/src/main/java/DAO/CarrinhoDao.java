package DAO;

import factory.Factory;
import model.Carrinho;
import model.Compra;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CarrinhoDao {
    private Connection conn= new Factory().getC();

    public void inserirCompra(Compra compra, int id){
        String sql = "INSERT INTO compras (idcarrinhos, idProduto, nomProd, qtn, cpfUsuario, cep, valorFrete, prazoEntrega, dataCompra, valorTotal) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setInt(1,id);
            pstm.setInt(2,compra.getIdProdutos());
            pstm.setString(3,compra.getNomeProd());
            pstm.setInt(4,compra.getQtn());
            pstm.setString(5,compra.getCpfUsuario());
            pstm.setString(6,compra.getCep());
            pstm.setDouble(7,compra.getValorFrete());
            pstm.setInt(8,compra.getPrazoEntrega());
            pstm.setString(9,compra.getDataCompra());
            pstm.setDouble(10,compra.getValorTotal());
            pstm.execute();
//            try(ResultSet rst = pstm.getGeneratedKeys()) {
//                while (rst.next()) {
//                    compra.setIdCarrinhos(rst.getInt(1));
//                }
//            }
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Não foi possível isnserir compra");
        }
    }
    public void adicionaCarrinho(List<Produto> listProd){

        for (Produto produto:listProd) {
            String sql = "INSERT INTO carrinho (idProd,qtn,valorTotal) VALUES (?,?,?)";
            try(PreparedStatement pstm = conn.prepareStatement(sql)){
                pstm.setInt(1,produto.getIdProd());
                pstm.setInt(2, produto.getQuantidade());
                pstm.setDouble(3,produto.getValorTotal());
                pstm.execute();
            } catch (SQLException e) {
                e.getMessage();
                System.out.println("Não foi possível isnserir produto");
            }
        }
    }
    public List<Carrinho> listaProdutosCarrinho(){
        List<Carrinho> lista = new ArrayList<>();
        String sql = "SELECT idProd,qtn,valorTotal FROM carrinho";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                lista.add(new Carrinho(rs.getInt("idProd"),rs.getInt("qtn"),rs.getDouble("valorTotal")));
            }
            System.out.println(lista.size());
            return lista;
        }catch(SQLException e) {
            System.out.println("ERRO AO OBTER PRODUTO! (method getProdutos())");
            System.out.println(e.getMessage());
            return null;
        }
    }


    public void deletarCarrinho(int id){
        List<Carrinho> listCarrinho = new ArrayList<>();
        listCarrinho.addAll(listaProdutosCarrinho());
        for (Carrinho carrinho:listCarrinho) {
          if (carrinho.getIdProd() == id){
              String sql = "DELETE FROM carrinho WHERE idCar = ?";
              try(PreparedStatement pstm = conn.prepareStatement(sql)){
                  pstm.setInt(1,carrinho.getIdCar());
                  pstm.execute();
                  return;
              } catch (SQLException e) {
                  e.getMessage();
                  System.out.println("Não foi possível isnserir produto");
              }
          }
        }
    }

    public List<Compra> buscaCompraPorData(String dataBusca){
        List<Compra> listaCompraJson = new ArrayList();

        String sql = "SELECT * FROM compras WHERE dataCompra= ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,cpf);
            ps.setString(1,dataBusca);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                listaCompraJson.add(new Compra(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(6),rs.getDouble(7),rs.getInt(8),rs.getString(9)));
                if(!rs.next()) return listaCompraJson;
            }
            return listaCompraJson;
        }catch(SQLException e) {
            System.out.println("ERRO AO OBTER LISTA DE COMPRA! (method getProdutos())");
            System.out.println(e.getMessage());
            return null;
        }
    }
    public int buscarIdUltimaCompra(){
        String sql = "SELECT MAX(idcarrinhos) FROM compras";
        int id = 0;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                id= rs.getInt(1);
            }
            return id;
        }catch(SQLException e) {
            System.out.println("ERRO AO OBTER LISTA DE COMPRA! (method getProdutos())");
            System.out.println(e.getMessage());
        }
        return id;
    }
    public void salvarParamBuscaRelatorio(int id){
        String sql = "INSERT INTO carrinho (idProd) VALUES (?)";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            pstm.setInt(1,id);
            pstm.execute();
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Não foi possível isnserir produto");
        }
    }


    public void truncateCarrinho(){
            String sql = "TRUNCATE carrinho";
            try(PreparedStatement pstm = conn.prepareStatement(sql)){
                pstm.execute();
            } catch (SQLException e) {
                e.getMessage();
                System.out.println("Produtos do carrinho não deletado");
            }
    }

    public List<Compra> listaUltimaCompra(String cpfUsuario){
        List<Compra> lista = new ArrayList<>();
        String sql = " SELECT * FROM compras  JOIN (SELECT cpfUsuario, MAX(dataCompra) ultimaData from compras where cpfUsuario = ?)ultimoRegistro\n" +
                "                     on compras.dataCompra = ultimoRegistro.ultimaData\n" +
                "                     and compras.cpfUsuario = ultimoRegistro.cpfUsuario;";
        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,cpfUsuario);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                lista.add(new Compra(rs.getInt("idCarrinhos"),
                        rs.getInt("idProduto"),
                        rs.getString("nomProd"),
                        rs.getInt("qtn"),
                        rs.getString("cpfUsuario"),
                        rs.getString("cep"),
                        rs.getDouble("valorFrete"),
                        rs.getInt("prazoEntrega"),
                        0,
                        rs.getString("dataCompra")));
            }
            return lista;
        }catch(SQLException e) {
            System.out.println("ERRO AO ENCONTRAR ULTIMA COMPRA! (method listaUltimaCompra())");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
