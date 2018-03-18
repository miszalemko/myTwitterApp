package twitter.controlers;

import twitter.dto.TwitterMessageDto;
import twitter.validators.Errors;
import twitter.validators.TwitterMessageValidatorImpl;
import twitter.validators.TwitterTitleMessageValidatorImpl;
import twitter.validators.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AddTweetControler", value = "/addTweet")
public class AddTweetControler extends HttpServlet {

    private List<Validator> validators = Arrays.asList(new TwitterTitleMessageValidatorImpl(),
            new TwitterMessageValidatorImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tweet", new TwitterMessageDto());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/tweet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userMessage = req.getParameter("message");
        String title = req.getParameter("title");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        //binding
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(null, userMessage, username, title);
        Errors errors = new Errors();

        for (Validator validator : validators) {
            validator.validate(twitterMessageDto, errors);
        }

        if (errors.hasFieldErrors()) {
            req.setAttribute("errors", errors);
            req.setAttribute("tweet",twitterMessageDto);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/tweet.jsp");
            dispatcher.forward(req,resp);
        } else {
            String message = String.format("Dear user %s you've added tweet with title %s and message %s", username, title, userMessage);
            //TODO save tweet to database

            req.setAttribute("message", message);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/message/message.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
