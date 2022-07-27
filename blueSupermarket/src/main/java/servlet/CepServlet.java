package servlet;

import model.CEP;
import services.CepJson;
import services.CepService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cep")
public class CepServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cep = req.getParameter("cep");
        if (cep == null) {
            req.getRequestDispatcher("/WEB-INF/views/buscaCep.jsp").forward(req,resp);
        }else {
            String cepBusca;
            try {
                cepBusca = new CepService().getCep(cep);
                CepJson cepjason = new CepJson();
                List<CEP> lista = new ArrayList<>();
                lista.addAll(cepjason.buscaCep(cepBusca));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
