package controller;

import domain.OPORegistratie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addRegistration extends RequestHandler {
  @Override
  public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    String naam = request.getParameter("naam");
    String vak = request.getParameter("vak");
    String aca = request.getParameter("aca");
    OPORegistratie temp = new OPORegistratie(naam, vak, aca);
    getRegiDB().addRegistratie(temp);
    return null;
  }
}
