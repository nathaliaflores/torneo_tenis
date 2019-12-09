package controlador;

import conexion.Conexion;
import dao.PaisDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pais;

public class PaisServlet extends HttpServlet {

    RequestDispatcher rd;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "obtenerTodos":
                obtenerTodos(request, response);
                break;
            case "obtenerUno":
                obtenerUno(request, response);
                break;
            case "insertar":
                insertar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;

        }
    }

    protected void obtenerTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion con = new Conexion();
        PaisDao paisDao = new PaisDao(con);

        List<Pais> paises = paisDao.obtenerTodos();

        request.setAttribute("paises", paises);
        rd = request.getRequestDispatcher("/paises.jsp");
        rd.forward(request, response);
    }

    protected void obtenerUno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion con = new Conexion();
        PaisDao paisDao = new PaisDao(con);
        
        int idPais = Integer.parseInt(request.getParameter("idPais"));
        Pais pais = paisDao.obtenerUno(idPais);

        request.setAttribute("pais", pais);
        rd = request.getRequestDispatcher("/paises-editar.jsp");
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion con = new Conexion();
        PaisDao paisDao = new PaisDao(con);
        Pais pais = new Pais();
        String msg = "";
        
        pais.setNombre(request.getParameter("nombre"));
        boolean respuesta = paisDao.insertar(pais);
        List<Pais> paises = paisDao.obtenerTodos();
        
        if(respuesta){
            msg = "INSERTADO";
        }
        else{
            msg = "NO INSERTADO";
        }
        
        
        request.setAttribute("pais", pais);
        request.setAttribute("paises", paises);
        rd = request.getRequestDispatcher("/paises.jsp");
        rd.forward(request, response);
        
        
        
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion con = new Conexion();
        PaisDao paisDao = new PaisDao(con);
        Pais pais = new Pais();
        String msg = "";
        
        pais.setIdPais(Integer.parseInt(request.getParameter("idPais")));
        pais.setNombre(request.getParameter("nombre"));
        
        boolean respuesta = paisDao.actualizar(pais);
        List<Pais> paises = paisDao.obtenerTodos();
        
        if(respuesta){
            msg = "ACTUALIZADO";
        }
        else{
            msg = "NO  ACTUALIZADO";
        }
        
        
        request.setAttribute("msg", msg);
        request.setAttribute("paises", paises);
        rd = request.getRequestDispatcher("/paises.jsp");
        rd.forward(request, response);
        
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Conexion con = new Conexion();
        PaisDao paisDao = new PaisDao(con);
        String msg = "";
        
        int idPais = Integer.parseInt(request.getParameter("idPais"));
        
        boolean respuesta = paisDao.eliminar(idPais);
        List<Pais> paises = paisDao.obtenerTodos();
        
        if(respuesta){
            msg = "ELIMINADO";
        }
        else{
            msg = "NO ELIMINADO";
        }
        
        
        request.setAttribute("msg", msg);
        request.setAttribute("paises", paises);
        rd = request.getRequestDispatcher("/paises.jsp");
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
