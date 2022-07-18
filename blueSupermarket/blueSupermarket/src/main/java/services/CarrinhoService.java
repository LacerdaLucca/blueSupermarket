package services;

import DAO.ProdutosDao;
import model.ListaIdCarrinho;
import model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoService {
    private List<Produto> listaProdutos=null;

    public Produto addProdutoCarrinho(int id) {
        Produto produto = new ProdutosDao().getProdutosPorId(id);
        return produto;
    }

    public void deletarProdPorID(int idDel){
        try {
            new CarrinhoDao().deletarCarrinho(idDel);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar do carrinho, produto não encontrado");
        }
    }

    public List<Produto> listaProd(){
        List<Produto> listaProduto=new ArrayList<>();
        List<ListaIdCarrinho> listaProdCarrinhos = new ArrayList<>();
        try {
            listaProdCarrinhos.addAll(new CarrinhoDao().listaProdutosCarrinho());
            System.out.println(listaProdCarrinhos.size());
            for (int i = 0; i < listaProdCarrinhos.size(); i++) {
                listaProduto.add(new ProdutosDao().getProdutosPorId(listaProdCarrinhos.get(i).getIdProd()));
            }
            return listaProduto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void esvaziarCarrinho(){
        try {
            new CarrinhoDao().truncateCarrinho();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar do carrinho, produto não encontrado");
        }
    }

}
