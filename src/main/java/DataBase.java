import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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


    public void insertName(String name, String surname) {

        String insertName = "INSERT INTO documents.person (first_name, last_name)" + "VALUES (?, ?)";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(url, user, passwd); PreparedStatement prpdSttmName = con.prepareStatement(insertName)) {

            prpdSttmName.setString(1, name);
            prpdSttmName.setString(2, surname);

            prpdSttmName.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void insertFile (String fileName, InputStream fileContent){

            String insertFiles = "INSERT INTO documents.files (filename, contentype)" + "VALUES (?, ?)";
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try (Connection con = DriverManager.getConnection(url, user, passwd); PreparedStatement prpdSttmFile = con.prepareStatement(insertFiles)) {

                prpdSttmFile.setString(1, fileName);
                prpdSttmFile.setBinaryStream(2, fileContent);

                prpdSttmFile.execute();


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }



    private Properties getConnectionData() {
        props = new Properties();
        String fileName = "D:\\IT\\Java\\LevelUp\\WorkWithFiles\\src\\main\\resources\\db.properties";

        try (FileInputStream in = new FileInputStream(fileName)) {
            props.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }
}
