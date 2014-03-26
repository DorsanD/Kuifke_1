/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Kuifke_1.web;


/**
 *
 * @author Dorsan
 */

import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.CustomerBean;
import Kuifke_1.web.Constants;
import Kuifke_1.domain.Password;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "RegistratieServlet", urlPatterns = {"/RegistratieServlet"})
public class RegistratieServlet extends HttpServlet implements Constants {
    private String salt;
    private String pw;
   

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerBean websiteBean = new CustomerBean();
        req.getSession().setAttribute(WEBSITE_BEAN, websiteBean);
        req.getRequestDispatcher("WEB-INF/pages/Registratie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        CustomerBean bean = (CustomerBean) req.getSession().getAttribute(WEBSITE_BEAN);
        bean.setName(req.getParameter("name"));
        bean.setFirstname(req.getParameter("firstname"));
        bean.setGender(req.getParameter("gender"));
        bean.setEmail(req.getParameter("email"));
        bean.setUsername(req.getParameter("username"));
        bean.setLanguage(req.getParameter("language"));
        try {
            Password password = new Password(req.getParameter("password"));
            salt = password.getSalt();
            pw = password.getHash();
            bean.setSalt(salt);
            bean.setPassword(pw);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(RegistratieServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Paswoord niet geencrypteerd");
        }
        WebsiteDao dao = new WebsiteDao();
        try {
            dao.addCustomerItem(bean);
            req.getRequestDispatcher("WEB-INF/pages/Confirm.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RegistratieServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Customer niet toegevoegd aan Dao");
        }
        
    }
}
