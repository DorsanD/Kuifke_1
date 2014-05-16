package Kuifke_1.dao;

import Kuifke_1.domain.ArtistBean;
import Kuifke_1.domain.CustomerBean;
import Kuifke_1.domain.TrackBean;
import Kuifke_1.domain.BIBean;
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
    
    //variabelen en queries die gebruikt zullen worden in de functies
    private static final String GET_QUERY = "select CustomerId, Date, Last_Name, First_Name, Gender, Email_Address, Username, Password, Language, Credits from Customer order by CustomerId";
    private static final String INSERT_QUERY = "insert into Customer (Date, Last_Name, First_Name, Gender, Email_Address, Username, Password, Language, Salt) values (sysdate(),?,?,?,?,?,?,?,?)";
    private static final String INSERT_ARTIST_QUERY = "insert into Artiest (Artist_Name, Last_Name, First_Name, Gender, Email_Address, Username, Password, Language, Salt) values (?,?,?,?,?,?,?,?,?)";
    private static final String GET_USER_CREDENTIALS = "select Password, salt from customer where Username = ?;";
    private static final String GET_ARTISTUSER_CREDENTIALS = "select Password, salt from artiest where Username = ?;";
    private static final String GET_USER_INFO = "select Last_Name, First_Name, Gender, Email_Address, Username, Language, CustomerId, Credits from customer where Username = ?";
    private static final String GET_ARTISTUSER_INFO = "select Artist_Name, Last_Name, First_Name, Gender, Email_Address, Username, Language, ArtistId from artiest where Username = ?";
    private static final String ALTER_USERNAME = "update customer set First_Name= ? where CustomerId= ?";
    private static final String ALTER_ARTISTUSERNAME = "update artiest set First_Name= ? where ArtistId= ?";
    private static final String DELETE_USER = "delete from customer where CustomerId=?;";
    private static final String DELETE_ARTIST = "delete from artiest where ArtistId=?;";
    private static final String INSERT_FILE_QUERY = "insert into track (Track_Name, Genre, Length, File_Location, Image_Location) values (?,?,?,?,?)";
    private static final String BI_Query = "SELECT TABLE_NAME,COLUMN_NAME,DATA_TYPE  FROM INFORMATION_SCHEMA.COLUMNS where table_schema = 'mydb' and COLUMN_NAME not like ('%id')";
    //haal ook de id van de track op en schrijf deze ook weg in de bean
    private static final String TRACKS_QUERY = "SELECT t.TrackId, t.Track_Name, a.Artist_Name, t.Length, t.Genre, t.File_Location from mydb.track t, mydb.artiest a where t.Artiest_ArtistId = a.ArtistId;";
    private static final String ALTER_CUSTCREDITS = "update customer set Credits = ? where CustomerId = ?;";
    private static final String SELECT_CREDITS = "SELECT Credits FROM customer where CustomerId = ?;";
    private static final String SELECT_TRACK = "SELECT File_Location from track where TrackId = ?";
    private static final String INIT = "use mydb";

    //Een gebruiker toevoegen in onze databank
    public void addCustomerItem(CustomerBean item) throws SQLException, ClassNotFoundException {
        //connectie maken
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Add Customer Item Geinitieerd");
        
        //Query laten runnen en dan de nodige variabelen invullen
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

        //Een Artist toevoegen in onze databank
    public void addArtistItem(ArtistBean item) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Add Artist Item Geinitieerd");
       
       //Query laten runnen en dan de nodige variabelen invullen       
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

    //Een functie om een lijst te maken van alle gebruikers
    //deze functie wordt niet gebruikt, maar kan van pas komen in toekomstige uitbreidingen.
    public List<CustomerBean> getAllCustomerItems() throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Get All Customer Itemss Geinitieerd");

        //laat de query lopen en zet alle gebruikers in een list van gebruikerbeans
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
                item.setCredits(rs.getInt(10));
                items.add(item);
            }
            return items;
        }
    }

    //Een functie om gegevens van de gebruiker in te vullen en doorgeven ter verificatie
    public CustomerBean UserCheck(String username) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("User Check Geinitieerd");
        
        //een nieuwe bean van de klasse CustomerBean aanroepen
        CustomerBean cust = new CustomerBean();

        //vult het veld met variabele username in
        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(GET_USER_CREDENTIALS);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, username);
            stmt1.execute();
            ResultSet rs = stmt.executeQuery();
            //if statement zet paswoord en salt in cust, om deze in de functie te vergelijken. 
            if (rs.next()) {
                cust.setPassword(rs.getString(1));
                cust.setSalt(rs.getString(2));
                return cust;
            }

        }
        cust.setPassword("1");
        return cust;
    }

    //Een functie om gegevens van de artist in te vullen en doorgeven ter verificatie
    public ArtistBean ArtistCheck(String username) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Artist Check Geinitieerd");
        ArtistBean art = new ArtistBean();

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(GET_ARTISTUSER_CREDENTIALS);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, username);
            stmt1.execute();
            ResultSet rs = stmt.executeQuery();
            //if statement zet paswoord en salt in cust, om deze in de functie te vergelijken. 
            if (rs.next()) {
                art.setPassword(rs.getString(1));
                art.setSalt(rs.getString(2));
                return art;
            }

        }
        art.setPassword("1");
        return art;
    }

    //Een functie die alle informatie van een customer haalt en in een tijdelijke bean opslaagt.
    public CustomerBean getUserDetails(String username) throws ClassNotFoundException, SQLException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Get user details Geinitieerd");
        CustomerBean cust = new CustomerBean();

        //zet alle opgehaalde informatie op de juiste plaats in de bean
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
                cust.setCredits(rs.getInt(8));

            }
            return cust;
        }
    }

    //Een functie die alle informatie van een artist haalt en in een tijdelijke bean opslaagt. 
    public ArtistBean getArtistUserDetails(String username) throws ClassNotFoundException, SQLException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Artist Check Geinitieerd");
        ArtistBean art = new ArtistBean();

         //zet alle opgehaalde informatie op de juiste plaats in de bean       
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

    //Functie die de query uitvoert om een Username om te zetten naar een nieuwe.
    public void AlterName(int CustomerId, String First_Name) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Alter Name Geinitieerd");

        //Zet de gegeven variabelen in de query en laat dan de query lopen.
        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(ALTER_USERNAME);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, First_Name);
            stmt.setInt(2, CustomerId);
            stmt1.execute();
            stmt.execute();

        }

    }

    //Functie die de query uitvoert om een Username om te zetten naar een nieuwe.    
    public void AlterArtistName(int ArtistId, String First_Name) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("User Check Geinitieerd");

        //Zet de gegeven variabelen in de query en laat dan de query lopen.        
        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(ALTER_ARTISTUSERNAME);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(1, First_Name);
            stmt.setInt(2, ArtistId);
            stmt1.execute();
            stmt.execute();

        }

    }
   
    //Functie die de query uitvoert om een gebruiker met een gegeven ID te verwijderen uit de databank    
    public void DeleteUser(int CustomerId) throws ClassNotFoundException, SQLException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Delete User");

        //Zet de gegeven variabelen in de query en laat dan de query lopen.                
        try (Connection con = connect.initCon();
                PreparedStatement stmt1 = con.prepareStatement(DELETE_USER);
                PreparedStatement stmt2 = con.prepareStatement(INIT)) {
            stmt1.setInt(1, CustomerId);
            stmt2.execute();
            stmt1.execute();
        }
    }

    //Functie die de query uitvoert om een artiest met een gegeven ID te verwijderen uit de databank    
    public void DeleteArtist(int ArtistId) throws ClassNotFoundException, SQLException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Delete Artist");

        //Zet de gegeven variabelen in de query en laat dan de query lopen.                
        try (Connection con = connect.initCon();
                PreparedStatement stmt1 = con.prepareStatement(DELETE_ARTIST);
                PreparedStatement stmt2 = con.prepareStatement(INIT)) {
            stmt1.setInt(1, ArtistId);
            stmt2.execute();
            stmt1.execute();
        }
    }

    //een Track toevoegen aan onze databank
    public void addTrackItem(TrackBean item) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Add Track Item Geinitieerd");

       //Query laten runnen en dan de nodige variabelen invullen               
        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(INSERT_FILE_QUERY);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setString(2, item.getTrack_Name());
            stmt.setString(3, item.getGenre());
            stmt.setInt(4, item.getLength());
            stmt.setString(5, item.getFile_Location());
            stmt.setString(6, item.getImage_Location());
            stmt1.execute();
            stmt.executeUpdate();
        }
    }

    public List<BIBean> getColumns() throws SQLException, ClassNotFoundException {
        //deze functie haalt de namen van alle columns in de DB op
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("");
        System.out.println("--- systeemtabellen worden opgehaald ---");

        List<BIBean> biBeans = new ArrayList<>();
        try (Connection con = connect.initCon();
                PreparedStatement stmt1 = con.prepareStatement(INIT);
                PreparedStatement stmt = con.prepareStatement(BI_Query)) {
            stmt1.execute();
            ResultSet rs = stmt.executeQuery();

            for (int i = 1; rs.next(); i++) {
                BIBean bi = new BIBean();
                bi.setTable(rs.getString(1));
                bi.setColumn(rs.getString(2));
                bi.setType(rs.getString(3));
                bi.setId(i);
                biBeans.add(bi);
            }
        }
        System.out.println("alle tabellen opgehaald");
        System.out.println(biBeans);
        return biBeans;

    }

    public List<BIBean> getColumnsData(List<BIBean> BIBean) throws SQLException, ClassNotFoundException {
        //deze functie haalt de data van de gevraagde colummen uit de database
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("");
        System.out.println("--- DATA wordt uit de GEKOZEN systeemtabellen gehaald ---");

        //eindproduct
        List<BIBean> dataBean = new ArrayList<>();

        //stel de geselecteerde kollomen in in een query
        System.out.println("de gekozen tabellen zijn:");
        int j = 1;
        String query = "select ";
        for (int i = 0; i < BIBean.size(); i++, j++) {

            query += BIBean.get(i).getTabelCol();
            if (i != BIBean.size() - 1) {
                query += ",";
            }
            System.out.println("kolom " + BIBean.get(i).getTabelCol() + " toegevoegd aan de query");
        }
        query += " from customer c, artiest a, track t ";
        System.out.println(query);

        try (Connection con = connect.initCon();
                PreparedStatement stmt1 = con.prepareStatement(INIT);
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt1.execute();
            ResultSet rs = stmt.executeQuery();

            System.out.println("");
            System.out.println("** resultaten worden uitgelezen en weggeschreven **");

            //steek de data in de kollomen
            while (rs.next()) {
                for (int i = 0; i < BIBean.size(); i++) {
                    String type = BIBean.get(i).getConverType();

                    BIBean data = new BIBean();

                    //voor we de bean de data geven stellen we ook de column en de table in
                    data.setTable(BIBean.get(i).getTable());
                    data.setColumn(BIBean.get(i).getColumn());
                    data.setType(BIBean.get(i).getType());
                    data.setId(BIBean.get(i).getId());

                    switch (type) {
                        case "String":
                            data.setData(rs.getString(i + 1));

                            break;
                        case "Date":
                            data.setData(rs.getDate(i + 1) + "");
                            break;
                        case "Boolean":
                            //bij true => 1 anders => 0
                            System.out.println(rs.getBoolean(i + 1));
                            if (rs.getBoolean(i + 1)) {
                                data.setData("1");
                            } else {
                                data.setData("0");
                            }
                            ;
                            break;
                        case "int":

                            data.setData(rs.getInt(i + 1) + " ");
                            break;
                    }
                    dataBean.add(data);

                }
            }
            System.out.println("done!");
        }
        return dataBean;

    }

    public List<TrackBean> getAllTracks() throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Get All Tracks Itemss Geinitieerd");

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(TRACKS_QUERY);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            List<TrackBean> tracks = new ArrayList<>();
            stmt1.execute();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TrackBean track = new TrackBean();
                track.setTrackId(rs.getInt(1));
                track.setTrack_Name(rs.getString(2));
                track.setArtist_Name(rs.getString(3));
                track.setLength(rs.getInt(4));
                track.setGenre(rs.getString(5));
                track.setFile_Location(rs.getString(6));
                tracks.add(track);
            }
            return tracks;
        }
    }

    public void AlterCustomerCredits(int Credits, int CustomerId) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Add Credits Geinitieerd");
        int credieten = 0;

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(ALTER_CUSTCREDITS);
                PreparedStatement stmt1 = con.prepareStatement(SELECT_CREDITS);
                PreparedStatement stmt2 = con.prepareStatement(INIT)) {
            stmt1.setInt(1, CustomerId);
            stmt2.execute();
            stmt1.execute();
            ResultSet rs = stmt1.executeQuery();
            
            System.out.println("" + stmt.toString());
            if (rs.next()){
            credieten = rs.getInt(1);
            
            stmt.setInt(1, credieten + Credits);
            stmt.setInt(2, CustomerId);
            stmt.execute();
        }}

    }

    public boolean RetractCustomerCredits(int CustomerId) throws SQLException, ClassNotFoundException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Retract Credits Geinitieerd");
        int credieten = 0;
        
        
        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(ALTER_CUSTCREDITS);
                PreparedStatement stmt1 = con.prepareStatement(SELECT_CREDITS);
                PreparedStatement stmt2 = con.prepareStatement(INIT)) {
            stmt1.setInt(1, CustomerId);
            stmt2.execute();
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()){

            credieten = rs.getInt(1);
            if (credieten > 50){            

            stmt.setInt(1, credieten - 50);
            stmt.setInt(2, CustomerId);
                            System.out.println("" + stmt.toString());

            stmt.execute();
            return true;
            } else {
                return false;
            }
            } else {
            return false;
            }
        

    }}
    
        public String getTrackLocation(int TrackId) throws ClassNotFoundException, SQLException {
        Connectie connect = new Connectie();
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Track Dwnl link Check Geinitieerd");

        try (Connection con = connect.initCon();
                PreparedStatement stmt = con.prepareStatement(SELECT_TRACK);
                PreparedStatement stmt1 = con.prepareStatement(INIT)) {
            stmt.setInt(1, TrackId);
            stmt1.execute();
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
              return rs.getString(1);

            }
            return null;
        }
    }
}
