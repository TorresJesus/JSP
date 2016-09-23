/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utng.dao.ChoferDAOImp;
import utng.model.Chofer;
import utng.dao.ChoferDAO;

/**
  3 *
 * @author Erick
 */
public class ChoferController extends HttpServlet {
    
    private static final String LISTA_CHOFER = "/listaChofer.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/choferes.jsp";
    private ChoferDAO dao;
    
    public ChoferController() {
        dao = new ChoferDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_CHOFER;
            int idChofer = Integer.parseInt(request.getParameter("idChofer"));
            dao.borrarChofer(idChofer);
            request.setAttribute("choferes", dao.desplegarChofer());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int idChofer = Integer.parseInt(request.getParameter("idChofer"));
            Chofer chofer = dao.elegirChofer(idChofer);
            request.setAttribute("chofer", chofer);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_CHOFER;
            request.setAttribute("choferes", dao.desplegarChofer());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Chofer chofer = new Chofer();
        String idChofer = request.getParameter("idChofer");
        chofer.setNombre(request.getParameter("nombre"));
        chofer.setEmail(request.getParameter("email"));
        chofer.setTelefono(Integer.parseInt(request.getParameter("telefono")));
        chofer.setDireccion(request.getParameter("direccion"));
        chofer.setEdad(Integer.parseInt(request.getParameter("edad")));
        if (idChofer == null || idChofer.isEmpty()) {
            dao.agregarChofer(chofer);
        } else {
            chofer.setIdChofer(Integer.parseInt(idChofer));
            dao.cambiarChofer(chofer);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CHOFER);
        request.setAttribute("choferes", dao.desplegarChofer());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
