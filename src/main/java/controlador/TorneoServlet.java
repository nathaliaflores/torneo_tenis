
package controlador;

import conexion.Conexion;
import dao.LugarTorneoDao;
import dao.TorneoDao;
import dao.PaisDao;
import dao.TorneoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.LugarTorneo;
import modelo.Torneo;
import modelo.Pais;
import modelo.Torneo;


public class TorneoServlet extends HttpServlet {

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
        TorneoDao torneoDao = new TorneoDao(conn);
        
        List<Torneo> torneos = torneoDao.obtenerTodos();
        
        request.setAttribute("torneos", torneos);
        rd = request.getRequestDispatcher("/torneos.jsp");
        rd.forward(request, response);
        
    }
    protected void obtenerUno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoDao torneoDao = new TorneoDao(conn);
        LugarTorneoDao lugarTorneoDao = new LugarTorneoDao(conn);
        
        int idTorneo = Integer.parseInt(request.getParameter("idTorneo"));
        
        Torneo torneo = torneoDao.obtenerUno(idTorneo);
        List<LugarTorneo> lugarTorneos = lugarTorneoDao.obtenerTodos();
        
        request.setAttribute("lugarTorneos", lugarTorneos);
        request.setAttribute("torneo", torneo);
        rd = request.getRequestDispatcher("/torneos-editar.jsp");
        rd.forward(request, response);
    }
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoDao torneoDao = new TorneoDao(conn);
        Torneo torneo = new Torneo();
        String msg = "";
        
        torneo.setNombre(request.getParameter("nombre"));
        torneo.setAnio(request.getParameter("anio"));
        torneo.setPremio(Double.parseDouble(request.getParameter("premio")));
        torneo.setIdLugarTorneo(Integer.parseInt(request.getParameter("idLugarTorneo")));
        
        
        boolean res = torneoDao.insertar(torneo);
        List<Torneo> torneos = torneoDao.obtenerTodos();
        
        if(res){
            msg = "INSERTADO";
        }
        else{
            msg = "NO INSERTADO";
        }
        
        request.setAttribute("torneos", torneos);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/torneos.jsp");
       rd.forward(request, response);
    }
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoDao torneoDao = new TorneoDao(conn);
        Torneo torneo = new Torneo();
        String msg = "";
        
        torneo.setIdTorneo(Integer.parseInt(request.getParameter("idTorneo")));
        torneo.setNombre(request.getParameter("nombre"));
        torneo.setAnio(request.getParameter("anio"));
        torneo.setPremio(Double.parseDouble(request.getParameter("premio")));
        torneo.setIdLugarTorneo(Integer.parseInt("idLugarTorneo"));
        
        boolean res = torneoDao.actualizar(torneo);
        List<Torneo> torneos = torneoDao.obtenerTodos();
        
        if(res){
            msg = "ACTUALIZADO";
        }
        else{
            msg = "NO ACTUALIZADO";
        }
        
        request.setAttribute("torneos", torneos);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/torneos.jsp");
       rd.forward(request, response);
    }
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoDao torneoDao = new TorneoDao(conn);
        String msg = "";
        
        int idTorneo = Integer.parseInt(request.getParameter("idTorneo"));
        
        boolean res = torneoDao.eliminar(idTorneo);
        
        List<Torneo> torneos = torneoDao.obtenerTodos();
        
        if(res){
            msg = "ELIMINADO";
        }
        else{
            msg = "NO ELIMINADO";
        }
        
        request.setAttribute("torneos", torneos);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/torneos.jsp");
       rd.forward(request, response);
    }
    protected void cargarFormularioInsertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        LugarTorneoDao lugarTorneoDao = new LugarTorneoDao(conn);
        List<LugarTorneo> lugarTorneos = lugarTorneoDao.obtenerTodos();
        
        
        request.setAttribute("lugarTorneos", lugarTorneos);
        rd = request.getRequestDispatcher("/torneos-insertar.jsp");
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
