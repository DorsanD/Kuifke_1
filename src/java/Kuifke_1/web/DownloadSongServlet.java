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
@WebServlet(name = "DownloadSongServlet", urlPatterns = {"/DownloadSongServlet"})
public class DownloadSongServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean check;
        int trackid;
        String fileLocation="";
        WebsiteDao dao = new WebsiteDao();
        CustomerBean Cbean = (CustomerBean) request.getSession().getAttribute("CUSTOMERBEAN");
        try {
            check = dao.RetractCustomerCredits(Cbean.getCustomerId());
            if (check) {
                System.out.println("If check true");
                request.getRequestDispatcher("/WEB-INF/pages/DownloadPage.jsp").forward(request, response);
            } else {
                System.out.println("If check false");

                request.getRequestDispatcher("/WEB-INF/pages/Account.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DownloadSongServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cbean.setCredits(Cbean.getCredits()- 50);
        trackid = Integer.parseInt(request.getParameter("downloadlink"));
        try {
            fileLocation = dao.getTrackLocation(trackid);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DownloadSongServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getSession().setAttribute("downloadid", fileLocation);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
