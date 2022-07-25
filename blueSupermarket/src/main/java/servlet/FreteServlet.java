package servlet;

import model.Frete;
import model.FreteAPICorreios;
import model.Produto;
import services.CarrinhoService;
import services.FreteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sistema/frete")
public class FreteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cepEscolhido = req.getParameter("cep");
        FreteAPICorreios frete = null;
        try {
            frete = new FreteService().getFrete(cepEscolhido);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("frete", frete);
        req.getRequestDispatcher("/WEB-INF/views/frete.jsp").forward(req,resp);
    }
}
