package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateUser extends RequestHandler {
  @Override
  public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String geslacht = request.getParameter("geslacht");
    String l = request.getParameter("leeftijd");
    int leeftijd = Integer.valueOf(l);

    String userId = request.getParameter("userId");
    System.out.println(userId +firstname+lastname+geslacht+leeftijd);
    Person p = getPersonService().getPerson(userId);

    p.setGelslacht(geslacht);
    p.setLeeftijd(leeftijd);
    p.setFirstName(firstname);
    p.setLastName(lastname);
    getPersonService().deletePerson(p.getUserId());
    getPersonService().addPerson(p);
    System.out.println("update done");
    response.setHeader("Access-Control-Allow-Origin", "*");

    try {
      response.getWriter().write("{}");
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}
