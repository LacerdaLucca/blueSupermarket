package services;

import DAO.UsuarioDao;
import exception.LoginInvalidoException;
import model.Usuario;
import servlet.UsuarioFormServlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class UsuarioService {

    UsuarioDao usuarioDao = new UsuarioDao();
    public void insereUsuario(String nome, String cpf, String senha, String cep, String endereco){

        System.out.println(nome + " " + cpf + " " + senha + " " + cep + " " + endereco);
        Usuario usuario = new Usuario(nome, cpf, senha, cep, endereco);
        usuarioDao.inserirUsuario(usuario);
    }

}
