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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerBean websiteBean = new CustomerBean();
        req.getSession().setAttribute(WEBSITE_BEAN, websiteBean);
        req.getRequestDispatcher("WEB-INF/pages/FirstPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fout = "";
        WebsiteDao dao = new WebsiteDao();
        CustomerBean cust = null;
        try {
            cust = dao.UserCheck(req.getParameter("username"));

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Fout bij userCheck");
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cust.getPassword() != "1") {
            
            PasswordCheck pwCheck = new PasswordCheck(cust, req.getParameter("password"));
            if (pwCheck.check()) {
                //pw matched
                System.out.println("passwoord juist");
                doGet(req,resp);
                try {
                    cust = dao.getUserDetails(req.getParameter("username"));
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
        session.setAttribute("CUSTOMERBEAN", cust);
        doGet(req, resp);

    }

}
