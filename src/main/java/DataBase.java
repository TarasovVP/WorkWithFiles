import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase
{

    private Properties props = getConnectionData();

    private String url = props.getProperty("db.url");
    private String user = props.getProperty("db.user");
    private String passwd = props.getProperty("db.passwd");


    public void insert(String name, String surname){

        String insertName = "INSERT INTO documents.person (first_name, last_name)" + "VALUES (?, ?)";
        String insertFiles = "INSERT INTO documents.files (first_name, last_name)" + "VALUES (?, ?)";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(url, user, passwd); PreparedStatement prpdSttm = con.prepareStatement(insertName)) {

            prpdSttm.setString(1, name);
            prpdSttm.setString(2, surname);

            prpdSttm.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    private Properties getConnectionData() {
        props = new Properties();
        String fileName = "D:\\_aJavaBestTeam\\project\\WorkWithFiles\\src\\main\\resources\\db.properties";

        try (FileInputStream in = new FileInputStream(fileName)) {
            props.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }
}
