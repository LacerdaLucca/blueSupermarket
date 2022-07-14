package services;

import DAO.ProdutosDao;
import model.Produto;

import java.util.List;

public class CarrinhoService {
    private List<Produto> listaProdutos;

    public void addProdutoCarrinho(int id) {
        Produto produto = new ProdutosDao().getProdutosPorId(id);
//int ID,String nome,String desc,double preco, int quant,java.util.Date validade
        listaProdutos.add(new Produto(produto.getID(), produto.getNome(), produto.getDesc(), produto.getPreco(), produto.getQuantidade(), produto.getValidade()));

//        return listaProdutos;
        for (Produto produtoList: listaProdutos ) {
            System.out.println(produtoList.getNome());
        }
    }

}
