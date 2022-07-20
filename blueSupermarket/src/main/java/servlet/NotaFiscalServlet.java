package servlet;

import DAO.NotaFiscalDao;
import factory.Factory;
import model.NotaFiscal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/sistema/ultimaCompra")
public class NotaFiscalServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NotaFiscalDao notaFiscalDao = null;
        try {
            notaFiscalDao = new NotaFiscalDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        NotaFiscal notaFiscal = notaFiscalDao.busca((int)req.getAttribute("notaFiscal"));
        resp.setContentType("application/json");
        resp.getWriter().print(notaFiscal.toJson());
    }

}
