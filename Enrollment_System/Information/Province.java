/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Information;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Province implements DatabaseConnection {
   
    private int province_ID;
    
    public Province(String Province) {
        
        this.province_ID = 0;
        
        try (Connection con = connect()) {

            String sql = "select Province_ID from Provinces where Province = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Province);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.province_ID = rs.getInt("Province_ID");
                
            }
            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    public Province() {
        this.province_ID = 0;
        
    }
    
    public String[] getProvinces() {
        try (Connection con = connect()) {

            Statement st = con.createStatement();

            String sql = "select Province from Provinces";

            ResultSet rs = st.executeQuery(sql);

            // ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            ArrayList<String> items = new ArrayList<>();

            while (rs.next()) {
                String a = rs.getString("Province");
                items.add(a);
            }
            items.add(0, "Province");
            st.close();
            String[] subItems = new String[items.size()];
            items.toArray(subItems);
            return subItems;

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;

    }

    @Override
    public int getID() {
        
        return province_ID;
    }
}