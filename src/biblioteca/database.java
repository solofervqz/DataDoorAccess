package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {

    // Método para conectar a la base de datos
    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/bibliotec", "root", "");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // Método main para probar la funcionalidad
    public static void main(String[] args) {

    }
}


/*package biblioteca;

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
*/