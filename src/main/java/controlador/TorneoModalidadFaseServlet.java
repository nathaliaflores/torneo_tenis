
package controlador;

import conexion.Conexion;
import dao.FaseDao;
import dao.ModalidadDao;
import dao.TorneoDao;
import dao.TorneoModalidadFaseDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Fase;
import modelo.Modalidad;
import modelo.Torneo;
import modelo.TorneoModalidadFase;


public class TorneoModalidadFaseServlet extends HttpServlet {

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
        TorneoModalidadFaseDao tmfDao = new TorneoModalidadFaseDao(conn);
        
        List<TorneoModalidadFase> tmfs = tmfDao.obtenerTodos();
        
        request.setAttribute("tmfs", tmfs);
        rd = request.getRequestDispatcher("/tmf.jsp");
        rd.forward(request, response);

    }
    protected void obtenerUno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoModalidadFaseDao tmfDao = new TorneoModalidadFaseDao(conn);
        TorneoDao torneoDao = new TorneoDao(conn);
        ModalidadDao modalidadDao = new ModalidadDao(conn);
        FaseDao faseDao = new FaseDao(conn);
        
        int idTmf = Integer.parseInt(request.getParameter("idTmf"));
        
        TorneoModalidadFase tmf = tmfDao.obtenerUno(idTmf);
        
        List<Torneo>  torneos = torneoDao.obtenerTodos();
        List<Modalidad> modalidades = modalidadDao.obtenerTodos();
        List<Fase>  fases = faseDao.obtenerTodos();
        
        request.setAttribute("tmf", tmf);
        request.setAttribute("torneos", torneos);
        request.setAttribute("modalidades", modalidades);
        request.setAttribute("fases", fases);
        rd = request.getRequestDispatcher("/tmf-editar.jsp");
        rd.forward(request, response);
        
    }
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoModalidadFaseDao tmfDao = new TorneoModalidadFaseDao(conn);
        TorneoModalidadFase tmf = new TorneoModalidadFase();
        String msg = "";
        
        tmf.setIdTorneo(Integer.parseInt(request.getParameter("idTorneo")));
        tmf.setIdModalidad(Integer.parseInt(request.getParameter("idModalidad")));
        tmf.setIdFase(Integer.parseInt(request.getParameter("idFase")));
        tmf.setPremioConsuelo(Double.parseDouble(request.getParameter("premioConsuelo")));
        
        boolean res = tmfDao.insertar(tmf);
        List<TorneoModalidadFase> tmfs = tmfDao.obtenerTodos();
        
        if(res){
            msg = "INSERTADO";
        }
        else{
            msg = "NO INSERTADO";
        }
        
       request.setAttribute("tmfs", tmfs);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/tmf.jsp");
       rd.forward(request, response);
       
    }
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoModalidadFaseDao tmfDao = new TorneoModalidadFaseDao(conn);
        TorneoModalidadFase tmf = new TorneoModalidadFase();
        String msg = "";
        
        tmf.setIdTmf(Integer.parseInt(request.getParameter("idTmf")));
        tmf.setPremioConsuelo(Double.parseDouble(request.getParameter("premioConsuelo")));
        tmf.setIdTorneo(Integer.parseInt(request.getParameter("idTorneo")));
        tmf.setIdModalidad(Integer.parseInt(request.getParameter("idModalidad")));
        tmf.setIdFase(Integer.parseInt(request.getParameter("idFase")));
        
        boolean res = tmfDao.actualizar(tmf);
        List<TorneoModalidadFase> tmfs = tmfDao.obtenerTodos();
        
        if(res){
            msg = "ACTUALIZADO";
        }
        else{
            msg = "NO ACTUALIZADO";
        }
        
       request.setAttribute("tmfs", tmfs);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/tmf.jsp");
       rd.forward(request, response);
    }
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoModalidadFaseDao tmfDao = new TorneoModalidadFaseDao(conn);
        String msg = "";
        
        int idTmf = Integer.parseInt(request.getParameter("idTmf"));
        
        boolean res = tmfDao.eliminar(idTmf);
        
        List<TorneoModalidadFase> tmfs = tmfDao.obtenerTodos();
        
        if(res){
            msg = "ELIMINADO";
        }
        else{
            msg = "NO ELIMINADO";
        }
        
       request.setAttribute("tmfs", tmfs);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/tmf.jsp");
       rd.forward(request, response);
    }
    protected void cargarFormularioInsertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        TorneoDao torneoDao = new TorneoDao(conn);
        ModalidadDao modalidadDao = new ModalidadDao(conn);
        FaseDao faseDao = new FaseDao(conn);
        
        List<Torneo>  torneos = torneoDao.obtenerTodos();
        List<Modalidad> modalidades = modalidadDao.obtenerTodos();
        List<Fase>  fases = faseDao.obtenerTodos();
         
       request.setAttribute("torneos", torneos);
       request.setAttribute("modalidades", modalidades);
       request.setAttribute("fases", fases);
       rd = request.getRequestDispatcher("/tmf-insertar.jsp");
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
