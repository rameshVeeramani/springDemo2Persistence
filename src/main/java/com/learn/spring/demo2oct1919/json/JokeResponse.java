package com.learn.spring.demo2oct1919.json;

public class JokeResponse {
    private String type;
    private JokeValue value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JokeValue getValue() {
        return value;
    }

    public void setValue(JokeValue value) {
        this.value = value;
    }
}
