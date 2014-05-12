/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kuifke_1.web;

import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.ArtistBean;
import Kuifke_1.domain.ArtistPasswordCheck;
import Kuifke_1.domain.CustomerBean;
import static Kuifke_1.web.Constants.WEBSITE_BEAN;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dorsan
 */
@WebServlet(name = "ArtistLoginServlet", urlPatterns = {"/ArtistLoginServlet"})
public class ArtistLoginServlet extends HttpServlet implements Constants{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArtistBean artistBean = new ArtistBean();
        req.getSession().setAttribute(ARTIST_BEAN, artistBean);
        req.getRequestDispatcher("WEB-INF/pages/ArtiestFirstPage.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String fout = "";
        WebsiteDao dao = new WebsiteDao();
        ArtistBean art = null;
        try {
            art = dao.ArtistCheck(req.getParameter("username"));

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Fout bij ArtistCheck");
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (art.getPassword() != "1") {
            
            ArtistPasswordCheck pwCheck = new ArtistPasswordCheck(art, req.getParameter("password"));
            if (pwCheck.check()) {
                //pw matched
                System.out.println("passwoord juist");
                req.getRequestDispatcher("WEB-INF/pages/ArtistAccountPage.jsp").forward(req, resp);
                try {
                    art = dao.getArtistUserDetails(req.getParameter("username"));
                } catch (        ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                System.out.println("password fout");
                fout = "Password doesn't match.";
                doGet(req, resp);
                req.setAttribute("USERNAME", req.getParameter("username"));
            }

        }
        
        fout = "username niet gevonden";
        req.setAttribute("FOUT", fout);
        HttpSession session = req.getSession();
        session.setAttribute("ARTISTBEAN", art);
        doGet(req, resp);

    }
    


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
