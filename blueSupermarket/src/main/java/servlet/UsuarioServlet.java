package servlet;

import DAO.UsuarioDao;
import exception.LoginInvalidoException;
import model.Usuario;
import services.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

  //  UsuarioDao usuarioDao = new UsuarioDao();
    UsuarioService usuarioService = new UsuarioService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        UsuarioDao teste = new UsuarioDao();
        System.out.println(cpf);
        // Usuario u = teste.consultarUsuarioPorCpf(cpf);
        //    System.out.println(u);
        //   teste.deletarPorCpf(cpf);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        System.out.println(senha);
        String cep = request.getParameter("cep");
        String endereco = request.getParameter("endereco");
        try {
            usuarioService.insereUsuario(nome, cpf, senha, cep, endereco);
        }catch(LoginInvalidoException ex){
            response.setContentType("text/html");
            response.getWriter().println(ex.getMessage() + " <a href ='usuarioForm' > Volte a tela interior </a>");
        }
        response.sendRedirect("/blueSupermarket/");
    }
}
