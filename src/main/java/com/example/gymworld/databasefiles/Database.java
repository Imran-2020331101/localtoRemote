package com.example.gymworld.databasefiles;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    public static String url="jdbc:mysql://localhost:3306/gymworld";
    public static String username="root";
    public static String password="root";
    public Connection connectDB(){
        try {
            System.out.println("database.java");
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setContentText("Unable to make Database Connection");
            alert.showAndWait();
        }
        return null;

    }
}
