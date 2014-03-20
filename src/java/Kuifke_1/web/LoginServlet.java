/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kuifke_1.web;

import Kuifke_1.domain.WebsiteBean;
import Kuifke_1.web.Constants;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value = "/Login", initParams = {
    @WebInitParam(name = "LoginURL", value = "./WEB-INF/pages/LogIn.jsp"),
})    
/**
 *
 * @author Dorsan
 */

public class LoginServlet extends HttpServlet implements Constants {
    private String LoginURL;

   

   @Override
    public void init() throws ServletException {
        LoginURL = getInitParameter("LoginURL");
        if (LoginURL == null) {
            throw new ServletException("Missing parameter");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebsiteBean websiteBean = new WebsiteBean();
        req.getSession().setAttribute(WEBSITE_BEAN, websiteBean);
        req.getRequestDispatcher(LoginURL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        WebsiteBean bean = (WebsiteBean) req.getSession().getAttribute(WEBSITE_BEAN);
        bean.setUsername(req.getParameter("username"));
        bean.setPassword(req.getParameter("password"));
        resp.sendRedirect(LoginURL);
        
    }
    

    }

  
