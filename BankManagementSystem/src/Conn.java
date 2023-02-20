import java.sql.*;
public class Conn {


    Connection c;
    Statement s;

    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystematm", "root","Reshma@10$2004#&$" );

            s = c.createStatement();

        } catch (Exception e ){
            System.out.println(e);
        }
    }
}

