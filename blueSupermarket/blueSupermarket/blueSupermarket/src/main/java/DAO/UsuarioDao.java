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

    public Usuario consultarUsuarioPorCpf (String cpf)  {
        Usuario usuarioRetornado = new Usuario();
        try(java.sql.PreparedStatement pstm = stm.getConnection().prepareStatement("SELECT NOME, CPF, SENHA, CEP, ENDEREÇO FROM USUARIOS WHERE CPF = " +cpf)){
            pstm.execute();
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
        try (java.sql.PreparedStatement pstm = stm.getConnection().prepareStatement("DELETE FROM USUARIOS WHERE CPF = " +cpf)){
            pstm.execute();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
