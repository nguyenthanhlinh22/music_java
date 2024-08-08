package com.example.music.entity;

public class Status {
    private int statusid;
    private String statusname;

    public Status(String statusname) {
        this.statusname = statusname;
    }

    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }
}

