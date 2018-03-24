package twitter.controlers;

import twitter.dto.TwitterMessageDto;
import twitter.service.TwitterMessageDatabaseServiceImpl;
import twitter.service.TwitterMessageService;
import twitter.service.TwitterMessageServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name ="TweetControler", value ="/tweet")
public class TweetControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAsString = req.getParameter("tweetId");
        int tweetId = Integer.valueOf(idAsString);

        TwitterMessageService twitterMessageService = new TwitterMessageDatabaseServiceImpl();
        TwitterMessageDto foundTweet = twitterMessageService.findbyId(tweetId);

        if(foundTweet == null) {
            req.setAttribute("errorMessage","There is no tweet with id: " + tweetId);
        }

        req.setAttribute("tweet", foundTweet);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/tweets_jstl/tweet.jsp");
        dispatcher.forward(req,resp);
    }
}
