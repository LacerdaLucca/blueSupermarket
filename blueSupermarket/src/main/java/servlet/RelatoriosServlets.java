package servlet;

import DAO.ProdutosDao;
import model.Produto;
import model.Relatorio;
import model.Usuario;
import services.RelatoriosService;

import javax.servlet.RequestDispatcher;
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
        Usuario usuario= (Usuario) req.getSession().getAttribute("usuario");
        String getCpfUsuario= usuario.getCpf();
        System.out.println("busca param"+paramNomeProd);
        System.out.println("busca param Produto"+paramNomeBusca);
//                req.getParameter("usuario");

       if (paramNomeProd == null & paramNomeBusca == null & paramDataIn == null & paramDataFim == null) {
            Dispatcher(req,resp,"buscaRelatorio.jsp");
        } else {
            if (paramNomeProd != null & paramDataIn == null & paramDataFim == null) {
                List<Produto> listaProdutos = new ArrayList<>();
                listaProdutos.addAll(new ProdutosDao().listaProdutoPorNome(paramNomeProd));
//                for (Produto prod:listaProdutos) {
//                    System.out.println(prod.getNome());
//                }
                req.setAttribute("listaProd", listaProdutos);
                Dispatcher(req,resp,"listaProdutos.jsp");

            } else if (paramNomeBusca != null & paramDataIn != null & paramDataFim != null) {
                relatoriosPorData.addAll(new RelatoriosService().listaVendaNome(paramNomeBusca, paramDataIn, paramDataFim, getCpfUsuario));

            } else if (paramNomeBusca != null & paramDataIn == null & paramDataFim == null) {
                req.setAttribute("nomeProd", paramNomeBusca);
                Dispatcher(req,resp,"formDataRelatorio.jsp");

            } else if (paramNomeBusca == null & paramDataIn != null & paramDataFim != null) {
                relatoriosPorData.addAll(new RelatoriosService().listaVendaPeriodo(paramNomeBusca, paramDataIn, paramDataFim, getCpfUsuario));
            }

            req.setAttribute("vendas", relatoriosPorData);
            Dispatcher(req,resp,"relatorio.jsp");

        }
    }

    protected void Dispatcher(HttpServletRequest req, HttpServletResponse resp, String caminho) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/"+caminho);
        dispatcher.forward(req,resp);
    }
}
