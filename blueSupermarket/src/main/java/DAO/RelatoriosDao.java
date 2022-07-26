package DAO;

import factory.Factory;
import model.Produto;
import model.Relatorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RelatoriosDao {
    private Statement stm;
    private Factory f;

    public RelatoriosDao() throws SQLException {
        this.f = new Factory();
        f.setConnection("jdbc:mysql://localhost:3306/bluesupermarket?useTimezone=true&serverTimezone=UTC&useSSL=false");
        this.stm = f.getC().createStatement();
    }


    public List<Relatorio> listVendaPorData(String dataInic, String dataFinal, String cpf){
        List<Relatorio> listaDeVendas = new ArrayList<>();
        String sql = "SELECT IdProduto, nomProd, qtn FROM compras WHERE cpfUsuario = ? AND dataCompra BETWEEN ? AND ?";

        try {
            PreparedStatement ps = stm.getConnection().prepareStatement(sql);
            ps.setString(1,cpf);
            ps.setString(2,dataInic);
            ps.setString(3,dataFinal);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                listaDeVendas.add(new Relatorio(rs.getInt("IdProduto"), rs.getString("nomProd"), rs.getInt("qtn")));

            }
            return listaDeVendas;
        }catch(SQLException e) {
            System.out.println("ERRO AO OBTER PRODUTO! (method getProdutos())");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
