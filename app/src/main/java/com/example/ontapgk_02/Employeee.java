package com.example.ontapgk_02;

public abstract class Employeee {
    private String id, name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract double TinhLuong();
    @Override
    public String toString() {
        return this.id + " - " + this.name;
    }
}
