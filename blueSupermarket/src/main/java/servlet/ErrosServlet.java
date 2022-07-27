package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrosServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String erro = "Página não encontratada, faça a ação novamentoe";
        req.setAttribute("erro",erro);
        req.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(req,resp);
    }
}
