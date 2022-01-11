package com.example.app.ioc;

public abstract class Ingredinet {

    private String name;

    public Ingredinet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
