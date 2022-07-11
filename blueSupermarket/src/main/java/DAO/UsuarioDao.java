package DAO;

import factory.ConnectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDao {

    public static Statement pegaConexao() throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        Statement stm = connection.createStatement();

        return stm;
    }

    public static String inserirUsuario(Usuario usuario) throws SQLException {

        Connection connection = null;
        java.sql.Statement stm = connection.createStatement();
        stm.execute("INSERT INTO USUARIOS (NOME, CPF, SENHA, ENDEREÇO) "
                + "VALUES ("+usuario.getNome()+
                ", '"+usuario.getCpf()+
                "', '"+usuario.getSenha()+
                "', "+usuario.getEndereço());

        return "O usuário foi inserido.";
    }

    public static void deletarPorCpf(int cpf) throws SQLException {

        java.sql.Statement stm = pegaConexao();
        stm.execute("DELETE FROM USUARIOS WHERE CPF = " +cpf);
    }
}
