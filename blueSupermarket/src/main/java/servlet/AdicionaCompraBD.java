package servlet;

import DAO.CarrinhoDao;
import exception.LoginInvalidoException;
import model.Carrinho;
import model.Compra;
import model.Produto;
import services.CarrinhoService;
import services.CepService;
import services.FreteService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/finalizar")
public class AdicionaCompraBD extends HttpServlet {
    private List<Produto> listaProdutos= new ArrayList<>();

    public void service(HttpServletRequest req, HttpServletResponse resp){

        String cep = req.getParameter("cep");
        String valorFrete = req.getParameter("valor");
        String prazo = req.getParameter("prazo");
        String cpf = req.getParameter("usuario");
        if(!new CepService().verificaCep(cep))
            throw new LoginInvalidoException();
        listaProdutos.addAll(new CarrinhoService().listaProd());
        Compra compra = new Compra();

        for (int i = 0; i < listaProdutos.size(); i++) {
            compra.setIdProdutos(listaProdutos.get(i).getID());
            compra.setNomeProd(listaProdutos.get(i).getNome());
            compra.setQtn(1);
            compra.setCpfUsuario(cpf);
            compra.setCep(cep);
            compra.setValorFrete(new FreteService().tratamentoValorFrete(valorFrete));
            compra.setPrazoEntrega(Integer.parseInt(prazo));
            compra.setDataCompra(new CarrinhoService().dataCompra());
            try{
                new CarrinhoDao().inserirCompra(compra);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            new CarrinhoDao().truncateCarrinho();
            resp.sendRedirect("/blueSupermarket/");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
