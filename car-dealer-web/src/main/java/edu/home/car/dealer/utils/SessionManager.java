package edu.home.car.dealer.utils;

import com.sun.jersey.api.client.ClientResponse;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.NewCookie;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@Startup
public class SessionManager {

    private static final ConcurrentHashMap<String, NewCookie> cookieMap = new ConcurrentHashMap<>();

    public static NewCookie getCookie(HttpServletRequest req) {
        final HttpSession session = req.getSession(true);
        final String sessionId = session.getId();
        return cookieMap.get(sessionId);
    }

    public static void putCookie(HttpServletRequest req, ClientResponse response) {
        final List<NewCookie> newCookies = response.getCookies();
        if (newCookies != null && newCookies.size() > 0) {
            final HttpSession session = req.getSession(true);
            final String sessionId = session.getId();
            cookieMap.put(sessionId, newCookies.get(0));
        }
    }

    public static String getNickName(HttpServletRequest req) {
        return (String) req.getSession().getAttribute("nickName");
    }
}