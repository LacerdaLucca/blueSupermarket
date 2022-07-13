package servlet;

import DAO.UsuarioDao;
import model.Usuario;
import services.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {


    UsuarioService usuarioService = new UsuarioService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        UsuarioDao teste = new UsuarioDao();
        System.out.println(cpf);
        // Usuario u = teste.consultarUsuarioPorCpf(cpf);
        //    System.out.println(u);
        //   teste.deletarPorCpf(cpf);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String cep = request.getParameter("cep");
        String endereco = request.getParameter("endereco");

        usuarioService.insereUsuario(nome, cpf, senha, cep, endereco);





    }


}
