package databas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class degreeDataBase {
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }
    public static void insertDegree(int id,int m1,int m2,int m3,int m4,int m5,int m6) throws SQLException{
        try {    
        Connection con=connect();
        PreparedStatement p=con.prepareStatement("insert into degree (id,m1,m2,m3,m4,m5,m6,sum)  values(?,?,?,?,?,?,?,?)");
        p.setInt(1, id);
        p.setInt(2, m1);
        p.setInt(3, m2);
        p.setInt(4, m3);
        p.setInt(5, m4);
        p.setInt(6, m5);
        p.setInt(7, m6);
        p.setInt(8, m1+m2+m3+m4+m5+m6);
        p.execute();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }
}