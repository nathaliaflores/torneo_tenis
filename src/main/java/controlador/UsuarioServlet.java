package controlador;

import conexion.Conexion;
import dao.PaisDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pais;
import modelo.Usuario;

public class UsuarioServlet extends HttpServlet {

    RequestDispatcher rd;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "obtenerUsuario":
                obtenerUsuario(request, response);
                break;
        }
    }

    protected void obtenerUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion con = new Conexion();
        UsuarioDao usuarioDao = new UsuarioDao(con);
        String msg = "";
        String pagina = "";
        
        String usuarioLogin = request.getParameter("usuario");
        String passwordLogin = request.getParameter("password");
        
        Usuario usuario = usuarioDao.obtenerUsuario(usuarioLogin, passwordLogin);
        if(usuario != null){
            msg = usuario.getUsuario();
            pagina = "/modulos.jsp";
        }
        else{
            msg = "Usuario o Password invalido!";
            pagina = "/index.jsp";
        }
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher(pagina);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
