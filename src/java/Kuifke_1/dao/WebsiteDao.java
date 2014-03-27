package Kuifke_1.dao;

import Kuifke_1.domain.CustomerBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dorsan Demaeght
 */
public class WebsiteDao {

    private static final String GET_QUERY = "select CustomerId, Date, Last_Name, First_Name, Gender, Email_Address, Username, Password, Language from Customer order by CustomerId";
    private static final String INSERT_QUERY = "insert into Customer (Date, Last_Name, First_Name, Gender, Email_Address, Username, Password, Language, Salt) values (sysdate(),?,?,?,?,?,?,?,?)";
    private static final String GET_USER_CREDENTIALS = "select Password, salt from customer where Username = ?;";
    private static final String GET_USER_INFO = "select Last_Name, First_Name, Gender, Email_Address, Username, Language from customer where username = ?";

    private String url;
    private String user;
    private String password;
    private static final String INIT = "use mydb";

    public void addCustomerItem(CustomerBean item) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Add Customer Item Geinitieerd");

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(INSERT_QUERY);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getFirstname());
            stmt.setString(3, item.getGender());
            stmt.setString(4, item.getEmail());
            stmt.setString(5, item.getUsername());
            stmt.setString(6, item.getPassword());
            stmt.setString(7, item.getLanguage());
            stmt.setString(8, item.getSalt());
            stmt1.execute();
            stmt.executeUpdate();
        }
    }

    public List<CustomerBean> getAllCustomerItems() throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Get All Customer Itemss Geinitieerd");

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(GET_QUERY);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            List<CustomerBean> items = new ArrayList<>();
            stmt1.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CustomerBean item = new CustomerBean();
                item.setDate(rs.getDate(1));
                item.setName(rs.getString(2));
                item.setFirstname(rs.getString(3));
                item.setGender(rs.getString(4));
                item.setEmail(rs.getString(5));
                item.setUsername(rs.getString(6));
                item.setPassword(rs.getString(7));
                item.setLanguage(rs.getString(8));
                items.add(item);
            }
            return items;
        }
    }

    public CustomerBean UserCheck(String username) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("User Check Geinitieerd");
        CustomerBean cust = new CustomerBean();

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(GET_USER_CREDENTIALS);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, username);
            stmt1.execute();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cust.setPassword(rs.getString(1));
                cust.setSalt(rs.getString(2));
                return cust;
            }

        }
        cust.setPassword("1");
        return cust;
    }

    public CustomerBean getUserDetails(String username) throws ClassNotFoundException, SQLException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("User Check Geinitieerd");
        CustomerBean cust = new CustomerBean();

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(GET_USER_INFO);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, username);
            stmt1.execute();
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cust.setLast_Name(rs.getString(1));
                cust.setFirst_Name(rs.getString(2));
                cust.setGender(rs.getString(3));
                cust.setEmail_Address(rs.getString(4));
                cust.setUsername(rs.getString(5));
                cust.setLanguage(rs.getString(6));

            }
            return cust;
        }
    }
}
