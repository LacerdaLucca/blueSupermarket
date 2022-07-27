package services;

import DAO.CarrinhoDao;
import DAO.ProdutosDao;
import model.Carrinho;
import model.Produto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoService {
    private List<Produto> listaProdutos=null;

    public Produto addProdutoCarrinho(int id) {
        Produto produto = new ProdutosDao().getProdutosPorId(id);
        return produto;
    }

    public void deletarProdPorID(int idDel){
        new CarrinhoDao().deletarCarrinho(idDel);
    }

    public List<Produto> listaProd(){
        List<Produto> listaProduto=new ArrayList<>();
        List<Carrinho> listaProdCarrinhos = new ArrayList<>();
        listaProdCarrinhos.addAll(new CarrinhoDao().listaProdutosCarrinho());
        System.out.println(listaProdCarrinhos.size());
        for (int i = 0; i < listaProdCarrinhos.size(); i++) {
            listaProduto.add(new ProdutosDao().getProdutosPorId(listaProdCarrinhos.get(i).getIdProd()));
        }
        return listaProduto;
    }
    public void esvaziarCarrinho(){
        new CarrinhoDao().truncateCarrinho();
    }

    public String dataCompra() {
        LocalDate dataAgora = LocalDate.now();
        String dia = String.valueOf(dataAgora.getDayOfMonth());
        String mes = String.valueOf(dataAgora.getMonthValue());
        String ano = String.valueOf(dataAgora.getYear());
        return dia+"/" + mes +"/" +ano;
    }

}
