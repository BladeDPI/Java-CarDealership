/*
 * *************************************************************************
 * Copyright (C) Wolters Kluwer Financial Services. All rights reserved.
 *
 * This computer program is protected by copyright law and international
 * treaties. Unauthorized reproduction or distribution of this program,
 * or any portion of it, may result in severe civil and criminal penalties,
 * and will be prosecuted to the maximum extent possible under the law.
 * *************************************************************************
 */
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