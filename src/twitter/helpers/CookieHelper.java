package twitter.helpers;

import javax.servlet.http.Cookie;

public class CookieHelper {

    public static String getCookieValueByName(Cookie[] cookies,String cookieName){
        if(cookies!= null) {
            for(Cookie cookie:cookies) {
                if(cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
