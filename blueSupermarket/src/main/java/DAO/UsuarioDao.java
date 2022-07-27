package DAO;


import factory.Factory;
import model.Usuario;

import java.sql.*;

public class UsuarioDao {

    private Connection conn= new Factory().getC();
    public String inserirUsuario(Usuario usuario) {

        String comando = "INSERT INTO USUARIOS (NOME, CPF, SENHA, CEP, ENDERECO) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = conn.prepareStatement(comando)) {
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCpf());
            pstm.setString(3, usuario.getSenha());
            pstm.setString(4, usuario.getCep());
            pstm.setString(5, usuario.getEndereco());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "O usuário foi inserido.";
    }


    public Usuario consultarUsuarioPorCpf (String cpf)  {
        Usuario usuarioRetornado = new Usuario();
        String sql = "SELECT NOME, CPF, SENHA, CEP, ENDERECO FROM USUARIOS WHERE CPF = ?";
        try(PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,cpf);
            pst.execute();
            ResultSet rst = pst.getResultSet();
            System.out.println(rst);
                while (rst.next()) {

                    String nomeUsuario = rst.getString("NOME");
                    usuarioRetornado.setNome(nomeUsuario);
                    String cpfUsuario = rst.getString("CPF");
                    usuarioRetornado.setCpf(cpfUsuario);
                    String senhaUsuario = rst.getString("SENHA");
                    usuarioRetornado.setSenha(senhaUsuario);
                    String cepUsuario = rst.getString("CEP");
                    usuarioRetornado.setCep(cepUsuario);
                    String enderecoUsuario = rst.getString("ENDERECO");
                    usuarioRetornado.setEndereco(enderecoUsuario);
                }

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return usuarioRetornado;
    }

    public void deletarPorCpf(String cpf) {
        try (java.sql.PreparedStatement pstm = conn.prepareStatement("DELETE FROM USUARIOS WHERE CPF = " +cpf)){
            pstm.execute();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
