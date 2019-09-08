package com.shenhai.say.util;

import java.io.IOException;  
import java.util.Map;  
import java.util.concurrent.ConcurrentHashMap;  
import javax.websocket.*;  
import javax.websocket.server.PathParam;  
import javax.websocket.server.ServerEndpoint;

import com.shenhai.say.pojo.User;

import net.sf.json.JSONObject;  


@ServerEndpoint("/Websocket")  
public class Websocket {  
  
    private static int onlineCount = 0;  
    private static Map<String, Websocket> clients = new ConcurrentHashMap<String, Websocket>();  
    private static Map<String, User> userMap=new ConcurrentHashMap<String, User>();
    static {
    	userMap.put("001", new User("001", "张三", "666", "13245678956"));
    	userMap.put("002", new User("002", "李四", "666", "13345678957"));
    	userMap.put("003", new User("003", "翠花", "666", "13445678958"));
    	userMap.put("004", new User("004", "如花", "666", "13545678959"));
    }
    private Session session;  
    private String id;  
      
    @OnOpen  
    public void onOpen(Session session) throws IOException {  
    	this.session=session;
    	System.out.println("连接成功!!");
    }  
  
    @OnClose  
    public void onClose() throws IOException {  
    	    clients.remove(id);  
            subOnlineCount();
    }  
  
    @OnMessage  
    public void onMessage(String message) throws IOException {  
        System.out.println("消息来了"+message);
        JSONObject jsonTo = JSONObject.fromObject(message);  
        if(jsonTo.get("m").equals("login")) {
        	login(jsonTo.get("id").toString(), jsonTo.get("pwd").toString());
        }  
    }  
  
    @OnError  
    public void onError(Session session, Throwable error) {  
        error.printStackTrace();  
    }  
  
    public void sendMessageTo(String message, String To) throws IOException {  
         
        for (Websocket item : clients.values()) {  
            if (item.id.equals(To) )  
                item.session.getAsyncRemote().sendText(message);  
        }  
    }  
      
    public void sendMessageAll(String message) throws IOException {  
        for (Websocket item : clients.values()) {  
            item.session.getAsyncRemote().sendText(message);  
        }  
    }  
    //登录
    public void login(String id,String pwd) throws IOException {  
        for (User u : userMap.values()) {
			if(u.getId().equals(id)&&u.getPwd().equals(pwd)) {
				if(!clients.keySet().contains(id)) {
					this.id=id;
					clients.put(id, this);
					this.session.getAsyncRemote().sendText("登录成功");
					return;
				}else {
					clients.get(id).session.getAsyncRemote().sendText("你的账号被登录了");
					return;
				}
			}
		}
    }  
    public static synchronized int getOnlineCount() {  
        return onlineCount;  
    }  
  
    public static synchronized void addOnlineCount() {  
        Websocket.onlineCount++;  
    }  
  
    public static synchronized void subOnlineCount() {  
        Websocket.onlineCount--;  
    }  
  
    public static synchronized Map<String, Websocket> getClients() {  
        return clients;  
    }  
    
    
    
}  
