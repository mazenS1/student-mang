package databas;
import domain.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class studentDataBase {
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }
    public static void insertStudent(String fname,String lname,String address,String depart) throws SQLException{
        try(
                Connection con=connect();
                PreparedStatement p=con.prepareStatement("insert into students (fname,lname,adress,department)  values(?,?,?,?)");
        ) {    
        
        p.setString(1, fname);
        p.setString(2, lname);
        p.setString(3, address);
        p.setString(4, depart);
        p.execute();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }
    public static ArrayList<Student> getStudent(String s) {
        ArrayList<Student> list = new ArrayList<>();
        try(
                Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from students where department=?");
        ) {
            
            p.setString(1, s);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new Student(r.getInt("id"), r.getString("fname"), r.getString("lname"),r.getString("adress"),r.getString("department")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       return list;
    }
}
