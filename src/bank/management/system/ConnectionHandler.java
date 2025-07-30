package bank.management.system;

import java.sql.*;
import static java.sql.DriverManager.getConnection;

public class ConnectionHandler {

     Connection connection;
     Statement Statement;
    
     public ConnectionHandler(){     //constracter are create
        try{
            connection= getConnection("jdbc:mysql://localhost:3306/BankSystem","root","@Sumit123");
            Statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
