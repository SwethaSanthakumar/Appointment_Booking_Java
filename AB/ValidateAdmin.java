import java.util.Scanner;
import java.io.*; 
import java.util.*; 
public class ValidateAdmin{
public boolean loginres;
void validateAdminDetails() throws IOException{
String user="admin";
String pass="admin@123";
Scanner sc=new Scanner(System.in);
System.out.println("Enter Username");
String userName = sc.nextLine();
System.out.println("Enter Password");
String password = sc.nextLine();
if(userName.equals(user) && password.equals(pass))
{
System.out.println("Login Successful");
loginres=true;
}
else{
System.out.println("Invalid Username and Password");
}
}
/*public static void main(String args[]) throws IOException{
ValidateAdmin v = new ValidateAdmin();
v.validateAdminDetails();
}*/
}
