package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Parent extends Person2 implements DatabaseConnection {

    public Parent(String name, int contact_info_ID, int student_ID) {

        super(name, contact_info_ID);

        try (Connection con = connect()) {

            String sql = "Insert into Parent values(null, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, contact_info_ID);
            pst.setInt(3, student_ID);
            pst.executeUpdate();
            pst.executeQuery();
            System.out.println("Success adding parent");
            pst.close();
            con.close();

            System.out.println("parent details");
            System.out.println("Name: " + name);
            System.out.println("Contact Info ID: " + contact_info_ID);
            System.out.println("Student ID: " + student_ID);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.getMessage();

        }
    }

    @Override
    public int getID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getID'");
    }

}