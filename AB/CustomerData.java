import java.io.*; 
import java.util.*; 
import java.util.Scanner;
public class CustomerData{
HashMap<String, Long> customermap = new HashMap<String, Long>();
ArrayList<String> arr = new ArrayList<String>();
public String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/customerdata.txt"; 
public String customerName;
public long customerMobileNo;
public String customerEmail;
public String name;
public long checknum;
public String checkemail;
public String mobile;
public String email;
public long m;
public String[] parts =new String[100];
public String[] namearr = new String[100];
public CustomerData(){}
public CustomerData(long customerMobileNo,String customerEmail) {      
this.customerMobileNo = customerMobileNo;    
this.customerEmail = customerEmail;    }
@Override
public String toString() {
return new StringBuffer("").append(this.customerMobileNo).append(",").append(this.customerEmail)
.toString();
} 
void createCustomer() throws IOException{ 
Scanner sc = new Scanner(System.in);
System.out.println("------------------------------------------");
System.out.println("           CREATING NEW CUSTOMER          ");
System.out.println("------------------------------------------");
System.out.println("Enter the Customer name");
customerName = sc.nextLine();
System.out.println("Enter the Customer's Email ID");
checkemail = sc.nextLine();
System.out.println("Enter the Customer's mobile number");
checknum = sc.nextLong();

}
void displayCustomerData() throws IOException{
String line;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
System.out.println("------------------------------------------------------------");
System.out.printf("%10s %20s %25s","CUSTOMER NAME", "MOBILE NUMBER", "EMAIL-ID");
System.out.println();
System.out.println("------------------------------------------------------------");
while ((line = reader.readLine()) != null)
{
String[] parts = line.split(",", 3);
if (parts.length >= 3)
{
String name = parts[0];
String mobile = parts[1];
String email= parts[2];
long m=Long.parseLong(mobile);  
System.out.format("%10s %20d %25s",name,m,email);
System.out.println();
} 
}
System.out.println("------------------------------------------------------------");
}
void updateCustomerData()throws IOException{
Map<String,Cust> map=new HashMap<String,Cust>(); 
Map<String,Cust> map1=new HashMap<String,Cust>();       			 	
Scanner sc = new Scanner(System.in);
System.out.println("---------------------------------------------");
System.out.println("            UPDATE EXISTING CUSTOMER         ");
System.out.println("---------------------------------------------");
String line;
int x=0;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
while (x < namearr.length && (line = reader.readLine()) != null)
{
parts = line.split(",", 3);
if (parts.length >= 3)
{
namearr[x] = parts[0];
arr.add(namearr[x]);
} 
}
System.out.println("Enter the Customer's name");
String name1 = sc.nextLine();
if(arr.contains(name1)){
System.out.println("1.Update Customer Mobile Number");
System.out.println("2.Update Customer Email ID");
System.out.println("Please enter your choice:");
int customerChoice=sc.nextInt();
switch(customerChoice){
case 1:
System.out.println("Enter the Customer's new mobile number");
long num = sc.nextLong();
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 3);
if (parts.length >= 3)
{
name = parts[0];
mobile = parts[1];
email= parts[2];
m=Long.parseLong(mobile);
if(name1.equals(name)){
m=num;
Cust a2=new Cust(m,email);  
System.out.println(name+ "," +m+ "," +email);
map.put(name,a2);}
else{
Cust a2=new Cust(m,email);  
System.out.println(name+ "," +m+ "," +email);
map.put(name,a2);}
} 
}
PrintWriter pw = new PrintWriter(filePath);
pw.print("");
pw.close();
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Cust> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
break;
case 2:
System.out.println("Enter the Customer's new Email ID");
Scanner sc1=new Scanner(System.in);
String newEmail = sc1.nextLine();
System.out.println(newEmail);
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 3);
if (parts.length >= 3)
{
name = parts[0];
mobile = parts[1];
email= parts[2];
m=Long.parseLong(mobile);
if(name1.equals(name)){
email=newEmail;
System.out.println(name+ "," +m+ "," +email);
Cust a3=new Cust(m,email);  
map1.put(name,a3);}else{System.out.println(name+ "," +m+ "," +email);
Cust a4=new Cust(m,email);  
map1.put(name,a4);}
} 
}
PrintWriter pw2 = new PrintWriter(filePath);
pw2.print("");
pw2.close();
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Cust> entry : map1.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
break;
}}
else{
System.out.println("Customer Does not exist");
}
}
/*public static void main(String args[]) throws IOException
{   Map<String,Cust> map=new HashMap<String,Cust>();    
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/customerdata.txt";
CustomerData a1=new CustomerData(); 	
a1.createCustomer();
String str = Long.toString(a1.checknum);
ValidateMobile v = new ValidateMobile();
ValidateEmail v1=new ValidateEmail();
if(v.isValid(str) && v1.isValid(a1.checkemail)){
long b=Long.parseLong(str);  
String a= a1.customerName;
String c=a1.checkemail;
Cust a2=new Cust(b,c);         
map.put(a,a2);    
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Cust> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}}else{
System.out.println("Invalid Mobile or Email ID");

}
CustomerData a1=new CustomerData();
a1.displayCustomerData();*/
/*
CustomerData a1=new CustomerData(); 	
a1.displayCustomerData();
a1.updateCustomerData();*/
}