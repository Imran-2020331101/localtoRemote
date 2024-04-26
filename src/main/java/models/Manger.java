package models;

import com.example.gymworld.databasefiles.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Manger {
    private String Name;
    private String NID;
    private String Address;
    private java.sql.Date joiningDate;

    public Manger() {
    }

    public Manger(String name, String NID,  String address, Date joiningDate) {
        this.NID = NID;
        Name = name;
        Address = address;
        this.joiningDate = joiningDate;
    }

    public boolean addNewMember(){
        Database database =new Database();
        String sql="insert into manager(Manager_Name, Manager_NID, Address, JoiningDate) VALUES (?,?,?,?)";

        if(Database.connection==null){
            Database.connection= database.connectDB();
        }
        try {
            PreparedStatement preparedStatement = Database.connection.prepareStatement(sql);
            preparedStatement.setString(1,getName());
            preparedStatement.setString(2,getNID());
            preparedStatement.setString(3,getAddress());
            preparedStatement.setDate(4,getJoiningDate());
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
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


}
