/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.web;

import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.CustomerBean;
import Kuifke_1.domain.PasswordCheck;
import Kuifke_1.web.Constants;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginURL", urlPatterns = {"/Login"})
/**
 *
 * @author Dorsan
 */
public class LoginServlet extends HttpServlet implements Constants {
    //redirection naar de correcte pagina.
    //Bean aanhalen
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerBean websiteBean = new CustomerBean();
        req.getSession().setAttribute(WEBSITE_BEAN, websiteBean);
        req.getRequestDispatcher("WEB-INF/pages/FirstPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //initialiseren van de variabalen
        WebsiteDao dao = new WebsiteDao();
        CustomerBean cust = null;
        try {
        //gaat na of de username wel degelijk bestaat
            cust = dao.UserCheck(req.getParameter("username"));

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Fout bij userCheck");
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cust.getPassword() != "1") {
           //gaat na of de wachtwoord juist is. 
            PasswordCheck pwCheck = new PasswordCheck(cust, req.getParameter("password"));
            if (pwCheck.check()) {
                //als paswoord juist is, redirect naar de pagina
                System.out.println("passwoord juist");
                req.getRequestDispatcher("WEB-INF/pages/WelcomePage.jsp").forward(req, resp);
                try {
                    cust = dao.getUserDetails(req.getParameter("username"));
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                //als paswoord fout is keer je terug naar dezelfde pagina.
                System.out.println("password fout");
                doGet(req, resp);
                req.setAttribute("USERNAME", req.getParameter("username"));
            }

        }

        HttpSession session = req.getSession();
        session.setAttribute("CUSTOMERBEAN", cust);
        doGet(req, resp);

    }
}
