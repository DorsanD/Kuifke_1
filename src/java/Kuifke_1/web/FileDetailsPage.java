package Kuifke_1.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.TrackBean;
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
@WebServlet(urlPatterns = {"/FileDetailsPage"})
public class FileDetailsPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    //gaat de gegevens van de geuploade liedjes toevoegen aan de sessie en wegschrijvn in de databank
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TrackBean track = (TrackBean) request.getSession().getAttribute("NEWTRACK");
        //gegevens in de bean steken
        track.setTrack_Name(request.getParameter("Track_Name"));
        track.setGenre(request.getParameter("Genre"));
        track.setLength(Integer.parseInt(request.getParameter("Length")));

        WebsiteDao dao = new WebsiteDao();
        try {
        //item in de databank steken
            dao.addTrackItem(track);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File gegevens niet in database gestoken");
        }
        System.out.println("File gegevens in database gestoken");
        request.getRequestDispatcher("/WEB-INF/pages/ArtistAccountPage.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
