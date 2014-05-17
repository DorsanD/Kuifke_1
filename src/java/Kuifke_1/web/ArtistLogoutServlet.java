/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.web;

import Kuifke_1.domain.ArtistBean;
import Kuifke_1.domain.CustomerBean;
import static Kuifke_1.web.Constants.WEBSITE_BEAN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin
 */
@WebServlet(name = "ArtistLogoutServlet", urlPatterns = {"/ArtistLogoutServlet"})
public class ArtistLogoutServlet extends HttpServlet implements Constants {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session1 = request.getSession();
        session1.invalidate();
        request.getRequestDispatcher("WEB-INF/pages/FirstPage.jsp").forward(request, response);
    }

    
    //redirection naar de correcte pagina.
    //Bean binnenhalen
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArtistBean artistBean = new ArtistBean();
        request.getSession().setAttribute(ARTIST_BEAN, artistBean);
        request.getRequestDispatcher("WEB-INF/pages/LogoutArtist.jsp").forward(request, response);
    }

    @Override
    //Sessie killen, uitloggen van de user.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session1 = request.getSession();
        session1.invalidate();
        request.getRequestDispatcher("WEB-INF/pages/FirstPage.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
