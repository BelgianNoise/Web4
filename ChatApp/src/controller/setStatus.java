package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class setStatus extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person user = (Person)request.getSession().getAttribute(
                "user");
        getPersonService().getPerson(user.getUserId()).setStatus(
                request.getParameter("status"));
        return null;
    }
}
