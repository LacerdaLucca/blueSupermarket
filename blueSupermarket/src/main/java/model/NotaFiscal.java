package model;

import DAO.CarrinhoDao;
import DAO.UsuarioDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.sql.SQLException;
import java.util.List;

public class NotaFiscal {

    private int id;
    private String cpfUsuario;
    private int idCarrinho;
    private static Empresa empresa;

    public NotaFiscal(int id, int idCarrinho, String cpfUsuario){
        empresa = new Empresa("Blue Company","00.000.000/0001-01","1");
        this.id = id;
        this.cpfUsuario = cpfUsuario;
        this.idCarrinho = idCarrinho;
    }

    public NotaFiscal(String cpfUsuario, int idCarrinho) {
        this.cpfUsuario = cpfUsuario;
        this.idCarrinho = idCarrinho;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toJson() {
        UsuarioDao usuarioDao = new UsuarioDao();
        CarrinhoDao carrinhoDao = null;
        try {
            carrinhoDao = new CarrinhoDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Usuario usuario = usuarioDao.consultarUsuarioPorCpf(this.cpfUsuario);
        String nome = usuario.getNome();
        List<Compra> carrinho = carrinhoDao.listaUltimaCompra(cpfUsuario);
        String jsonData = "{\"Empresa\":\""+empresa.getNome()+"\",\"CNPJ\":\""+empresa.getCnpj()+"\",\"Usuario\":"+nome+",\"CPF\":"+this.cpfUsuario+",\"Carrinho\":"+carrinho+"}";
        JsonElement jsonElement = new JsonParser().parse(jsonData);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonElement);
    }
}
