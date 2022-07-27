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

        String idParam = req.getParameter("id");
        if(idParam!=null){
            int id= Integer.parseInt(idParam);
            Produto produto= new ProdutosDao().getProdutosPorId(id);

            String json= new Gson().toJson(produto);
            req.setAttribute("produto",json);
            try{
                req.getRequestDispatcher("/WEB-INF/views/buscaProdJason.jsp").forward(req,resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            String json= new Gson().toJson(listaProdJson);

            req.setAttribute("produtos", json);
            req.getRequestDispatcher("/WEB-INF/views/produtosJson.jsp").forward(req,resp);

        }
    }
}
