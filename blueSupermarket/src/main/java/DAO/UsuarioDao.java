package DAO;

import factory.ConnectionFactory;
import model.Usuario;

import java.sql.*;

public class UsuarioDao {


    Connection connection = null;
    public UsuarioDao()  {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try {
            this.connection = connectionFactory.recuperarConexao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Usuario consultarUsuarioPorCpf (String cpf)  {
        Usuario usuarioRetornado = new Usuario();
        try(java.sql.PreparedStatement stm = connection.prepareStatement("SELECT NOME, CPF, SENHA, CEP, ENDEREÇO FROM USUARIOS WHERE CPF = " +cpf)){
            stm.execute();
            try(ResultSet rst = stm.getResultSet()) {
                while (rst.next()) {

                    String nomeUsuario = rst.getString("NOME");
                    usuarioRetornado.setNome(nomeUsuario);
                    String cpfUsuario = rst.getString("CPF");
                    usuarioRetornado.setCpf(cpfUsuario);
                    String senhaUsuario = rst.getString("SENHA");
                    usuarioRetornado.setSenha(senhaUsuario);
                    String cepUsuario = rst.getString("CEP");
                    usuarioRetornado.setCep(cepUsuario);
                    String enderecoUsuario = rst.getString("ENDEREÇO");
                    usuarioRetornado.setEndereço(enderecoUsuario);
                }
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());

        }
        return usuarioRetornado;
    }

    public void deletarPorCpf(String cpf) {
        try (java.sql.PreparedStatement stm = connection.prepareStatement("DELETE FROM USUARIOS WHERE CPF = " +cpf)){
            stm.execute();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
