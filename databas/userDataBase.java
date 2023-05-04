package databas;
import domain.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class userDataBase {
    public static Connection connect() throws SQLException {
            
            return DriverManager.getConnection("jdbc:sqlite:uni.db");
        
    }
    public static void insertUser(String user,String pass,String depart) throws SQLException{
        try {    
        Connection con=connect();
        PreparedStatement p=con.prepareStatement("insert into user values(?,?,?)");
        p.setString(1, user);
        p.setString(2, pass);
        p.setString(3, depart);
        p.execute();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }
    public static ArrayList<user> getUser() {
        ArrayList<user> list = new ArrayList<>();
        try {
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from user");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new user(r.getString("user_name"), r.getString("password"), r.getString("department")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       return list;
    }
    public static int checkUser(String user,String pass)
    {
        ArrayList<user> arr = getUser();
        int x=0;
        for (int i = 0; i < arr.size(); i++) 
        {
            if (arr.get(i).getUser_name().equals(user)) 
            {
                if (arr.get(i).getPassword().equals(pass)) 
                {
                    x=1;
                    break;
                }
                else
                {
                    x=2;
                    break;
                }
            }
            else
                x=0;
        }
        return x;
    }
    public static String getDepartment(String user){
        try {
            Connection con=connect();
            PreparedStatement p=con.prepareStatement("select department from user where user_name =?");
            p.setString(1, user);
            ResultSet r = p.executeQuery();
            return r.getString("department");
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            return null;
        }
    }
}
