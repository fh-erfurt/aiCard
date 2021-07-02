package de.aicard.config;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.servlet.http.Cookie;


@Setter
@Getter
@RequiredArgsConstructor
public class Session {
    
    private static final String cookieName = "javaSession";
    private static final String cookieValue = "";  // you could assign it some encoded value
    private static final Boolean useSecureCookie = true;
    private static final int expiryTime = 60 * 60 * 24;  // 24h in seconds
    private static final String cookiePath = "/";

    private static Cookie setSession(){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setSecure(useSecureCookie);  // determines whether the cookie should only be sent using a secure protocol, such as HTTPS or SSL
        cookie.setMaxAge(expiryTime);  // A negative value means that the cookie is not stored persistently and will be deleted when the Web browser exits. A zero value causes the cookie to be deleted.
        cookie.setPath(cookiePath);
        return cookie;
    }

    static public Cookie delSession(Cookie cookies[]){
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals("javaSession"))
                {
//                    System.out.println(cookie.getValue());
                    cookie.setMaxAge(0);
                    return cookie;
                }
            }
        }
        Cookie cookie = setSession();
        cookie.setMaxAge(0);
        return cookie;
    }
    
  public static Cookie addSessionValue(Cookie cookies[], String newSessionValue)
  {
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals(cookieName))
                {
                    cookie.setValue(newSessionValue);
                    return cookie;
                }
            }
        }
        // create new Cookie when 'javaSession' Cookie doesn't exist and adds newSessionValue
        Cookie cookie =  Session.setSession();
        cookie.setValue(newSessionValue);
        return cookie;
  }

    
    public static String getSessionValue(Cookie cookies[])
    {
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals(cookieName))
                {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}