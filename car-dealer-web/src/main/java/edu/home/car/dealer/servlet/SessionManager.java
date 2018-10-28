package edu.home.car.dealer.servlet;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.core.NewCookie;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@Startup
class SessionManager {

    private static final ConcurrentHashMap<String,NewCookie> cookieMap = new ConcurrentHashMap<>();

    static NewCookie getCookie(String sessionID){
        return cookieMap.get(sessionID);
    }

    static void putCookie(String sessionID, NewCookie newCookie){
        cookieMap.put(sessionID, newCookie);
    }
}