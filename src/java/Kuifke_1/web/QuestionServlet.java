package Kuifke_1.web;

import Kuifke_1.domain.WebsiteBean;
import static Kuifke_1.web.Constants.WEBSITE_BEAN;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Noel Vaes
 */
@WebServlet(value = "/Question", initParams = {
    @WebInitParam(name = "question1Page", value = "/WEB-INF/pages/Question1.jsp"),
    @WebInitParam(name = "confirmURL", value = "Confirm")
})
public class QuestionServlet extends HttpServlet {

    private String confirmURL;
    private String question1Page;

    @Override
    public void init() throws ServletException {
        confirmURL = getInitParameter("confirmURL");
        question1Page = getInitParameter("question1Page");
        if (confirmURL == null || question1Page == null) {
            throw new ServletException("Missing parameter");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(question1Page).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebsiteBean bean = (WebsiteBean) req.getSession().getAttribute(WEBSITE_BEAN);

        String page = req.getParameter("page");
        int answer = Integer.parseInt(req.getParameter("answer"));
        switch (page) {
            case "1":
                bean.setAnswer(0, answer);
                resp.sendRedirect(confirmURL);
                break;
            default:
                throw new ServletException("Invalid page");
        }
    }
}
