package servlet;

import DAO.ProdutosDao;
import model.Produto;
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

@WebServlet("/sistema/relatorio")
public class RelatoriosServlets extends HttpServlet {
    private List<Relatorio> relatoriosPorData = new ArrayList<>();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        relatoriosPorData.clear();

        String paramNomeBusca = req.getParameter("nomeProd");
        String paramNomeProd = req.getParameter("nome");
        String paramDataIn = req.getParameter("dataIn");
        String paramDataFim = req.getParameter("dataFim");
        String getCpfUsuario= req.getParameter("usuario");

        if (paramNomeProd == null & paramNomeBusca == null & paramDataIn == null & paramDataFim == null) {
            req.getRequestDispatcher("/WEB-INF/views/buscaRelatorio.jsp").forward(req, resp);
        } else {
            if (paramNomeProd != null & paramDataIn == null & paramDataFim == null) {
                List<Produto> listaProdutos = new ArrayList<>();
                listaProdutos.addAll(new ProdutosDao().listaProdutoPorNome(paramNomeProd));
                for (Produto prod:listaProdutos) {
                    System.out.println(prod.getNome());
                }
                req.setAttribute("listaProd", listaProdutos);
                req.getRequestDispatcher("/WEB-INF/views/listaProdutos.jsp").forward(req, resp);

            } else if (paramNomeBusca != null & paramDataIn != null & paramDataFim != null) {
                relatoriosPorData.addAll(new RelatoriosService().listaVendaNome(paramNomeBusca, paramDataIn, paramDataFim, getCpfUsuario));

            } else if (paramNomeBusca != null & paramDataIn == null & paramDataFim == null) {
                req.setAttribute("nomeProd", paramNomeBusca);
                req.getRequestDispatcher("/WEB-INF/views/formDataRelatorio.jsp").forward(req, resp);

            } else if (paramNomeBusca == null & paramDataIn != null & paramDataFim != null) {
                relatoriosPorData.addAll(new RelatoriosService().listaVendaPeriodo(paramDataIn, paramDataFim, getCpfUsuario));
            }

            req.setAttribute("vendas", relatoriosPorData);
            req.getRequestDispatcher("/WEB-INF/views/relatorio.jsp").forward(req, resp);

        }
    }
}
