package servlet;

import exception.LoginInvalidoException;
import model.Frete;
import services.CepService;
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
        List<Frete> frete= new ArrayList<>();
        try{String cepEscolhido = req.getParameter("cep");
            System.out.println(cepEscolhido);
           frete.add(new FreteService().retornoDadosFrete(cepEscolhido));

            req.setAttribute("frete", frete);
            req.getRequestDispatcher("/WEB-INF/views/frete.jsp").forward(req,resp);
        }catch (LoginInvalidoException ex) {
            resp.setContentType("text/html");
            resp.getWriter().println(ex.getMessage() + "<a href=\"/blueSupermarket/sistema/carrinho?\">Tentar digitar o cep novamente</a>");
        }
    }
}
