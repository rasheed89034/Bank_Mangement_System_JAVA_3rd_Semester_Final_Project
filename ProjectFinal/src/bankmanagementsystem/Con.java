package bankmanagementsystem;
import java.sql.*;


//--------------------------------------------------------------------------------------Con Classs ---------------------------------------------------
public class Con {

    //-----------------------------------------------------------Object initialization----------------------------------------------------
    Connection connection;
    //-----------------------------------------------------------------------------Default Statement Class----------------------------------------------------
    Statement statement;

    //--------------------------------------------------------------------------------------Con Class Constructor----------------------------------------------------
    public Con(){
        try{
            //--------------------------------------------------------------------------------Pass the complete path of your database----------------------------------------------------
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankSystem01","root","");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

