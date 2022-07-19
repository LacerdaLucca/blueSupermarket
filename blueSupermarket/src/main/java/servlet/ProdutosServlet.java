package servlet;

import DAO.CarrinhoDao;
import DAO.ProdutosDao;
import model.Produto;
import services.CarrinhoService;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listProdutos.clear();
        new CarrinhoService().esvaziarCarrinho();
        listProdutos.addAll(new ProdutosDao().getProdutos());
            request.setAttribute("listaProdutos", listProdutos);
            request.getRequestDispatcher("/index.jsp").forward(request,response);


    }
}
