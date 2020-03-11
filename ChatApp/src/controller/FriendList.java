package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FriendList extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person p = (Person)request.getSession().
                getAttribute("user");
        ArrayList<String> friends = p.getFriendList();
        String res = "{ \"friends\" : [";
        for(String s: friends){
            Person friend =getPersonService().getPerson(s);
            res += "{ \"id\" : \"" + friend.getUserId() +
                    "\",";
            res += "\"name\" : \"" + friend.getFirstName() +
                    " " + friend.getLastName() + "\", ";
            res += "\"status\" : \"" + friend.getStatus() +
                    "\", ";
            res += "\"email\" : \"" + friend.getUserId() +
                    "\"}";
            if(friends.indexOf(s) != friends.size() -1){
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
