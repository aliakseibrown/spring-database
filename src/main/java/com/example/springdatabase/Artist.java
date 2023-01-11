package com.example.springdatabase;

import org.springframework.stereotype.Component;

@Component
public class Artist {
    private String name;
    private String country;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void compile(){
        System.out.println("compiling");
    }
}
