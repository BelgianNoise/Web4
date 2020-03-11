package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getUsers extends RequestHandler{
  @Override
  public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    List<Person> persons = getPersonService().getPersons();
    String res = "[";
    for(Person p : persons){
      res+="{\"userId\":\""+p.getUserId()+"\",";
      res+="\"firstname\":\""+p.getFirstName()+"\",";
      res+="\"lastname\":\""+p.getLastName()+"\",";
      res+="\"geslacht\":\""+p.getGelslacht()+"\",";
      res+="\"leeftijd\":"+p.getLeeftijd()+"}";
      if(persons.indexOf(p) != persons.size() -1){
        res+=",";
      }
    }
    res+="]";

    response.setContentType("text/json");
    response.setHeader("Access-Control-Allow-Origin", "*");
    try {
      response.getWriter().write(res);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
