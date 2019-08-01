package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**Entity annotated class will have the ability to represent objects in the database*/
@Entity
public class Track {
    public Track() {

    }

    public Track(int id, String name, String comments) {
        this.id = id;
        this.name = name;
        this.comments = comments;
    }

    /**Id annotation make id variable as Primary key*/
    @Id
    private int id;
    private String name;
    private String comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
