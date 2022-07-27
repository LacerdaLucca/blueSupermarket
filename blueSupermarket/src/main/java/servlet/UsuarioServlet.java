package servlet;

import DAO.UsuarioDao;
import exception.LoginInvalidoException;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String cep = request.getParameter("cep");
        String endereco = request.getParameter("endereco");
        try {
            new UsuarioDao().inserirUsuario(nome, cpf, senha, cep, endereco);
        }catch(LoginInvalidoException ex){
            response.setContentType("text/html");
            response.getWriter().println(ex.getMessage() + " <a href ='usuarioForm' > Volte a tela interior </a>");
        }
        response.sendRedirect("/blueSupermarket/");
    }
}
