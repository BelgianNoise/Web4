package controller;

import domain.Person;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class doRegister extends RequestHandler {
  @Override
  public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    String achternaam = request.getParameter("achternaam");
    String voornaam = request.getParameter("voornaam");
    String email = request.getParameter("email");
    String geslacht = request.getParameter("geslacht");
    String le = request.getParameter("leeftijd");
    String pw1 = request.getParameter("pw");
    String pw2 = request.getParameter("pw2");
    int leeftijd = Integer.valueOf(le);

    if(!pw1.equals(pw2)){
      return "registerFailed.jsp";
    }
    try{
      Person p = new Person(email, pw1, voornaam,
              achternaam, Role.LID, geslacht, leeftijd);
      getPersonService().addPerson(p);
    }catch (Exception e){
      return "registerFailed.jsp";
    }
    return "index.jsp";
  }
}
