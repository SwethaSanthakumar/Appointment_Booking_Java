import java.util.Scanner;
import java.io.*; 
import java.util.*; 
public class ValidateCustomer
{
public String name1;
public long num;
public boolean result;
void validateCustomerDetails() throws IOException{

String customerFilePath = "C:/Users/Admin/Desktop/Intern/Java/AB/customerdata.txt";
ArrayList<Long> arr = new ArrayList<Long>(); 
ArrayList<String> arr1 = new ArrayList<String>(); 
String line;
int i=1;
int count=0;
String[] customerName = new String[100];
Long[] mobile = new Long[100];
Scanner sc=new Scanner(System.in);
System.out.println("Enter Username");
name1 = sc.nextLine();
System.out.println("Enter Password");
num = sc.nextLong();
int x=0;
BufferedReader reader = new BufferedReader(new FileReader(customerFilePath));

while ((x < customerName.length) && (line = reader.readLine()) != null)
{
String[] parts = line.split(",", 3);
if (parts.length >= 3)
{
customerName[x]=parts[0];
mobile[x]=Long.parseLong(parts[1]); 
arr.add(mobile[x]);
arr1.add(customerName[x]);
count++;
} 

}
if(arr.contains(num) && arr1.contains(name1))
{
	result=true;
System.out.println("Login Successful");

}
else{
System.out.println("Invalid Username and Password");
}
}
public static void main(String args[]) throws IOException{
ValidateCustomer v = new ValidateCustomer();
v.validateCustomerDetails();
}
}
