package domain;

public class Message {
  private String from, to, message;

  public Message(String from, String to, String message){
    this.from = from;
    this.to = to;
    this.message = message;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public String getMessage() {
    return message;
  }
}
