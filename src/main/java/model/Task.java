package model;

import java.sql.Timestamp;

public class Task {
    private int id ;
    private String content;
    private Status status ;
    private Timestamp timestamp;
    private User user ;

    public Task(int id, String context, Status status, Timestamp timestamp, User user) {
        this.id = id;
        this.content = context;
        this.status = status;
        this.timestamp = timestamp;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
