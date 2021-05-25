package com.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Component;

@Component
public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("Session created...");
        se.getSession().setMaxInactiveInterval(12*60*60);
   }


   public void sessionDestroyed(HttpSessionEvent se)  { 
        System.out.println("Session destroyed..");
   }
}
