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

@WebServlet("/carrinho")
public class CarrinhoServlet extends HttpServlet {   
	private static final long serialVersionUID = 1L;
	private List<Produto> listProdutos= new ArrayList<>();

    public CarrinhoServlet(){
        new ProdutosDao().updateProdutos();
    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        System.out.println(id);
    }
}
