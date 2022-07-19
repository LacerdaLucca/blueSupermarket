package DAO;

import factory.Factory;
import model.Carrinho;
import model.Compra;
import model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CarrinhoDao {
    private Statement stm;
    private Factory f;

    public CarrinhoDao() throws SQLException {
        this.f = new Factory();
        f.setConnection("jdbc:mysql://localhost:3306/bluesupermarket?useTimezone=true&serverTimezone=UTC&useSSL=false");
        this.stm = f.getC().createStatement();
    }

    public void inserirCompra(Compra compra){

        String sql = "INSERT INTO compras (idProduto, nomProd, qtn, cpfUsuario, cep, valorFrete, prazoEntrega, dataCompra) VALUES (?,?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = stm.getConnection().prepareStatement(sql)){
            pstm.setInt(1,compra.getIdProdutos());
            pstm.setString(2,compra.getNomeProd());
            pstm.setInt(3,compra.getQtn());
            pstm.setString(4,compra.getCpfUsuario());
            pstm.setString(5,compra.getCep());
            pstm.setDouble(6,compra.getValorFrete());
            pstm.setInt(7,compra.getPrazoEntrega());
            pstm.setString(8,compra.getDataCompra());
            pstm.execute();
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Não foi possível isnserir compra");
        }
    }
    public void adicionaCarrinho(List<Produto> listProd){

        for (Produto produto:listProd) {
            String sql = "INSERT INTO carrinho (idProd) VALUES (?)";
            try(PreparedStatement pstm = stm.getConnection().prepareStatement(sql)){
                pstm.setInt(1,produto.getID());
                pstm.execute();
            } catch (SQLException e) {
                e.getMessage();
                System.out.println("Não foi possível isnserir produto");
            }
        }
    }
    public List<Carrinho> listaProdutosCarrinho(){
        List<Carrinho> lista = new ArrayList<>();
        String sql = "SELECT idProd FROM carrinho";
        try {
            PreparedStatement ps = this.stm.getConnection().prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                lista.add(new Carrinho(rs.getInt("idProd")));
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
              try(PreparedStatement pstm = stm.getConnection().prepareStatement(sql)){
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

    public void truncateCarrinho(){
            String sql = "TRUNCATE carrinho";
            try(PreparedStatement pstm = stm.getConnection().prepareStatement(sql)){
                pstm.execute();
            } catch (SQLException e) {
                e.getMessage();
                System.out.println("Produto não deletado");
            }


    }
}
