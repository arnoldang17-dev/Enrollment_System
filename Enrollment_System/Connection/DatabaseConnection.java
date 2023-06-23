package Connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Random;

public interface DatabaseConnection {

    default Connection connect() {
        System.out.println("Connecting to database...");
        Connection con = null;
        //String url = "jdbc:mysql://dusk.mysql.database.azure.com:3306/test_integration?useSSL=true";
        String url = "jdbc:mysql://localhost:3306/test7";

        
        try {
            //return con = DriverManager.getConnection(url, "Arceus", "m67Ds#rAm6");
            return con = DriverManager.getConnection(url, "root", "");


        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return null;
    }

    public int getID();
}