package cpm.accp.ping.listener;

import java.util.Calendar;
import java.util.Timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cpm.accp.ping.util.MyTask;

public class Aiccselistener implements ServletContextListener, HttpSessionListener {
	private Timer timer = null; //���嶨ʱ��
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
    	timer.cancel(); //���ٶ�ʱ��
    	arg0.getServletContext().removeAttribute("COUNT");
    }

    public void contextInitialized(ServletContextEvent arg0)  {
    	arg0.getServletContext().setAttribute("COUNT", 0);
    	//���ö�ʱ��
    	System.out.println("-----��ʼ������ʱ��------");
    	Calendar twentyOne = Calendar.getInstance();
    	twentyOne.set(Calendar.HOUR_OF_DAY,10);
    	twentyOne.set(Calendar.MINUTE, 28);
    	twentyOne.set(Calendar.SECOND, 0);
    	timer = new Timer(true);
    	//��һ��������23��ִ�У����24Сʱִ��һ��
    	timer.schedule(new MyTask(), twentyOne.getTime(),5000);
    }
	
}
