package com.accp.Goods.listener;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class GoodsLinstener
 *
 */
public class GoodsLinstener implements ServletContextListener, HttpSessionListener {

	Timer timer=new Timer();
    /**
     * Default constructor. 
     */
    public GoodsLinstener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  {
    	Object val=arg0.getSession().getServletContext().getAttribute("COUNT");
    	if(val!=null) {
    		Integer count=(Integer)val;
    		count--;
    		arg0.getSession().getServletContext().setAttribute("COUNT",count);
    	}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  {
    	arg0.getServletContext().removeAttribute("COUNT");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
    	
    	arg0.getServletContext().setAttribute("COUNT", 0);
    	Calendar c=Calendar.getInstance();//»’¿˙
		c.set(Calendar.HOUR_OF_DAY,12);
		c.set(Calendar.MINUTE,26);
		c.set(Calendar.SECOND,0);
		timer.schedule(new MyThread(), c.getTime(),3000);
    }
}
