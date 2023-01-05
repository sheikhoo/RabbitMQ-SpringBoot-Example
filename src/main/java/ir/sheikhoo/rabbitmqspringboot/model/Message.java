package ir.sheikhoo.rabbitmqspringboot.model;

public class Message {

    private String title;
    private String text;
    private String sender;

    public Message() {
    }

    public Message(String title, String text, String sender) {
        this.title = title;
        this.text = text;
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}