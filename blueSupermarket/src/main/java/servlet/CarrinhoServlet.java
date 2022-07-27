package servlet;

import DAO.CarrinhoDao;
import model.Produto;
import services.CarrinhoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/sistema/carrinho")
public class CarrinhoServlet extends HttpServlet {   
	private static final long serialVersionUID = 1L;
    private double valorTotal;
    private List<Produto> listProdutosCarrinho= new ArrayList<>();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        new CarrinhoDao().truncateCarrinho();

        String paramDel = request.getParameter("del");
        String paramAdd=request.getParameter("add");
        String paramSalvar = request.getParameter("salvar");
        String quantCarr =request.getParameter("quant");
        String idCalcQtn =request.getParameter("id");

        if (paramDel== null && paramAdd== null && paramSalvar==null &quantCarr==null) {

            request.setAttribute("produtos", listProdutosCarrinho);
            request.getRequestDispatcher("/WEB-INF/views/carrinho.jsp").forward(request, response);
        }else if(quantCarr!=null & idCalcQtn!=null){
            int quant = Integer.parseInt(quantCarr);
            int idQtn = Integer.parseInt(idCalcQtn);
            Produto prod = new CarrinhoService().addProdutoCarrinho(idQtn);
            double valorTotalQtn = prod.getPreco()*quant;
            System.out.println(valorTotalQtn);
            for (int i = 0; i < listProdutosCarrinho.size(); i++) {
                if (listProdutosCarrinho.get(i).getIdProd()==(prod.getIdProd())) {
                    listProdutosCarrinho.get(i).setQuantidade(quant);
                    listProdutosCarrinho.get(i).setValorTotal(valorTotalQtn);
                }
            }
            for (Produto produ: listProdutosCarrinho ) {
                System.out.println(produ.getValorTotal());
                System.out.println(produ.getQuantidade());
            }
            response.sendRedirect("/blueSupermarket/sistema/carrinho");
        }else if (paramSalvar!=null) {
            CarrinhoDao carrinhoDao = new CarrinhoDao();
            carrinhoDao.adicionaCarrinho(listProdutosCarrinho);
            request.getRequestDispatcher("/WEB-INF/views/formCep.jsp").forward(request, response);
        }else if(paramDel== null){
                String id = request.getParameter("add");
                int idProd = Integer.parseInt(id);
                Produto produto = new CarrinhoService().addProdutoCarrinho(idProd);
                valorTotal+= produto.getPreco();
                this.listProdutosCarrinho.add(new Produto(produto.getIdProd(), produto.getNome(), produto.getDesc(), produto.getPreco(),1 , produto.getValidade(), valorTotal));

                response.sendRedirect("/blueSupermarket/");
        }else{
                String id = request.getParameter("del");
                int idDel = Integer.parseInt(id);
                int index = 0;
                for (Produto produto: listProdutosCarrinho) {
                    if(produto.getIdProd() == idDel){
                        index = listProdutosCarrinho.indexOf(produto);
                    }
                }
                listProdutosCarrinho.remove(index);
                new CarrinhoService().deletarProdPorID(idDel);
                request.setAttribute("produtos", listProdutosCarrinho);
                request.getRequestDispatcher("/WEB-INF/views/carrinho.jsp").forward(request,response);


        }
    }
}
