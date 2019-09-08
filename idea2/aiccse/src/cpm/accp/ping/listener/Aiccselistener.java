package cpm.accp.ping.listener;

import java.util.Calendar;
import java.util.Timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cpm.accp.ping.util.MyTask;

public class Aiccselistener implements ServletContextListener, HttpSessionListener {
	private Timer timer = null; //定义定时器
    public Aiccselistener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  {
    	Object val=arg0.getSession().getServletContext().getAttribute("COUNT");
    	if(val!=null) {
    		Integer count=(Integer)val;
    		count--;
    		arg0.getSession().getServletContext().setAttribute("COUNT",count);
    	}
    }

    public void contextDestroyed(ServletContextEvent arg0)  {
    	timer.cancel(); //销毁定时器
    	arg0.getServletContext().removeAttribute("COUNT");
    }

    public void contextInitialized(ServletContextEvent arg0)  {
    	arg0.getServletContext().setAttribute("COUNT", 0);
    	//布置定时器
    	System.out.println("-----开始启动定时器------");
    	Calendar twentyOne = Calendar.getInstance();
    	twentyOne.set(Calendar.HOUR_OF_DAY,10);
    	twentyOne.set(Calendar.MINUTE, 28);
    	twentyOne.set(Calendar.SECOND, 0);
    	timer = new Timer(true);
    	//第一次是晚上23点执行，间隔24小时执行一次
    	timer.schedule(new MyTask(), twentyOne.getTime(),5000);
    }
	
}
