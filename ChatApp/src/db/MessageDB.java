package db;

import domain.Message;

import java.util.ArrayList;

public class MessageDB {
  private ArrayList<Message> messages;

  public MessageDB(){
    messages = new ArrayList<>();
    basicFill();
  }

  public ArrayList<Message> getMessages() {
    return messages;
  }

  public ArrayList<Message> getMessagesFromTo(
          String from, String to) {
    ArrayList<Message> res = new ArrayList<>();
    System.out.println("Reading all messages from: "+from);
    System.out.println("And: " + to);
    for(Message m: messages){
      if((m.getFrom().equals(from) && m.getTo().equals(to)) ||
              (m.getFrom().equals(to) && m.getTo().equals(from))){
        res.add(m);
      }
    }
    return res;
  }

  public void addMessage(Message m){
    messages.add(m);
  }

  private void basicFill(){
    Message m1 = new Message("jan@ucll.be",
            "stijn@ucll.be","Hey zieke daas");
    Message m2 = new Message("stijn@ucll.be",
            "jan@ucll.be","u ma is een daas");
    Message m3 = new Message("jan@ucll.be",
            "stijn@ucll.be", "classuc kkr stijn");
    messages.add(m1);
    messages.add(m2);
    messages.add(m3);
  }
}
