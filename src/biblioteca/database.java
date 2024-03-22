package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
        public static Connection connectDb(){
        
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connect = 
                DriverManager.getConnection("jdbc:mysql://localhost/bibliotec", "root", "");
            
            return connect;
            
        }catch(Exception e){e.printStackTrace();} 
        
        return null;
    }

}
