package controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/PostController")
public class PostController {

    private static final Set<Session> sessions =
            Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " has opened a connection");
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("Message from " + session.getId() + ": " + message);
        sendComment(message);
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("Chat " +session.getId()+" has ended");
        sessions.remove(session);
    }

    private void sendComment(String message){
        for(Session s : sessions){
            try {
                s.getBasicRemote().sendText(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}