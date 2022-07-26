package servlet;

import DAO.CarrinhoDao;
import DAO.RelatoriosDao;
import model.Relatorio;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sistema/relatorio")
public class RelatoriosServlets extends HttpServlet {
    private List<Relatorio> relatoriosPorData = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        relatoriosPorData.clear();

        String paramDataIn = req.getParameter("dataIn");
        String paramDataFim = req.getParameter("dataFim");
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        String getCpfUsuario = usuario.getCpf();
        if (paramDataIn == null & paramDataFim == null) {
            req.getRequestDispatcher("/WEB-INF/views/formDataRelatorio.jsp").forward(req, resp);
        } else if (paramDataIn != null & paramDataFim != null) {
            try {
                relatoriosPorData.addAll(new RelatoriosDao().listVendaPorData(paramDataIn, paramDataFim, getCpfUsuario));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println(relatoriosPorData.size());
            req.setAttribute("vendas", relatoriosPorData);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/relatorio.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
