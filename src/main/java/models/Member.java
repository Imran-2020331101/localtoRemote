package models;

import com.example.gymworld.databasefiles.Database;
import javafx.beans.binding.BooleanExpression;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Member {
    private int CustomerId;
    private String Name;
    private String Phone;
    private String Address;
    private String Profession;
    private Date Dob;
    private boolean isActive;
    private String Membership;
    private String Photo_name;
    private int Due;
    private Date lastPaymentDate;

    public PreparedStatement preparedStatement=null;
    public Connection connect=null;
    public boolean addNewMember(){
        Database database =new Database();
        String sql="insert into MEMBER(Member_ID,Name,Phone,Address,Profession,DOB,Active,Membership,Photo,Due) values(?,?,?,?,?,?,?,?,?,?)";
        if(connect==null){
            connect= database.connectDB();
        }
        try {
            preparedStatement=connect.prepareStatement(sql);
            preparedStatement.setInt(1,getCustomerId());
            preparedStatement.setString(2,getName());
            preparedStatement.setString(3,getPhone());
            preparedStatement.setString(4,getAddress());
            preparedStatement.setString(5,getProfession());
            preparedStatement.setDate(6,getDob());
            preparedStatement.setBoolean(7,isActive());
            preparedStatement.setString(8,getMembership());
            preparedStatement.setString(9,getPhoto_name());
            preparedStatement.setInt(10,getDue());
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


    public Member() {
    }
    public Member(int customerId, String name, String phone,
                  String address, String profession, Date dob,
                  String membership, String photo_name) {
        CustomerId = customerId;
        Name = name;
        Phone = phone;
        Address = address;
        Profession = profession;
        Dob = dob;
        this.isActive = true;
        Membership = membership;
        Photo_name = photo_name;
        this.Due=0;
    }
    public int getCustomerId() {
        return CustomerId;
    }
    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getProfession() {
        return Profession;
    }
    public void setProfession(String profession) {
        Profession = profession;
    }
    public Date getDob() {
        return Dob;
    }
    public void setDob(Date dob) {
        Dob = dob;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
    public String getMembership() {
        return Membership;
    }
    public void setMembership(String membership) {
        Membership = membership;
    }
    public String getPhoto_name() {
        return Photo_name;
    }
    public void setPhoto_name(String photo_name) {
        Photo_name = photo_name;
    }
    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }
    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }
    public int getDue() {
        return Due;
    }
    public void setDue(int due) {
        Due = due;
    }

}
