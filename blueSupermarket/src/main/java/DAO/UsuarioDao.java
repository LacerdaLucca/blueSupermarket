package DAO;


import factory.Factory;
import model.Usuario;

import java.sql.*;

public class UsuarioDao {

    private Statement stm;
    private Factory f;

    public UsuarioDao()  {
       try{
           this.f = new Factory();
           f.setConnection("jdbc:mysql://localhost:3306/bluesupermarket?useTimezone=true&serverTimezone=UTC&useSSL=false");
           this.stm = f.getC().createStatement();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    public String inserirUsuario(String nome,String cpf,String senha, String cep,String endereco) {

        String comando = "INSERT INTO USUARIOS (NOME, CPF, SENHA, CEP, ENDERECO) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = stm.getConnection().prepareStatement(comando)) {
            pstm.setString(1, nome);
            pstm.setString(2, cpf);
            pstm.setString(3, senha);
            pstm.setString(4, cep);
            pstm.setString(5, endereco);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "O usuário foi inserido.";
    }


    public Usuario consultarUsuarioPorCpf (String cpf)  {
        Usuario usuarioRetornado = new Usuario();
        String sql = "SELECT NOME, CPF, SENHA, CEP, ENDERECO FROM USUARIOS WHERE CPF = ?";
        try(PreparedStatement pstm = stm.getConnection().prepareStatement(sql)){
            pstm.setString(1,cpf);
            pstm.execute();
            ResultSet rst = pstm.getResultSet();
                while (rst.next()) {
                    String nomeUsuario = rst.getString("NOME");
                    String cpfUsuario = rst.getString("CPF");
                    String senhaUsuario = rst.getString("SENHA");
                    String cepUsuario = rst.getString("CEP");
                    String enderecoUsuario = rst.getString("ENDERECO");
                    usuarioRetornado=(new Usuario(nomeUsuario,cpfUsuario,senhaUsuario,cepUsuario,enderecoUsuario));

                }
            return usuarioRetornado;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());

        }
        return usuarioRetornado;
    }

    public void deletarPorCpf(String cpf) {
        try (java.sql.PreparedStatement pstm = stm.getConnection().prepareStatement("DELETE FROM USUARIOS WHERE CPF = " +cpf)){
            pstm.execute();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
