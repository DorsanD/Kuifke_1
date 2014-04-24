package Kuifke_1.dao;

import Kuifke_1.domain.ArtistBean;
import Kuifke_1.domain.CustomerBean;
import Kuifke_1.domain.TrackBean;
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
    private static final String GET_ARTIST_QUERY = "select ArtistId, Artist_Name, Last_Name, First_Name, Gender, Email_Address, Username, Password, Language from artiest order by ArtistId";
    private static final String INSERT_QUERY = "insert into Customer (Date, Last_Name, First_Name, Gender, Email_Address, Username, Password, Language, Salt) values (sysdate(),?,?,?,?,?,?,?,?)";
    private static final String INSERT_ARTIST_QUERY = "insert into Artist (Artist_Name, Last_Name, First_Name, Gender, Email_Address, Username, Password, Language, Salt) values (?,?,?,?,?,?,?,?,?)";
    private static final String GET_USER_CREDENTIALS = "select Password, salt from customer where Username = ?;";
    private static final String GET_ARTISTUSER_CREDENTIALS = "select Password, salt from artiest where Username = ?;";
    private static final String GET_USER_INFO = "select Last_Name, First_Name, Gender, Email_Address, Username, Language, CustomerId from customer where Username = ?";
    private static final String GET_ARTISTUSER_INFO = "select Artist_Name, Last_Name, First_Name, Gender, Email_Address, Username, Language, ArtistId from artiest where Username = ?";
    private static final String ALTER_USERNAME = "update customer set First_Name= ? where CustomerId= ?";
    private static final String ALTER_ARTISTUSERNAME = "update artiest set First_Name= ? where ArtistId= ?";
    private static final String DELETE_USER = "delete from customer where CustomerId=?;";
    private static final String DELETE_ARTIST = "delete from artiest where ArtistId=?;";
    private static final String INSERT_FILE_QUERY = "insert into track (Track_Name, Genre, Length, File_Location, Image_Location) values (?,?,?,?,?)";

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

    public void addArtistItem(ArtistBean item) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Add Artist Item Geinitieerd");

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(INSERT_ARTIST_QUERY);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, item.getArtist_Name());
            stmt.setString(2, item.getLast_Name());
            stmt.setString(3, item.getFirst_Name());
            stmt.setString(4, item.getGender());
            stmt.setString(5, item.getEmail_Address());
            stmt.setString(6, item.getUsername());
            stmt.setString(7, item.getPassword());
            stmt.setString(8, item.getLanguage());
            stmt.setString(9, item.getSalt());
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
                item.setCustomerId(rs.getInt(1));
                item.setDate(rs.getDate(2));
                item.setName(rs.getString(3));
                item.setFirstname(rs.getString(4));
                item.setGender(rs.getString(5));
                item.setEmail(rs.getString(6));
                item.setUsername(rs.getString(7));
                item.setPassword(rs.getString(8));
                item.setLanguage(rs.getString(9));
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

    public ArtistBean ArtistCheck(String username) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("User Check Geinitieerd");
        ArtistBean art = new ArtistBean();

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(GET_ARTISTUSER_CREDENTIALS);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, username);
            stmt1.execute();
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                art.setPassword(rs.getString(1));
                art.setSalt(rs.getString(2));
                return art;
            }

        }
        art.setPassword("1");
        return art;
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
                cust.setCustomerId(rs.getInt(7));

            }
            return cust;
        }
    }

    public ArtistBean getArtistUserDetails(String username) throws ClassNotFoundException, SQLException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Artist Check Geinitieerd");
        ArtistBean art = new ArtistBean();

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(GET_ARTISTUSER_INFO);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, username);
            stmt1.execute();
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                art.setArtist_Name(rs.getString(1));
                art.setLast_Name(rs.getString(2));
                art.setFirst_Name(rs.getString(3));
                art.setGender(rs.getString(4));
                art.setEmail_Address(rs.getString(5));
                art.setUsername(rs.getString(6));
                art.setLanguage(rs.getString(7));
                art.setArtistId(rs.getInt(8));

            }
            return art;
        }
    }

    public void AlterName(int CustomerId, String First_Name) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("User Check Geinitieerd");

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(ALTER_USERNAME);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, First_Name);
            stmt.setInt(2, CustomerId);
            System.out.println("" + stmt.toString());
            stmt1.execute();
            stmt.execute();

        }

    }

    public void AlterArtistName(int ArtistId, String First_Name) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("User Check Geinitieerd");

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(ALTER_ARTISTUSERNAME);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, First_Name);
            stmt.setInt(2, ArtistId);
            System.out.println("" + stmt.toString());
            stmt1.execute();
            stmt.execute();

        }

    }

    public void DeleteUser(int CustomerId) throws ClassNotFoundException, SQLException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Delete User");

        try (Connection con = connect.initCon();
                PreparedStatement stmt1 = con.prepareStatement(DELETE_USER);
                PreparedStatement stmt2 = con.prepareStatement(INIT)) {
            stmt1.setInt(1, CustomerId);
            System.out.println("" + stmt1.toString());
            stmt2.execute();
            stmt1.execute();
        }
    }

    public void DeleteArtist(int ArtistId) throws ClassNotFoundException, SQLException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Delete Artist");

        try (Connection con = connect.initCon();
                PreparedStatement stmt1 = con.prepareStatement(DELETE_ARTIST);
                PreparedStatement stmt2 = con.prepareStatement(INIT)) {
            stmt1.setInt(1, ArtistId);
            System.out.println("" + stmt1.toString());
            stmt2.execute();
            stmt1.execute();
        }
    }

    public void addTrackItem(TrackBean item) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Add Track Item Geinitieerd");

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(INSERT_FILE_QUERY);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, item.getTrack_Name());
            stmt.setString(2, item.getGenre());
            stmt.setInt(3, item.getLength());
            stmt.setString(4, item.getFile_Location());
            stmt.setString(5, item.getImage_Location());
            stmt1.execute();
            stmt.executeUpdate();
        }
    }

}
