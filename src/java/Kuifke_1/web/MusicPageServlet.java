/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.web;

import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.TrackBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "MusicPageServlet", urlPatterns = {"/MusicPageServlet"})
public class MusicPageServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //redirect naar de juist pagina en haalt alle gegevens van track op 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebsiteDao dao = new WebsiteDao();
        List<TrackBean> tracks = null;
        try {
        //alle gegevens van de tracks in de databank ophalen
            tracks = dao.getAllTracks();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MusicPageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("TRACK_BEAN", tracks);
        //alle gegevens opslaan in de tracks list
        request.getRequestDispatcher("WEB-INF/pages/Music.jsp").forward(request, response);
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
