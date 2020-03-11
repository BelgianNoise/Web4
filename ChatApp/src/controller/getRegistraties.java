package controller;

import domain.OPORegistratie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getRegistraties extends RequestHandler {
  @Override
  public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    String res = "{ \"regis\" : [";
    for(OPORegistratie opo : getRegiDB().getAll()){
      res += "{\"naam\" : \""+opo.getNaam()+"\",";
      res += "\"vak\" : \""+opo.getVak()+"\",";
      res += "\"academiejaar\" : \""+
              opo.getAcademiejaar()+"\"}";
      if(getRegiDB().getAll().indexOf(opo) !=
              getRegiDB().getAll().size() -1){
        res += ",";
      }
    }
    res += "]}";
    response.setContentType("text/json");
    try {
      response.getWriter().write(res);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
