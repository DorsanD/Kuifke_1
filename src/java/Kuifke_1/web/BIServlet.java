/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.web;

import Kuifke_1.dao.Connectie;
import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.BIBean;
import com.aspose.cells.FileFormatType;
import com.aspose.cells.Workbook;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Dorsan
 */
@WebServlet(name = "BIServlet", urlPatterns = {"/BIServlet"})
public class BIServlet extends HttpServlet {

    String aanvulling, aanvullinghorizon;

    //redirection naar de correcte pagina.
    //Gaat de kolommen uit de databank halen.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        WebsiteDao dao = new WebsiteDao();
        List<BIBean> BiBeans = null;
        try {
            BiBeans = dao.getColumns();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BIServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getSession().setAttribute("COLUMNS", BiBeans);

        request.getRequestDispatcher("WEB-INF/pages/BISelect.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Tabellen tonen waaruit de gebruiker mag kiezen
        WebsiteDao dao = new WebsiteDao();

        //Lijst van kolommen opvragen
        List<BIBean> BiBeans = (List<BIBean>) request.getSession().getAttribute("COLUMNS");

        //KolomID's ophalen
        String[] selection = request.getParameterValues("selectedColumns");

        //Lijst van BiBeans maken met de geselecteerde kolommen
        List<BIBean> selColumns = new ArrayList<>();

        for (int j = 0; j < selection.length; j++) {
            //haal de 4 selecties op

            int sel = Integer.parseInt(selection[j]);
            for (int i = 0; i < BiBeans.size(); i++) {
                if (BiBeans.get(i).getId() == sel) {
                    selColumns.add(BiBeans.get(i));
                }
            }
        }
        try {
            //data van de geselecteerde columns ophalen
            selColumns = dao.getColumnsData(selColumns);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BIServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //haal de datum en tijd op
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);

        //stel een tijdscode op
        String tijd = "" + year + (month + 1) + day + "-" + hour + "." + minute;

        //initialiseer de bestandslocaties
        String template = "C:\\Kuifke\\temp\\excel\\template1.xls";
        String output = "C:\\Kuifke\\temp\\excel\\output" + tijd + ".xls";
        String outputPDF = "C:\\Kuifke\\temp\\excel\\output" + tijd + ".pdf";

        //maak een excel file
        Map beans = new HashMap();
        beans.put("SELCOLUMNS", selColumns);
        XLSTransformer transformer = new XLSTransformer();
        try {
            transformer.transformXLS(template, beans, output);
            System.out.println("Excel aangemaakt");
        } catch (ParsePropertyException | InvalidFormatException ex) {
            Logger.getLogger(BIServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //maak een PDF file
        //Open een nieuw workbook voor excel
        Workbook workbook;
        try {
            workbook = new Workbook(output);
            //Slaag het document op in PDF
            workbook.save(outputPDF, FileFormatType.PDF);
            System.out.println("PDF aangemaakt");
        } catch (Exception ex) {
            Logger.getLogger(BIServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        File fexcel = new File(output);
        File fPDF = new File(outputPDF);

        //urls naar de bestanden
        output = "C:\\Kuifke\\temp\\excel\\" + fexcel.getName();
        System.out.println("link naar excel: " + output);
        outputPDF = "C:\\Kuifke\\temp\\excel\\" + fPDF.getName();
        System.out.println("link naar PDF: " + outputPDF);

        System.out.println("aantal kollomen: " + selection.length);
        request.setAttribute("AANTALCOL", selection.length);
        request.getSession().setAttribute("SELCOLUMNS", selColumns);
        request.getSession().setAttribute("EXCEL", output);
        request.getSession().setAttribute("PDF", outputPDF);

        //nu sturen we door naar de resultatenpagina
        request.getRequestDispatcher("WEB-INF/pages/BIResults.jsp").forward(request, response);

    }
}
