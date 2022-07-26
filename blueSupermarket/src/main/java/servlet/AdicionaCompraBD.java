package servlet;

import DAO.CarrinhoDao;
import DAO.NotaFiscalDao;
import model.*;
import services.CarrinhoService;
import services.FreteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sistema/finalizar")
public class AdicionaCompraBD extends HttpServlet {
    private List<Produto> listaProdutos= new ArrayList<>();
    private List<Carrinho> listaCarrinho=new ArrayList<>();

    public void service(HttpServletRequest req, HttpServletResponse resp){

        String cep = req.getParameter("cep");
        String valorFrete = req.getParameter("valor");
        String prazo = req.getParameter("prazo");
        String cpf = req.getParameter("usuario");

        listaCarrinho.addAll(new CarrinhoDao().listaProdutosCarrinho());
        listaProdutos.addAll(new CarrinhoService().listaProd());
        Compra compra = new Compra();

        double valorDoFrete = new FreteService().tratamentoValorFrete(valorFrete);

        int idUltimaCompra= new CarrinhoDao().buscarIdUltimaCompra()+1;


        for (int i = 0; i < listaProdutos.size(); i++) {
            compra.setIdProdutos(listaProdutos.get(i).getIdProd());
            compra.setNomeProd(listaProdutos.get(i).getNome());
            compra.setQtn(listaCarrinho.get(i).getQtn());
            compra.setCpfUsuario(cpf);
            compra.setCep(cep);
            compra.setValorFrete(valorDoFrete);
            compra.setPrazoEntrega(Integer.parseInt(prazo));
            compra.setDataCompra(new CarrinhoService().dataCompra());
            compra.setValorTotal(listaCarrinho.get(i).getValorTotal());
            new CarrinhoDao().inserirCompra(compra,idUltimaCompra);
        }
        new CarrinhoServlet().getListProdutosCarrinho().clear();
        try{
            new CarrinhoDao().truncateCarrinho();
            NotaFiscal nf = new NotaFiscalDao().adiciona(new NotaFiscal(cpf,compra.getIdCarrinhos()));
            System.out.println(nf.getId());
            req.setAttribute("notaFiscal",nf.getId());
            req.getRequestDispatcher("/sistema/ultimaCompra").forward(req,resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

}
