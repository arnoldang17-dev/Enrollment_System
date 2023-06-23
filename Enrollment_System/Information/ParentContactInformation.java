package Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.DatabaseConnection;

public class ParentContactInformation extends ContactInformation implements DatabaseConnection {

    private int Parent_Contact_Info_ID;

    public ParentContactInformation(int Address_ID, String email, String phoneNumber) {
        super(Address_ID, email, phoneNumber);

        this.Parent_Contact_Info_ID = 0;

        try (Connection con = connect()) {

            String sql = "Insert into parent_contact_info values(null, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Address_ID);
            pst.setString(2, email);
            pst.setString(3, phoneNumber);

            pst.executeUpdate();
            pst.close();

            String sql2 = "select Parent_Contact_Info_ID from parent_contact_info where Phone_Number = ? and Email = ?";

            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setString(1, phoneNumber);
            pst2.setString(2, email);

            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                this.Parent_Contact_Info_ID = rs.getInt("Parent_Contact_Info_ID");

            }

            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public int getID() {
        return Parent_Contact_Info_ID;

    }

    // print contact information class
    @Override
    public String toString() {
        String contactInfo = "";
        try (Connection con = connect()) {

            String sql = "select * from parent_contact_info where Parent_Contact_Info_ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Parent_Contact_Info_ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                contactInfo = "Parent Contact Information ID: " + rs.getInt("Parent_Contact_Info_ID") + "\n"
                        + "Address ID: " + rs.getInt("Address_ID") + "\n"
                        + "Email: " + rs.getString("Email") + "\n"
                        + "Phone Number: " + rs.getString("Phone_Number") + "\n";

            }

            con.close();

        } catch (SQLException e) {
            e.getMessage();
        }

        return contactInfo;
    }
}