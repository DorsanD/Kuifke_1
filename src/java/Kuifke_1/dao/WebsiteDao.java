package Kuifke_1.dao;

import Kuifke_1.domain.WebsiteBean;
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
    private static final String INSERT_QUERY = "insert into Customer (Date, Last_Name, First_Name, Gender, Email_Address, Username, Password, Language) values (?,?,?,?,?,?,?,?)";

    private String url;
    private String user;
    private String password;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriver(String driver) throws ClassNotFoundException {
        Class.forName(driver);
    }

    public void addCustomerItem(WebsiteBean item) throws SQLException {
        try (Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(INSERT_QUERY)) {
            stmt.setTimestamp(1, new Timestamp(item.getDate().getTime()));
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getFirstname());
            stmt.setString(4, item.getGender());
            stmt.setString(5, item.getEmail());
            stmt.setString(6, item.getUsername());
            stmt.setString(7, item.getPassword());
            stmt.setString(8, item.getLanguage());
            stmt.executeUpdate();
        }
    }
    
        public List<WebsiteBean> getAllCustomerItems() throws SQLException {
        try (Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(GET_QUERY)) {
            List<WebsiteBean> items = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                WebsiteBean item = new WebsiteBean();
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


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
