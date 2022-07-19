package filter;

import model.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/sistema/*")
public class AutorizacaFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession hs = req.getSession();
        Usuario usuario = (Usuario) hs.getAttribute("usuario");

        if (usuario == null) {
            req.getRequestDispatcher("/loginForm").forward(req, resp);
            return;
        }

        chain.doFilter(request, response);
    }
}
