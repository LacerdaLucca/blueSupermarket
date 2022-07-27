package servlet;

import exception.LoginInvalidoException;
import model.Usuario;
import services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Usuario usuario = loginService.login(req, resp);
            if (usuario != null) {
                HttpSession sessao = req.getSession();
                sessao.setAttribute("usuario", usuario);
                resp.sendRedirect("/blueSupermarket/");
            }
        } catch (LoginInvalidoException ex) {
            resp.setContentType("text/html");
            resp.getWriter().println(ex.getMessage() + "<a href=\"/blueSupermarket/loginForm\">Voltar para tela de Login</a>");
        }

    }
}
