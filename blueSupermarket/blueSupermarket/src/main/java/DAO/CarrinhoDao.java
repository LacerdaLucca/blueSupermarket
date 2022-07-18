package DAO;

import factory.Factory;
import model.Carrinho;
import model.ListaIdCarrinho;
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

    public void inserirCompra(Carrinho carrinho){

        String sql = "INSERT INTO compras (idProduto, qtn, cpfUsuario, cep, valorFrete, prazoEntrega, valorTotal) VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = stm.getConnection().prepareStatement(sql)){
            pstm.setInt(1,carrinho.getIdProdutos());
            pstm.setInt(2,carrinho.getQtn());
            pstm.setString(3,carrinho.getCpfUsuario());
            pstm.setString(4,carrinho.getCep());
            pstm.setDouble(5,carrinho.getValorFrete());
            pstm.setInt(6,carrinho.getPrazoEntrega());
            pstm.setDouble(7,carrinho.getValorTotal());

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
    public List<ListaIdCarrinho> listaProdutosCarrinho(){
        List<ListaIdCarrinho> lista = new ArrayList<>();
        String sql = "SELECT idProd FROM carrinho";
        try {
            PreparedStatement ps = this.stm.getConnection().prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                lista.add(new ListaIdCarrinho(rs.getInt("idProd")));
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

            String sql = "DELETE FROM carrinho WHERE idProd = ?";
            try(PreparedStatement pstm = stm.getConnection().prepareStatement(sql)){
                pstm.setInt(1,id);
                pstm.execute();
            } catch (SQLException e) {
                e.getMessage();
                System.out.println("Não foi possível isnserir produto");
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
