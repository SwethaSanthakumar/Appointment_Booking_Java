import java.util.Scanner;
import java.io.*; 
import java.util.*; 
public class ValidateStaff
{
public String name1;
public String password;
public String staffAccessRole;
public boolean result;
void validateStaffDetails() throws IOException{

String staffFilePath = "C:/Users/Admin/Desktop/Intern/Java/AB/staffdata.txt";
ArrayList<String> arr = new ArrayList<String>(); 
ArrayList<String> arr1 = new ArrayList<String>(); 
String line;
int i=1;
int count=0;
String[] staffName = new String[100];
String[] staffPassword = new String[100];
Scanner sc=new Scanner(System.in);
System.out.println("Enter Username");
name1 = sc.nextLine();
String loginFilePath = "C:/Users/Admin/Desktop/Intern/Java/AB/logindata.txt";
BufferedWriter writer = new BufferedWriter(new FileWriter(loginFilePath));
    writer.write(name1);
    writer.close();
System.out.println("Enter Password");
password = sc.nextLine();
int x=0;
BufferedReader reader = new BufferedReader(new FileReader(staffFilePath));



while ((x < staffName.length) && (line = reader.readLine()) != null)
{
String[] parts = line.split(",", 5);
if (parts.length >= 5)
{
	staffName[x]=parts[0];
staffPassword[x]=parts[1];
arr.add(staffName[x]);
arr1.add(staffPassword[x]);
count++;
String name = parts[0];
String pass = parts[1];
String access= parts[4];
if (name.equals(name1) && pass.equals(password)){
staffAccessRole =access;
}
} 
}

System.out.println(staffAccessRole);
if(arr.contains(name1) && arr1.contains(password))
{
	result=true;
System.out.println("Login Successful");

}
else{
System.out.println("Invalid Username and Password");
}
}
public static void main(String args[]) throws IOException{
ValidateStaff v = new ValidateStaff();
v.validateStaffDetails();
}
}
