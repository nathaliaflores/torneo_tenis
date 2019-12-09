
package controlador;

import conexion.Conexion;
import dao.NacionalidadDao;
import dao.PaisDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Nacionalidad;
import modelo.Pais;


public class NacionalidadServlet extends HttpServlet {

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
        NacionalidadDao nacionalidadDao = new NacionalidadDao(conn);
        
        List<Nacionalidad> nacionalidades = nacionalidadDao.obtenerTodos();
        
        request.setAttribute("nacionalidades", nacionalidades);
        rd = request.getRequestDispatcher("/nacionalidades.jsp");
        rd.forward(request, response);
        
    }
    protected void obtenerUno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        NacionalidadDao nacionalidadDao = new NacionalidadDao(conn);
        PaisDao paisDao = new PaisDao(conn);
        
        int idNacionalidad = Integer.parseInt(request.getParameter("idNacionalidad"));
        
        Nacionalidad nacionalidad = nacionalidadDao.obtenerUno(idNacionalidad);
        List<Pais> paises = paisDao.obtenerTodos();
        
        request.setAttribute("nacionalidad", nacionalidad);
        request.setAttribute("paises", paises);
        rd = request.getRequestDispatcher("/nacionalidades-editar.jsp");
        rd.forward(request, response);
    }
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        NacionalidadDao nacionalidadDao = new NacionalidadDao(conn);
        Nacionalidad nacionalidad = new Nacionalidad();
        String msg = "";
        
        nacionalidad.setNombre(request.getParameter("nombre"));
        nacionalidad.setIdPais(Integer.parseInt(request.getParameter("idPais")));
        
        boolean res = nacionalidadDao.insertar(nacionalidad);
        List<Nacionalidad> nacionalidades = nacionalidadDao.obtenerTodos();
        
        if(res){
            msg = "INSERTADO";
        }
        else{
            msg = "NO INSERTADO";
        }
        
        request.setAttribute("nacionalidades", nacionalidades);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/nacionalidades.jsp");
       rd.forward(request, response);
    }
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        NacionalidadDao nacionalidadDao = new NacionalidadDao(conn);
        Nacionalidad nacionalidad = new Nacionalidad();
        String msg = "";
        
        nacionalidad.setIdNacionalidad(Integer.parseInt(request.getParameter("idNacionalidad")));
        nacionalidad.setNombre(request.getParameter("nombre"));
        nacionalidad.setIdPais(Integer.parseInt(request.getParameter("idPais")));
        
        boolean res = nacionalidadDao.actualizar(nacionalidad);
        List<Nacionalidad> nacionalidades = nacionalidadDao.obtenerTodos();
        
        if(res){
            msg = "ACTUALIZADO";
        }
        else{
            msg = "NO ACTUALIZADO";
        }
        
        request.setAttribute("nacionalidades", nacionalidades);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/nacionalidades.jsp");
       rd.forward(request, response);
    }
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        NacionalidadDao nacionalidadDao = new NacionalidadDao(conn);
        String msg = "";
        
        int idNacionalidad = Integer.parseInt(request.getParameter("idLugarTorne"));
        
        boolean res = nacionalidadDao.eliminar(idNacionalidad);
        
        List<Nacionalidad> nacionalidades = nacionalidadDao.obtenerTodos();
        
        if(res){
            msg = "ACTUALIZADO";
        }
        else{
            msg = "NO ACTUALIZADO";
        }
        
        request.setAttribute("nacionalidades", nacionalidades);
       request.setAttribute("msg", msg);
       rd = request.getRequestDispatcher("/nacionalidades.jsp");
       rd.forward(request, response);
    }
    protected void cargarFormularioInsertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        PaisDao paisDao = new PaisDao(conn);
        
        List<Pais> paises = paisDao.obtenerTodos();
        
        
        request.setAttribute("paises", paises);
        rd = request.getRequestDispatcher("/nacionalidades-insertar.jsp");
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
