package scr;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        while(true){

            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 Add User");
            System.out.println("4 Issue Book");
            System.out.println("5 Return Book");
            System.out.println("6 Exit");

            int ch=sc.nextInt();

            switch(ch){

                case 1:
                    System.out.print("Book ID: ");
                    int bid=sc.nextInt(); sc.nextLine();

                    System.out.print("Title: ");
                    String t=sc.nextLine();

                    System.out.print("Author: ");
                    String a=sc.nextLine();

                    System.out.print("Quantity: ");
                    int q=sc.nextInt();

                    BookDAO.addBook(bid,t,a,q);
                    break;

                case 2:
                    BookDAO.viewBooks();
                    break;

                case 3:
                    System.out.print("User ID: ");
                    int uid=sc.nextInt(); sc.nextLine();

                    System.out.print("Name: ");
                    String n=sc.nextLine();

                    System.out.print("Email: ");
                    String e=sc.nextLine();

                    UserDAO.addUser(uid,n,e);
                    break;

                case 4:
                    System.out.print("Issue ID: ");
                    int iid=sc.nextInt();

                    System.out.print("Book ID: ");
                    int b=sc.nextInt();

                    System.out.print("User ID: ");
                    int u=sc.nextInt(); sc.nextLine();

                    System.out.print("Issue Date (YYYY-MM-DD HH:MM:SS): ");
                    String idate=sc.nextLine();

                    System.out.print("Return Date (YYYY-MM-DD HH:MM:SS): ");
                    String rdate=sc.nextLine();

                    IssueDAO.issueBook(iid,b,u,idate,rdate);
                    break;

                case 5:
                    System.out.print("Issue ID: ");
                    int rid=sc.nextInt();

                    System.out.print("Book ID: ");
                    int rb=sc.nextInt();

                    IssueDAO.returnBook(rid,rb);
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}

