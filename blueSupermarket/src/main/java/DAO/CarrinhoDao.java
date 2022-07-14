package DAO;

import model.Carrinho;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class CarrinhoDao {
    private Statement stm;
    private Factory f;

    public CarrinhoDao() throws SQLException {
        this.f = new Factory();
        f.setConnection("jdbc:mysql://localhost:3306/bluesupermarket?useTimezone=true&serverTimezone=UTC&useSSL=false");
        this.stm = f.getStatement();
    }

    public void inserirCompra(Carrinho carrinho){
        System.out.println(carrinho.getListProdutos().size());

        String sql = "INSERT INTO carrinho (idProduto, qtn, cpfUsuario, cep, valorFrete, prazoEntrega, valorTotal) VALUES (?,?,?,?,?,?,?)";
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

    public void deletarPorId(int idProd){
        String sql = "DELETE FROM CARRINHO WHERE id = ?";
        try(PreparedStatement pstm = stm.getConnection().prepareStatement(sql)){
            pstm.setInt(1,idProd);
            pstm.execute();

        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Erro ao apagar o produto do carrinho");
        }

    }
}
