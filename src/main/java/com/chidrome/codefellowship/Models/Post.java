package com.chidrome.codefellowship.Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ManyToOne
    public AppUser creator;
    public String body;
    public Timestamp createdAt;

    // constructor
    public Post(){}
    public Post(String body, AppUser creator){
        this.body = body;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.creator = creator;
    }

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public AppUser getCreator() {
        return creator;
    }


}
