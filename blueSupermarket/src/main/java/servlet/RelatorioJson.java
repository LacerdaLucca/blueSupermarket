package servlet;

import DAO.CarrinhoDao;
import com.google.gson.Gson;
import model.Compra;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/sistema/relatorio/json")
public class RelatorioJson extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Compra> listaCompraPorData = new ArrayList<>();

        String data = req.getParameter("data");

        if (data!=null){
            listaCompraPorData.addAll(new CarrinhoDao().buscaCompraPorData(data));

            String json= new Gson().toJson(listaCompraPorData);
            req.setAttribute("compra",json);
            req.getRequestDispatcher("/WEB-INF/views/buscaCompraPorData.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","Digite um valor valido");
            resp.sendRedirect("/blueSupermarket/relatorios/json");
        }

    }

}
