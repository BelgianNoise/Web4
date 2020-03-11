package controller;

import db.PersonRepository;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getStatus extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person user = (Person)request.getSession().getAttribute(
                "user");
        Person p = getPersonService().getPerson(user.getUserId());
        String json = this.toJSON(p.getStatus());

        response.setContentType("text/json");
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    private String toJSON (String quote) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"status\" : \"");
        json.append(quote);
        json.append("\"}");

        return json.toString();
    }
}
