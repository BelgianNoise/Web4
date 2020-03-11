package controller;

import db.MessageDB;
import db.RegistratieDB;
import domain.PersonService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, PersonService model, MessageDB messages, RegistratieDB regiDB) {
        return createHandler(key, model, messages, regiDB);
    }
    
	private RequestHandler createHandler(String handlerName, PersonService model, MessageDB messageDB, RegistratieDB regiDB) {
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("controller."+ handlerName);
			Object handlerObject = handlerClass.newInstance();
			handler = (RequestHandler) handlerObject;
	    	handler.setModel(model);
	    	handler.setMessagesDB(messageDB);
	    	handler.setRegiDB(regiDB);
		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}


}
