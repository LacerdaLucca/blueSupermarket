package servlet;


import DAO.ProdutosDao;
import com.google.gson.Gson;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/produtos/json")
public class ProdutosJason extends HttpServlet {
    List<Produto> listaProdJson=new ArrayList<>();

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listaProdJson.addAll(new ProdutosDao().getProdutos());

       String json= new Gson().toJson(listaProdJson);

        req.setAttribute("produtos", json);
        req.getRequestDispatcher("/WEB-INF/views/produtosJson.jsp").forward(req,resp);

    }


}
