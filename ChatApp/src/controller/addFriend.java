package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addFriend extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person p = (Person)request.getSession().getAttribute(
                "user");
        String id = request.getParameter("id");
        Person p2 = getPersonService().getPerson(id);

        p.addFriend(id);
        p2.addFriend(p.getUserId());
        return null;
    }
}
