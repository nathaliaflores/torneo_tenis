
package controlador;

import conexion.Conexion;
import dao.LugarTorneoDao;
import dao.PaisDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.LugarTorneo;
import modelo.Pais;


public class LugarTorneoServlet extends HttpServlet {

    RequestDispatcher rd;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");
        switch(action){
            case "obtenerTodos" : 
                obtenerTodos(request, response); 
                break;
            case "obtenerUno" : 
                obtenerUno(request, response); 
                break;
            case "insertar" : 
                insertar(request, response); 
                break;
            case "actualizar" : 
                actualizar(request, response); 
                break;
            case "eliminar" : 
                eliminar(request, response); 
                break;
            case "cargarFormularioInsertar" : 
                cargarFormularioInsertar(request, response); 
                break;
        }
    }


    protected void obtenerTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        LugarTorneoDao lugarTorneoDao = new LugarTorneoDao(conn);
        
        List<LugarTorneo> lugarTorneos = lugarTorneoDao.obtenerTodos();
        
        request.setAttribute("lugarTorneos", lugarTorneos);
        rd = request.getRequestDispatcher("/lugar-torneos.jsp");
        rd.forward(request, response);
        
    }
    protected void obtenerUno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        LugarTorneoDao lugarTorneoDao = new LugarTorneoDao(conn);
        PaisDao paisDao = new PaisDao(conn);
        
        int idLugarTorneo = Integer.parseInt(request.getParameter("idLugarTorneo"));
        
        LugarTorneo lugarTorneo = lugarTorneoDao.obtenerUno(idLugarTorneo);
        List<Pais> paises = paisDao.obtenerTodos();
        
        request.setAttribute("lugarTorneo", lugarTorneo);
        request.setAttribute("paises", paises);
        rd = request.getRequestDispatcher("/lugar-torneos-editar.jsp");
        rd.forward(request, response);
    }
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        LugarTorneoDao lugarTorneoDao = new LugarTorneoDao(conn);
        LugarTorneo lugarTorneo = new LugarTorneo();
        String msg = "";
        
        lugarTorneo.setNombre(request.getParameter("nombre"));
        lugarTorneo.setIdPais(Integer.parseInt(request.getParameter("idPais")));
        
        boolean res = lugarTorneoDao.insertar(lugarTorneo);
        List<LugarTorneo> lugarTorneos = lugarTorneoDao.obtenerTodos();
        
        if(res){
            msg = "INSERTADO";
        }
        else{
            msg = "NO INSERTADO";
        }
        
        request.setAttribute("lugarTorneos", lugarTorneos);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/lugar-torneos.jsp");
       rd.forward(request, response);
    }
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        LugarTorneoDao lugarTorneoDao = new LugarTorneoDao(conn);
        LugarTorneo lugarTorneo = new LugarTorneo();
        String msg = "";
        
        lugarTorneo.setIdLugarTorneo(Integer.parseInt(request.getParameter("idLugarTorneo")));
        lugarTorneo.setNombre(request.getParameter("nombre"));
        lugarTorneo.setIdPais(Integer.parseInt(request.getParameter("idPais")));
        
        boolean res = lugarTorneoDao.actualizar(lugarTorneo);
        List<LugarTorneo> lugarTorneos = lugarTorneoDao.obtenerTodos();
        
        if(res){
            msg = "ACTUALIZADO";
        }
        else{
            msg = "NO ACTUALIZADO";
        }
        
       request.setAttribute("lugarTorneos", lugarTorneos);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/lugar-torneos.jsp");
       rd.forward(request, response);
    }
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        LugarTorneoDao lugarTorneoDao = new LugarTorneoDao(conn);
        String msg = "";
        
        int idLugarTorneo = Integer.parseInt(request.getParameter("idLugarTorneo"));
        
        boolean res = lugarTorneoDao.eliminar(idLugarTorneo);
        
        List<LugarTorneo> lugarTorneos = lugarTorneoDao.obtenerTodos();
        
        if(res){
            msg = "ELIMINADO";
        }
        else{
            msg = "NO ELIMINADO";
        }
        
        request.setAttribute("lugarTorneos", lugarTorneos);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/lugar-torneos.jsp");
       rd.forward(request, response);
    }
    protected void cargarFormularioInsertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        PaisDao paisDao = new PaisDao(conn);
        
        List<Pais> paises = paisDao.obtenerTodos();
        
        
        request.setAttribute("paises", paises);
        rd = request.getRequestDispatcher("/lugar-torneos-insertar.jsp");
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
