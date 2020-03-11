package controller;

import domain.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getMessages extends RequestHandler {
  @Override
  public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    String from = request.getParameter("from");
    String to = request.getParameter("to");
    List<Message> messages =
            getMessagesDB().getMessagesFromTo(
                    from, to);

    String res = "";
    res += "[";
    for(Message m:messages){
      res += "{\"from\" : \""+m.getFrom()+"\",";
      res += "\"to\" : \""+m.getTo()+"\",";
      res += "\"message\" : \""+m.getMessage()+"\"}";
      if(messages.indexOf(m) != messages.size() -1){
        res += ",";
      }
    }
    res += "]";
    response.setContentType("text/json");
    try{
      response.getWriter().write(res);
      System.out.println("All messages sent");
    }catch(IOException e){
      e.printStackTrace();
    }
    return null;
  }
}
