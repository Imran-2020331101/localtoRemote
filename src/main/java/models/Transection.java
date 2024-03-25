package models;

import com.example.gymworld.databasefiles.Database;
import enums.TransectionType;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transection {
    private int CustomerId;
    private int ManagerId;
    private Date createdDate;
    private int amount;
    private TransectionType transectiontype;
    public Transection() {
    }
    public Transection(int customerId,
                       int managerId, Date createdDate, int amount, TransectionType transectiontype) {
        CustomerId = customerId;
        ManagerId = managerId;
        this.createdDate = createdDate;
        this.amount = amount;
        this.transectiontype = transectiontype;
    }

    public Connection connect=null;
    public boolean addNewTransection(){
        
        Database database =new Database();
        String sql="insert into transection(Member_ID,Name,Phone,Address,Profession,DOB,Active,Membership,Photo,Due) values(?,?,?,?,?,?,?,?,?,?)";
        if(connect==null){
            connect= database.connectDB();
        }
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
//            preparedStatement.setInt(1,getCustomerId());
//            preparedStatement.setString(2,getName());
//            preparedStatement.setString(3,getPhone());
//            preparedStatement.setString(4,getAddress());
//            preparedStatement.setString(5,getProfession());
//            preparedStatement.setDate(6,getDob());
//            preparedStatement.setBoolean(7,isActive());
//            preparedStatement.setString(8,getMembership());
//            preparedStatement.setString(9,getPhoto_name());
//            preparedStatement.setInt(10,getDue());
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getManagerId() {
        return ManagerId;
    }

    public void setManagerId(int managerId) {
        ManagerId = managerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransectionType getTransectiontype() {
        return transectiontype;
    }

    public void setTransectiontype(TransectionType transectiontype) {
        this.transectiontype = transectiontype;
    }


}
