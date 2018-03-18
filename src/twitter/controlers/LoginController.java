package twitter.controlers;

import twitter.enums.Language;
import twitter.helpers.CookieHelper;
import twitter.service.LoginService;
import twitter.service.LoginServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = CookieHelper.getCookieValueByName(req.getCookies(), "lang");
        if (lang != null && !lang.equals("")) {
            Language language = Language.valueOf(lang);
            req.setAttribute("language", language.getDescription());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/login/loginPage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean logged = loginService.login(username, password);
        if (logged) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            String backUrl = req.getParameter("backUrl");
            if (backUrl != null && !backUrl.equals("")) {
                resp.sendRedirect(backUrl);
            } else {
                resp.sendRedirect("/myTweets");
            }
        } else {
            req.setAttribute("errorMessage", "Wrong user or password");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/login/loginPage.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
