import java.sql.*;

public class connections {
    Connection c;
    Statement s;
    public connections(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root" , "supermarket123" );
            s = c.createStatement();


        }catch(Exception e){
            System.out.println(e);
        }
    }
}
