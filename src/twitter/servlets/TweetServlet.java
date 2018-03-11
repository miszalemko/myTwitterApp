package twitter.servlets;

import twitter.dto.TwitterMessageDto;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TweetServlet", value = "/tweet")
public class TweetServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idasString = req.getParameter("tweetId");
        int tweetId = Integer.valueOf(idasString);
        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"First message","Mike");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"Second message","John");

        Map<Integer,TwitterMessageDto> tweetsMap = new HashMap<Integer,TwitterMessageDto>();

        tweetsMap.put(twitterMessageDto1.getId(),twitterMessageDto1);
        tweetsMap.put(twitterMessageDto2.getId(),twitterMessageDto2);

        TwitterMessageDto foundTweet = tweetsMap.get(tweetId);

        //TODO DAO to find Tweet

        ServletOutputStream out = resp.getOutputStream();
        out.println("<html>");
        out.println("<form>");
        out.println("<input type =\"text\" name=\"message\" value=\"" + foundTweet.getMessage()+"\"/>");
        out.println("<input type=\"hidden\" name =\"id\" value=\"" + foundTweet.getId() + "\"/>");
        out.println("<input type=\"text\" name =\"username\" value=\"" + foundTweet.getUsername()+ "\"/>");
        out.println("</form>");
        out.println("</html>");

    }
}
