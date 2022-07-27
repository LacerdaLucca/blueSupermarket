package DAO;
import factory.Factory;
import model.NotaFiscal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalDao {
    private Connection conn = new Factory().getC();



    public NotaFiscal adiciona(NotaFiscal nf){

        String comando = "INSERT INTO nota_fiscal (idcarrinho, cpf) VALUES (?, ?)";
        try (PreparedStatement ps =conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1,nf.getIdCarrinho());
            ps.setString(2,nf.getCpfUsuario());
            ps.execute();
            try(ResultSet rst = ps.getGeneratedKeys()) {
                while (rst.next()) {
                    nf.setId(rst.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nf;
    }

    public void remove(int id){
        String comando = "DELETE FROM nota_fiscal WHERE ID = ?";
        try (PreparedStatement ps = conn.prepareStatement(comando)){
            ps.setInt(1,id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualiza(NotaFiscal nf){
        String comando = "UPDATE nota_fiscal NF SET NF.IDCARRINHO = ?, NF.CPF = ? WHERE ID = ?";
        try (PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setInt(1, nf.getIdCarrinho());
            ps.setString(2, nf.getCpfUsuario());
            ps.setInt(3, nf.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NotaFiscal> lista(){
        List<NotaFiscal> notas = new ArrayList<NotaFiscal>();
        String comando = "SELECT * FROM nota_fiscal";
        try (PreparedStatement ps = conn.prepareStatement(comando)){
            ps.execute();
            try(ResultSet rst = ps.getResultSet()) {
                while (rst.next()) {
                    NotaFiscal nf = new NotaFiscal(rst.getInt(1),rst.getInt(2), rst.getString(3));
                    notas.add(nf);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notas;
    }

    public NotaFiscal busca(int id) {
        NotaFiscal nf = null;
        String comando = "SELECT * FROM nota_fiscal WHERE ID = ?";
        try (PreparedStatement pstm = conn.prepareStatement(comando)) {
            pstm.setInt(1, id);
            pstm.execute();
            try(ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    nf = new NotaFiscal(rst.getInt(1),rst.getInt(2), rst.getString(3));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nf;
    }
}
