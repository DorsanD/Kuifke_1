/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Kuifke_1.web;


/**
 *
 * @author Dorsan
 */

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



@WebServlet(value = "/Registratie", initParams = {
    @WebInitParam(name = "registratieURL", value = "./WEB-INF/pages/Registratie.jsp"),
        @WebInitParam(name = "questionURL", value = "Question"),

})
public class RegistratieServlet extends HttpServlet implements Constants {
    private String registratieURL;
    private String questionURL;

   

   @Override
    public void init() throws ServletException {
        registratieURL = getInitParameter("registratieURL");
        questionURL = getInitParameter("questionURL");
        if (registratieURL == null || questionURL == null) {
            throw new ServletException("Missing parameter");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebsiteBean websiteBean = new WebsiteBean();
        req.getSession().setAttribute(WEBSITE_BEAN, websiteBean);
        req.getRequestDispatcher(registratieURL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        WebsiteBean bean = (WebsiteBean) req.getSession().getAttribute(WEBSITE_BEAN);
        bean.setName(req.getParameter("name"));
        bean.setFirstname(req.getParameter("firstname"));
        bean.setGender(req.getParameter("gender"));
        bean.setEmail(req.getParameter("email"));
        bean.setUsername(req.getParameter("username"));
        bean.setPassword(req.getParameter("password"));
        bean.setLanguage(req.getParameter("language"));
        resp.sendRedirect(questionURL);
        
    }
}
