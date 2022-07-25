package servlet;

import DAO.ProdutosDao;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/produto")
public class JsonPorId {
    public void service (HttpServletRequest request, HttpServletResponse response){

        String idParam = request.getParameter("id");
        int id= Integer.parseInt(idParam);
        Produto produto= new ProdutosDao().getProdutosPorId(id);

       
        try{
            request.getRequestDispatcher("/WEB-INF/views/buscaCep.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
