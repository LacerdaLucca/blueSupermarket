package resource;

import DAO.CarrinhoDao;
import model.Carrinho;
import model.Compra;
import model.Produto;
import services.CarrinhoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/carrinho")
@Produces(MediaType.APPLICATION_JSON)
public class carrinhoResource {

    @GET
    @Path("/{id}")
    public void inserirCarrinhoProdId(@PathParam("id") int id) throws SQLException {
        new CarrinhoService().addProdutoCarrinho(id);
    }

//
//    @GET
//    @Path("/delete/{id}")
//    public void delProdutoId(@PathParam("id") long idDel){
//        List<Produto> listProdutos = new CarrinhoService().getListaProdutos();
//        listProdutos.remove(idDel);
//    }

    @POST
    @Path("/salvarCarrinho")
    @Consumes(MediaType.APPLICATION_JSON)
    public void salvarCarrinho(@FormParam("carrinho") Compra compra) throws SQLException {
        new CarrinhoDao().inserirCompra(compra);

    }
}
