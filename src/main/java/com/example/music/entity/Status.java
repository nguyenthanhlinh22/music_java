package com.example.music.entity;

public class Status {
    private int Statusid;
    private String StatusName;

    public Status( int statusid,String statusName){

       
        this.Statusid = statusid;
        StatusName = statusName;

    }

    public Status(String statusName) {
    }

    public int getStatusid(int statusid) {
        return Statusid;
    }

    public void setStatusid(int statusid) {
        Statusid = statusid;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String statusName) {
        StatusName = statusName;
    }
}
