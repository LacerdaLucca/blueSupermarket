package services;

import DAO.UsuarioDao;
import exception.LoginInvalidoException;
import model.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginService {

    private final UsuarioDao usuarioDao = new UsuarioDao();

    public Usuario login(HttpServletRequest req, HttpServletResponse resp) throws LoginInvalidoException {
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");

        Usuario usuario = usuarioDao.consultarUsuarioPorCpf(cpf);
        System.out.println(usuario.getSenha());

        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        } else {
            throw new LoginInvalidoException();
        }
    }
}
