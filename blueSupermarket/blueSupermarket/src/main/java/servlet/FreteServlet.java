package servlet;

import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/frete")
public class FreteServlet extends HttpServlet {
    List<Frete> frete = new ArrayList<>();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cepEscolhido = req.getParameter("cep");

        this.frete.add(new FreteService().retornoDadosFrete(cepEscolhido));

        System.out.println(frete.get(0).getCep()+" "+frete.get(0).getValorFrete()+" "+frete.get(0).getPrazo());
        req.setAttribute("frete", frete);
        req.getRequestDispatcher("/WEB-INF/views/frete.jsp").forward(req,resp);
    }
}
