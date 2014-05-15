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
@WebServlet(name = "BuyCreditsServlet", urlPatterns = {"/BuyCreditsServlet"})
public class BuyCreditsServlet extends HttpServlet implements Constants {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/AlterCredits.jsp").forward(request, response);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebsiteDao dao = new WebsiteDao();
        CustomerBean Cbean = (CustomerBean) request.getSession().getAttribute("CUSTOMERBEAN");
        System.out.println("Ingegeven Credits: " + request.getParameter("Credits"));
        try {
            dao.AlterCustomerCredits(Integer.parseInt(request.getParameter("Credits")), Cbean.getCustomerId());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BuyCreditsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cbean.setCredits(Cbean.getCredits()+Integer.parseInt(request.getParameter("Credits")));
        request.getRequestDispatcher("/WEB-INF/pages/Account.jsp").forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
