package controller;

import domain.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sendMessage extends RequestHandler {
  @Override
  public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    String from = request.getParameter("from");
    String to = request.getParameter("to");
    String message = request.getParameter("message");
    System.out.println(to + " " + message);
    if(message.equals("") || to.equals("")){
      return null;
    }
    Message m = new Message(from, to , message);
    System.out.println(from + " sent:");
    System.out.println(message);
    System.out.println("=============");
    System.out.println("To: " +to);

    getMessagesDB().addMessage(m);

    return null;
  }
}
