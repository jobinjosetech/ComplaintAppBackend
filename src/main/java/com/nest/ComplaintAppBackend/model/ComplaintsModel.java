package com.nest.ComplaintAppBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaint")
public class ComplaintsModel {
    @Id
    @GeneratedValue()
    private int id;
    private int userID;
    private String complaint;
    private String date;

    public ComplaintsModel() {
    }

    public ComplaintsModel(int id, int userID, String complaint, String date) {
        this.id = id;
        this.userID = userID;
        this.complaint = complaint;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
