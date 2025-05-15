package com.jorgea.PFC.to;

public class GenresNameTo {
    private String name;

    public GenresNameTo() {
    }

    public GenresNameTo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "genres{" + "name=" + name + '}';
    }

}
