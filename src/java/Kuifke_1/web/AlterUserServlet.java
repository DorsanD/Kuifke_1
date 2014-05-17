/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.web;

import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.CustomerBean;
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
@WebServlet(name = "AlterUserServlet", urlPatterns = {"/AlterUserServlet"})
public class AlterUserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //redirection naar de correcte pagina.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/AlterUser.jsp").forward(request, response);
    }

    @Override
    //functie om de First_Name van de customer te veranderen naar een gewenste First_Name
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //haalt de sessie binnen
        request.getSession().getAttribute("CUSTOMERBEAN");
        CustomerBean custom = (CustomerBean) request.getSession().getAttribute("CUSTOMERBEAN");
        custom.getCustomerId();
         //Haalt de nieuwe first name binnen
       String First_Name = request.getParameter("First_Name");
        System.out.println("Nieuwe First Name " + First_Name);
        WebsiteDao dao = new WebsiteDao();
        try {
        //probeert de first name om te zetten naar nieuwe first name
            dao.AlterName(custom.getCustomerId(), First_Name);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Update van First Name is mislukt");
        }
        System.out.println("Updaten van First Name is gelukt");

        custom.setFirst_Name(First_Name);
        processRequest(request, response);
        //slaag het op in de bean.
        request.getSession().setAttribute("CUSTOMERBEAN", custom);
        request.getRequestDispatcher("/WEB-INF/pages/Account.jsp").forward(request, response);

    }
}
