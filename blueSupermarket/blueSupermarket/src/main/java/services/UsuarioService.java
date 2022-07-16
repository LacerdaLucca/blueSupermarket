package services;

import DAO.UsuarioDao;
import model.Usuario;

public class UsuarioService {

    UsuarioDao usuarioDao = new UsuarioDao();
    public void insereUsuario(String nome, String cpf, String senha, String cep, String endereco){
        System.out.println(nome + " " + cpf + " " + senha + " " + cep + " " + endereco);
        Usuario usuario = new Usuario(nome, cpf);
//        usuarioDao.inserirUsuario(usuario);

    }
}
