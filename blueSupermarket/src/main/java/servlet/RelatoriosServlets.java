package servlet;

import DAO.ProdutosDao;
import DAO.RelatoriosDao;
import model.Relatorio;
import services.RelatoriosService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/relatorio")
public class RelatoriosServlets extends HttpServlet {
    private List<Relatorio> relatoriosPorData = new ArrayList<>();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String paramForm = req.getParameter("listar");
        String paramNomeProd = req.getParameter("nome");
        String paramDataIn = req.getParameter("dataIn");
        String paramDataFim = req.getParameter("dataFim");
        System.out.println(paramNomeProd);
        System.out.println(paramDataIn);
        System.out.println(paramDataFim);

        relatoriosPorData.addAll(new RelatoriosService().listaVenda(paramNomeProd,paramDataIn,paramDataFim));

        req.setAttribute("vendas", relatoriosPorData);
        req.getRequestDispatcher("/WEB-INF/views/relatorio.jsp").forward(req,resp);

    }
}
