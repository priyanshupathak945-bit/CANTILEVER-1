package scr;
import java.sql.*;

public class IssueDAO {

    public static void issueBook(int issue_id,int book_id,int user_id,String issue_date,String return_date){

        try{

            Connection con=DBConnection.getConnection();

            // 🔥 quantity check
            String check="SELECT book_quantity FROM books WHERE book_id=?";
            PreparedStatement cps=con.prepareStatement(check);
            cps.setInt(1,book_id);

            ResultSet rs=cps.executeQuery();

            if(rs.next() && rs.getInt("book_quantity")>0){

                String q="INSERT INTO issued_books(issue_id,book_id,user_id,issue_date,return_date) VALUES(?,?,?,?,?)";

                PreparedStatement ps=con.prepareStatement(q);

                ps.setInt(1,issue_id);
                ps.setInt(2,book_id);
                ps.setInt(3,user_id);
                ps.setString(4,issue_date);
                ps.setString(5,return_date);

                ps.executeUpdate();

                // quantity minus
                PreparedStatement ups=con.prepareStatement(
                        "UPDATE books SET book_quantity=book_quantity-1 WHERE book_id=?");

                ups.setInt(1,book_id);
                ups.executeUpdate();

                System.out.println("Book Issued ✅");

            }else{

                System.out.println("Book Out of Stock ❌");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void returnBook(int issue_id,int book_id){

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement ps=con.prepareStatement(
                    "DELETE FROM issued_books WHERE issue_id=?");

            ps.setInt(1,issue_id);
            ps.executeUpdate();

            // quantity plus
            PreparedStatement ups=con.prepareStatement(
                    "UPDATE books SET book_quantity=book_quantity+1 WHERE book_id=?");

            ups.setInt(1,book_id);
            ups.executeUpdate();

            System.out.println("Book Returned 🔁");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

