package servlet;

import DAO.CarrinhoDao;
import model.Carrinho;
import model.Produto;
import services.CarrinhoService;
import services.FreteService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/finalizar")
public class AdicionaCompraBD extends HttpServlet {
    private List<Produto> listaProdutos= new ArrayList<>();

    public void service(HttpServletRequest req, HttpServletResponse resp){

//  private int idCarrinhos;
//    private int idProdutos;
//    private int qtn;
//    private String cpfUsuario;
//    private String cep;
//    private double valorFrete;
//    private int prazoEntrega;
//    private double valorTotal;

        String cep = req.getParameter("cep");
        String valorFrete = req.getParameter("valor");
        String prazo = req.getParameter("prazo");
        String cpf = req.getParameter("usuario");

        listaProdutos.addAll(new CarrinhoService().listaProd());
        Carrinho carrinho = new Carrinho();
        int index = listaProdutos.size()-1;
        double valorTotal = listaProdutos.get(index).getValorTotal();

        for (int i = 0; i < listaProdutos.size(); i++) {
            carrinho.setIdProdutos(listaProdutos.get(i).getID());
            carrinho.setQtn(1);
            carrinho.setCpfUsuario(cpf);
            carrinho.setCep(cep);
            carrinho.setValorFrete(new FreteService().tratamentoValorFrete(valorFrete));
            carrinho.setPrazoEntrega(Integer.parseInt(prazo));
            carrinho.setValorTotal(valorTotal);
            try{
                new CarrinhoDao().inserirCompra(carrinho);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//        carrinho.setValorTotal(total);

        try{
            new CarrinhoDao().truncateCarrinho();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
