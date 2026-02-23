package scr;
import java.sql.*;

public class UserDAO {

    public static void addUser(int id,String name,String email){

        try{

            Connection con = DBConnection.getConnection();

            String q="INSERT INTO users(user_id,name,email_id) VALUES(?,?,?)";

            PreparedStatement ps=con.prepareStatement(q);

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,email);

            ps.executeUpdate();

            System.out.println("User Added 👤");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

