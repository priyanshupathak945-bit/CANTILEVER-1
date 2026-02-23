package scr;
import java.sql.*;

public class BookDAO {

    public static void addBook(int id,String title,String author,int qty){

        try{

            Connection con = DBConnection.getConnection();

            String q = "INSERT INTO books(book_id,book_title,book_author,book_quantity) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1,id);
            ps.setString(2,title);
            ps.setString(3,author);
            ps.setInt(4,qty);

            ps.executeUpdate();

            System.out.println("Book Added 📚");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void viewBooks(){

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM books");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                System.out.println(
                        rs.getInt("book_id")+" | "+
                        rs.getString("book_title")+" | "+
                        rs.getString("book_author")+" | "+
                        rs.getInt("book_quantity")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
