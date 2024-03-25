package models;

import java.sql.Date;

public class Manger {

    public Manger() {
    }

    public Manger(int managerId, String NID, String name, String address, Date joiningDate) {
        ManagerId = managerId;
        this.NID = NID;
        Name = name;
        Address = address;
        this.joiningDate = joiningDate;
    }

    private int ManagerId;

    public int getManagerId() {
        return ManagerId;
    }

    public void setManagerId(int id) {
        this.ManagerId = id;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    private String NID;
    private String Name;
    private String Address;
    private java.sql.Date joiningDate;

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    private String Designation;


}
