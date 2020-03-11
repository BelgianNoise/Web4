package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MessageDB;
import db.RegistratieDB;
import domain.PersonService;
import domain.Person;
import domain.Role;

public abstract class RequestHandler {
	
	private PersonService personService;
	private MessageDB messagesDB;
	private RegistratieDB regiDB;
	
	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);
	
	public void setModel (PersonService personService) {
		this.personService = personService;
	}

	public PersonService getPersonService() {
		return personService;
	}
	
	protected boolean isFromUserWithRole (HttpServletRequest request, Role role) {
		Person person = (Person) request.getSession().getAttribute("user");
		if (person != null && person.getRole().equals(role)) {
			return true;
		}
		return false;
	}
	public void setMessagesDB(MessageDB m){
		this.messagesDB = m;
	}
	public MessageDB getMessagesDB(){
		return this.messagesDB;
	}
	public void setRegiDB(RegistratieDB regiDB){
		this.regiDB = regiDB;
	}
	public RegistratieDB getRegiDB(){
		return this.regiDB;
	}
}
