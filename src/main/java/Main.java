import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by clara on 12/6/17.
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
 
        
        String databaseName = "reviews";
        String instanceConnectionName = "hello-sql-186104:us-central1:movies";
        String username = "clara";
        String password = System.getenv("DB_PASSWORD");
        
        // Connect to server
    
        //https://cloud.google.com/sql/docs/mysql/connect-external-app#java
    
        String jdbcUrl = String.format(
                "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
                        + "socketFactory=com.google.cloud.sql.mysql.SocketFactory",
                databaseName,
                instanceConnectionName);
    
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
    
        String sql = "create table  if not exists rev (movie_name varchar(50), stars integer)";
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
        
        String insertSQL = "insert into rev values ('spiderman', 4)";
        s.executeUpdate(insertSQL);
    
    
        insertSQL = "insert into rev values ('wonder woman', 5)";
        s.executeUpdate(insertSQL);
    
        
        ResultSet rs = s.executeQuery("select * from rev");
        
        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getInt(2));
        }
        
        
    }
}
