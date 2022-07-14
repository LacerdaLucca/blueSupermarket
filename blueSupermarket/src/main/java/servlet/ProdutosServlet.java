package servlet;

import DAO.ProdutosDao;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/produtos")
public class ProdutosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Produto> listProdutos= new ArrayList<>();

    public ProdutosServlet(){
        new ProdutosDao().updateProdutos();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listProdutos.addAll(new ProdutosDao().getProdutos());
        for (Produto produt:listProdutos ) {
            System.out.println(produt.getNome());

        }
        request.setAttribute("listaProdutos", listProdutos);
        request.getRequestDispatcher("/WEB-INF/views/listaProdutos.jsp").forward(request,response);

    }
}
