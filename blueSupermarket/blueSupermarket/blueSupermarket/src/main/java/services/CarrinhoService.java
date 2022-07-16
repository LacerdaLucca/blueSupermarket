package services;

import DAO.ProdutosDao;
import model.Produto;

import java.util.List;

public class CarrinhoService {
    private List<Produto> listaProdutos=null;


    public Produto addProdutoCarrinho(int id) {
        Produto produto = new ProdutosDao().getProdutosPorId(id);
        return produto;
    }

}
