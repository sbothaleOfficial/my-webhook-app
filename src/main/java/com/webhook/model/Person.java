package com.webhook.model;

public class Person {
    private String name;
    private String id;
    private String location;

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, String id, String location) {
        this.name = name;
        this.id = id;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
}