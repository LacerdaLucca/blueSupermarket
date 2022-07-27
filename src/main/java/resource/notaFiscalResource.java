package resource;

import DAO.NotaFiscalDao;
import factory.Factory;
import model.NotaFiscal;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.sql.Statement;

//@Path("/ultimaCompra")
//public class notaFiscalResource{
//
//    @Path("/")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public String busca() throws SQLException {
//        Statement stm;
//        Factory f;
//        f = new Factory();
//        f.setConnection("jdbc:mysql://localhost:3306/bluesupermarket?useTimezone=true&serverTimezone=UTC&useSSL=false");
//        stm = f.getC().createStatement();
//        System.out.println("CRIOU O RESOURCE");
//        int id = 1;
//        NotaFiscalDao notaFiscalDao = new NotaFiscalDao(stm.getConnection());
//        NotaFiscal notaFiscal = notaFiscalDao.busca(id);
//        return notaFiscal.toJson();
//    }
//}
