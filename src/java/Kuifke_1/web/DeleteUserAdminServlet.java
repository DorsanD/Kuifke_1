/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kuifke_1.web;

import Kuifke_1.dao.WebsiteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dorsan
 */
@WebServlet(name = "DeleteUserAdminServlet", urlPatterns = {"/DeleteUserAdminServlet"})
public class DeleteUserAdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    //redirection naar de correcte pagina.
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/DeleteUserAdmin.jsp").forward(request, response);
    }


    //Functie om de account met die Id te verwijderen.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int CustomerId = Integer.parseInt(request.getParameter("CustomerId"));
        WebsiteDao dao = new WebsiteDao();
        try {
        //delete de account, indien het niet werkt krijg je een melding.
            dao.DeleteUser(CustomerId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DeleteUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Delete werkt niet");
        }
        System.out.println("Delete User heeft gewerkt");
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
