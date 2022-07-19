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
    private Statement stm;
    private Factory f;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.f = new Factory();
        this.f.setConnection("jdbc:mysql://localhost:3306/bluesupermarket?useTimezone=true&serverTimezone=UTC&useSSL=false");
        try {
            this.stm = this.f.getC().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int id = 1;
        NotaFiscalDao notaFiscalDao = null;
        try {
            notaFiscalDao = new NotaFiscalDao(stm.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        NotaFiscal notaFiscal = notaFiscalDao.busca(id);
        resp.setContentType("application/json");
        resp.getWriter().print(notaFiscal.toJson());
    }

}
