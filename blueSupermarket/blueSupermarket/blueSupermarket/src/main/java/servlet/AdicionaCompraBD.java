package servlet;

import model.Produto;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/finalizar")
public class AdicionaCompraBD extends HttpServlet {
    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
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

//         listaProdutos.addAll(new CarrinhoServlet().getListProdutosCarrinho());
        System.out.println(this.listaProdutos.size());
        Carrinho carrinho = new Carrinho();

        double total= listaProdutos.get(listaProdutos.size()-1).getValorTotal();
        int[] quant = null;
        quant[0]=0;
        for (int i = 0; i < listaProdutos.size(); i++) {
            for (int j = 0; j < listaProdutos.size() ; j++) {
                if(i==j){
                    quant[i]++;
                }
            }
        }
        int quantidade = quant.length;

        for (int i = 0; i < quantidade; i++) {
            carrinho.setIdProdutos(listaProdutos.get(i).getID());
            carrinho.setQtn(quant[i]);
            carrinho.setCpfUsuario(cpf);
            carrinho.setCep(cep);
            carrinho.setValorFrete(Double.parseDouble(valorFrete));
            carrinho.setPrazoEntrega(Integer.parseInt(prazo));
        }
        carrinho.setValorTotal(total);

        try{
            new CarrinhoDao().dropCarrinho();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
