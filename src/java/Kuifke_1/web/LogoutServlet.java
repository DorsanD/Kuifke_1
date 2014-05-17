/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.web;

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
 * @author Dorsan
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    //redirection naar de correcte pagina.
    //Bean binnenhalen    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerBean websiteBean = new CustomerBean();
        req.getSession().setAttribute(WEBSITE_BEAN, websiteBean);
        req.getRequestDispatcher("WEB-INF/pages/Logout.jsp").forward(req, resp);
    }

    //Sessie killen, uitloggen van de user.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session1 = request.getSession();
        session1.invalidate();
        request.getRequestDispatcher("WEB-INF/pages/FirstPage.jsp").forward(request, response);
    }
}
