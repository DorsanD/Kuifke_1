/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.web;

import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.TrackBean;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Dorsan
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
public class FileUploadServlet extends HttpServlet {

    //invitiliseren van de variabelen.
    private boolean isMultipart;
    private int maxFileSize = 20 * 1024 * 1024;
    private int maxMemSize = 40 * 1024 * 1024;
    private File file;
    private String subPath;
    private String base = "c:\\Kuifke\\";
    private String loc;
    private String loc1;
    private String artLoc;
    private String artLoc1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    //redirect naar de juiste pagina.
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/TrackUpload.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("uploadmodule gestart");
        // Controleren of er een file upload request is
        isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            System.out.println("geen file om up te loaden?");
            //Indien geen upload, redirect
            request.getRequestDispatcher("WEB-INF/pages/TrackUpload.jsp").forward(request, response);

        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        //Maxsize van het geheugen
        factory.setSizeThreshold(maxMemSize);
        // Indien groter, in een andere locatie opslaan:
        factory.setRepository(new File(base + "temp\\"));

        //Nieuwe file upload handler maken
        ServletFileUpload upload = new ServletFileUpload(factory);
        //MaxSize van het bestand
        upload.setSizeMax(maxFileSize);

        System.out.println("upload config OK");
        try {
            //Request parsen
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();

            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Geuploade file parameters binnenhalen
                    String fileName = fi.getName();

                    //Bestand binnenhalen
                    if (fileName.contains(".mp3") || fileName.contains(".wma")) {
                        //als de file een mp3 of wma is naar volgende locatie opslaan
                        subPath = base + "music\\";
                        loc = subPath;
                        loc1 = fileName;
                        if (fileName.lastIndexOf("\\") >= 0) {
                            System.out.println("optie 1");
                            file = new File(loc + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            System.out.println("optie 2");
                            file = new File(loc + fileName.substring(fileName.lastIndexOf("\\") + 1));

                        }
                    } else {
                        //als de file een andere formaat heeft
                        System.out.println("andere type file upgeload");
                        subPath = base + "art\\";
                        artLoc = subPath;
                        artLoc1 = subPath + fileName;

                        if (fileName.lastIndexOf("\\") >= 0) {
                            System.out.println("optie 1");
                            file = new File(artLoc + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            System.out.println("optie 2");
                            file = new File(artLoc + fileName.substring(fileName.lastIndexOf("\\") + 1));

                        }
                    };

                    fi.write(file);
                    System.out.println("bestand met naam: " + fileName + " ontvangen");

                }
            }
        } catch (Exception ex) {
            System.out.println(" " + ex);
        }
        //steek de bestandslocatie in de trackbean
        TrackBean track = new TrackBean();
        track.setFile_Location(loc1);
        track.setImage_Location(artLoc1);
        request.getSession().setAttribute("NEWTRACK", track);


        request.getRequestDispatcher("WEB-INF/pages/FileDetails.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
