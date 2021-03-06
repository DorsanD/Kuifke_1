/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.web;

import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.ArtistBean;
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
@WebServlet(name = "AlterArtistServlet", urlPatterns = {"/AlterArtistServlet"})
public class ArtistAlterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //redirection naar de correcte pagina.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/AlterArtist.jsp").forward(request, response);
    }

    @Override
    //functie om de First_Name van de artist te veranderen naar een gewenste First_Name
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //haalt de sessie binnen
        request.getSession().getAttribute("ARTISTBEAN");
        ArtistBean art = (ArtistBean) request.getSession().getAttribute("ARTISTBEAN");
        art.getArtistId();
        //Haalt de nieuwe first name binnen
        String First_Name = request.getParameter("First_Name");
        System.out.println("Nieuwe First Name " + First_Name);
        WebsiteDao dao = new WebsiteDao();
        try {
        //probeert de first name om te zetten naar nieuwe first name
            dao.AlterArtistName(art.getArtistId(), First_Name);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ArtistAlterServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Update van First Name is mislukt");
        }
        System.out.println("Updaten van First Name is gelukt");

        art.setFirst_Name(First_Name);
        processRequest(request, response);
        //slaag het op in de bean.
        request.getSession().setAttribute("ARTISTBEAN", art);
        request.getRequestDispatcher("/WEB-INF/pages/ArtistAccountPage.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
