/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kuifke_1.web;

import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.ArtistBean;
import Kuifke_1.domain.CustomerBean;
import Kuifke_1.domain.Password;
import static Kuifke_1.web.Constants.WEBSITE_BEAN;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
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
@WebServlet(name = "ArtistRegistratieServlet", urlPatterns = {"/ArtistRegistratieServlet"})
public class ArtistRegistratieServlet extends HttpServlet implements Constants {
    private String salt;
    private String pw;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {       
        ArtistBean Abean = new ArtistBean();
        req.getSession().setAttribute(WEBSITE_BEAN, Abean);
        req.getRequestDispatcher("WEB-INF/pages/FirstPage.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArtistBean Abean = (ArtistBean) req.getSession().getAttribute(WEBSITE_BEAN);
        Abean.setArtist_Name(req.getParameter("Artist_Name"));
        Abean.setFirst_Name(req.getParameter("firstname"));
        Abean.setLast_Name(req.getParameter("lastname"));
        Abean.setGender(req.getParameter("gender"));
        Abean.setEmail_Address(req.getParameter("email"));
        Abean.setUsername(req.getParameter("username"));
        Abean.setLanguage(req.getParameter("language"));
        try {
            Password password = new Password(req.getParameter("password"));
            salt = password.getSalt();
            pw = password.getHash();
            Abean.setSalt(salt);
            Abean.setPassword(pw);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(RegistratieServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Paswoord niet geencrypteerd");
        }
        WebsiteDao dao = new WebsiteDao();
        try {
            dao.addArtistItem(Abean);
            req.getRequestDispatcher("WEB-INF/pages/WelcomePage.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RegistratieServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Artist niet toegevoegd aan Dao");
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
