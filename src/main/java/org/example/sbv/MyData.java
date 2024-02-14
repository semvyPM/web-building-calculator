package org.example.sbv;

public class MyData {
    private String name;
    private int id;

    public MyData(String name) {
        this.name = name;
    }

    public MyData(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
