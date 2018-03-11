package twitter.servlets;

import twitter.dto.TwitterMessageDto;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TweetsServlet", value= "/tweetsServlet")
public class TweetsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();

        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"First message","Mike");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"Second message","John");

        List<TwitterMessageDto> tweets = new ArrayList<TwitterMessageDto>();
        tweets.add(twitterMessageDto1);
        tweets.add(twitterMessageDto2);

        //TODO retrieve twees from database

        out.println("<html>");
        out.println("<body>");
        out.println("<div>This is tweet list</div>");
        out.println("<ul>");

        for(TwitterMessageDto twitterMessageDto:tweets) {
            out.println("<li><div>" +
                    "id: " + twitterMessageDto.getId() +
                    "; message: " + twitterMessageDto.getMessage() +
                    "; username: " + twitterMessageDto.getUsername()+
                    "</div></li>");
        }
        out.println("</ul>");
        out.println("<body>");
        out.println("</html>");
    }
}
