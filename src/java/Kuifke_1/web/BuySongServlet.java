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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dorsan
 */
@WebServlet(name = "BuySongServlet", urlPatterns = {"/BuySongServlet"})
public class BuySongServlet extends HttpServlet implements Constants {

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
        request.getSession().getAttribute("CUSTOMERBEAN");
        CustomerBean Cbean = (CustomerBean) request.getSession().getAttribute("CUSTOMERBEAN");

        //dao.AlterCustomerCredits(Credits, CustomerId);
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
