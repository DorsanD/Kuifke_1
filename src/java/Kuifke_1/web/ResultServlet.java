package Kuifke_1.web;

import Kuifke_1.dao.WebsiteDao;
import Kuifke_1.domain.WebsiteBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dorsan Demaeght
 */
@WebServlet(value = "/Result", initParams = {
    @WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
    @WebInitParam(name = "url", value = "jdbc:mysql://localhost/mydb"),
    @WebInitParam(name = "user", value = "root"),
    @WebInitParam(name = "password", value = "root"),
    @WebInitParam(name = "resultPage", value = "/WEB-INF/pages/Result.jsp")
})
public class ResultServlet extends HttpServlet implements Constants {

    private String resultPage;
    private WebsiteDao dao;

    @Override
    public void init() throws ServletException {
        try {
            resultPage = getInitParameter("resultPage");
            String driver = getInitParameter("driver");
            String url = getInitParameter("url");
            String user = getInitParameter("user");
            String password = getInitParameter("password");
            if (resultPage == null || driver == null || url == null || user == null || password == null) {
                throw new ServletException("Missing parameter");
            }
            dao = new WebsiteDao();
            dao.setDriver(driver);
            dao.setUser(user);
            dao.setPassword(password);
            dao.setUrl(url);
        } catch (ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<WebsiteBean> items = dao.getAllCustomerItems();
            req.setAttribute(ITEMS, items);
            req.getRequestDispatcher(resultPage).forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}