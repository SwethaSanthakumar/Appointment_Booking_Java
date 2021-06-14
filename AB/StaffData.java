import java.io.*; 
import java.util.*; 
import java.util.Scanner;
public class StaffData{
HashMap<String, Long> customermap = new HashMap<String, Long>();
ArrayList<String> arr = new ArrayList<String>();
public String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/staffdata.txt"; 
public String staffName;
public String name1;
public String staffPassword;
public long staffMobileNo;
public String staffEmail;
public String staffAccess;
public String name;
public long checknum;
public String checkemail;
public String mobile;
public String email;
public String password;
public String access;
public String newpass;
public long m;
public String[] parts =new String[100];
public String[] namearr = new String[100];

public StaffData(){}

public StaffData(String staffPassword,long staffMobileNo,String staffEmail,String staffAccess) {      
this.staffPassword = staffPassword;    
this.staffMobileNo = staffMobileNo;
this.staffEmail=staffEmail;
this.staffAccess=staffAccess;    
}

@Override
public String toString() {
return new StringBuffer("").append(this.staffPassword).append(",").append(this.staffMobileNo).append(",").append(this.staffEmail).append(",").append(this.staffAccess)
.toString();
} 
void createStaff() throws IOException{ 
Scanner sc = new Scanner(System.in);
System.out.println("------------------------------------------");
System.out.println("               CREATING NEW STAFF         ");
System.out.println("------------------------------------------");
System.out.println("Enter the Staff name");
staffName = sc.nextLine();
System.out.println("Enter the Staff's password");
staffPassword = sc.nextLine();
System.out.println("Enter the Staff's Email ID");
checkemail = sc.nextLine();
System.out.println("Enter the Access state of Staff");
staffAccess = sc.nextLine();
System.out.println("Enter the Staff's mobile number");
checknum = sc.nextLong();
}
void displayStaffData() throws IOException{
String line;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
System.out.println("---------------------------------------------------------------------------------------------------");
System.out.printf("%10s %15s %15s %25s %15s","STAFF NAME", "PASSWORD", "MOBILE NUMBER", "EMAIL-ID", "ACCESS CONTROL");
System.out.println();
System.out.println("---------------------------------------------------------------------------------------------------");
while ((line = reader.readLine()) != null)
{
String[] parts = line.split(",", 5);
if (parts.length >= 5)
{
String name = parts[0];
String password = parts[1];
String mobile = parts[2];
String email = parts[3];
String accessControl = parts[4];
long m=Long.parseLong(mobile);  
System.out.format("%10s %15s %15d %25s %15s",name,password,m,email,accessControl);
System.out.println();
} 
}
System.out.println("---------------------------------------------------------------------------------------------------");
}
void updatePassword() throws IOException
{
	Map<String,Staff> map=new HashMap<String,Staff>(); 
Map<String,Staff> map1=new HashMap<String,Staff>();       			 	
Scanner sc = new Scanner(System.in);
String line;
int x=0;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
	reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
password=newpass;
Staff a2=new Staff(password,m,email,access);  
map.put(name,a2);}
else{
Staff a2=new Staff(password,m,email,access);    
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
for (Map.Entry<String, Staff> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
}
void updateAdminStaffData()throws IOException{
Map<String,Staff> map=new HashMap<String,Staff>(); 
Map<String,Staff> map1=new HashMap<String,Staff>();       			 	
Scanner sc = new Scanner(System.in);
String line;
int x=0;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
while (x < namearr.length && (line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
namearr[x] = parts[0];
arr.add(namearr[x]);
} 
}

boolean done1=false;
do{
System.out.println("---------------------------------------------");
System.out.println("              UPDATE STAFF DETAILS           ");
System.out.println("---------------------------------------------");
System.out.println("1.Update My Details");
System.out.println("2.Update Other Staff Details");
System.out.println("3.Exit");
int staffmenuChoice=sc.nextInt(); 
switch(staffmenuChoice){
case 1:
boolean done=false;
do{
  File file = new File("C:/Users/Admin/Desktop/Intern/Java/AB/logindata.txt"); 
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  String st; 
  while ((st = br.readLine()) != null) {
  name1 =st; }
 
if(arr.contains(name1)){
System.out.println("Staff Name : "+name1);
System.out.println("1.Update Password");
System.out.println("2.Update Mobile Number");
System.out.println("3.Update Email ID");
System.out.println("4.Update Access Control");
System.out.println("5.Exit");
System.out.println("Please enter your choice:");
int staffChoice=sc.nextInt(); 
switch(staffChoice){
case 1:
System.out.println("Enter the new password");
Scanner scc=new Scanner(System.in);
newpass = scc.nextLine();
updatePassword();

break;	
case 2:
System.out.println("Enter the new mobile number");
long num = sc.nextLong();
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
m=num;
Staff a2=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
map.put(name,a2);}
else{
Staff a2=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
map.put(name,a2);}
} 
}
PrintWriter pw5 = new PrintWriter(filePath);
pw5.print("");
pw5.close();
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Staff> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Mobile Number has been updated successfully");
break;
case 3:
System.out.println("Enter the new Email ID");
Scanner sc1=new Scanner(System.in);
String newEmail = sc1.nextLine();
System.out.println(newEmail);
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
email=newEmail;
Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access); 
map1.put(name,a4);}
else{Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
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
for (Map.Entry<String, Staff> entry : map1.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Email ID has been updated successfully");
break;
case 4:
System.out.println("Enter the new Access Role");
Scanner sc11=new Scanner(System.in);
String newAccess = sc11.nextLine();
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
access=newAccess;
Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access); 
map1.put(name,a4);}
else{Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
map1.put(name,a4);}
} 
}
PrintWriter pw22 = new PrintWriter(filePath);
pw22.print("");
pw22.close();
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Staff> entry : map1.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Access Control Role has been updated successfully");
break;
case 5:
done = true;
break;
default:
System.err.println("Invalid Choice");
break;
}}
else{
System.out.println("Customer Does not exist");
}}while(!done);
break;

case 2:

boolean done3=false;

	System.out.println("Enter the Staff Name");
	Scanner scn =new Scanner(System.in);
	name1=scn.nextLine();
	do{
if(arr.contains(name1)){
System.out.println("1.Update Password");
System.out.println("2.Update Mobile Number");
System.out.println("3.Update Email ID");
System.out.println("4.Update Access Control");
System.out.println("5.Exit");
System.out.println("Please enter your choice:");
int staffChoice=sc.nextInt(); 
switch(staffChoice){
case 1:
System.out.println("Enter the new password");
Scanner scc=new Scanner(System.in);
String newpass = scc.nextLine();

reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
password=newpass;
Staff a2=new Staff(password,m,email,access);  
map.put(name,a2);}
else{
Staff a2=new Staff(password,m,email,access);    
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
for (Map.Entry<String, Staff> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Password has been updated successfully");
break;	
case 2:
System.out.println("Enter the new mobile number");
long num = sc.nextLong();
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
m=num;
Staff a2=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
map.put(name,a2);}
else{
Staff a2=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
map.put(name,a2);}
} 
}
PrintWriter pw5 = new PrintWriter(filePath);
pw5.print("");
pw5.close();
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Staff> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Mobile Number has been updated successfully");
break;
case 3:
System.out.println("Enter the new Email ID");
Scanner sc1=new Scanner(System.in);
String newEmail = sc1.nextLine();
System.out.println(newEmail);
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
email=newEmail;
Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access); 
map1.put(name,a4);}
else{Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
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
for (Map.Entry<String, Staff> entry : map1.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Email ID has been updated successfully");
break;
case 4:
System.out.println("Enter the new Access Role");
Scanner sc11=new Scanner(System.in);
String newAccess = sc11.nextLine();
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
access=newAccess;
Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access); 
map1.put(name,a4);}
else{Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
map1.put(name,a4);}
} 
}
PrintWriter pw22 = new PrintWriter(filePath);
pw22.print("");
pw22.close();
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Staff> entry : map1.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Access Control Role has been updated successfully");
break;
case 5:
done3 = true;
break;
default:
System.err.println("Invalid Choice");
break;
}}
else{
System.out.println("Customer Does not exist");
}}while(!done3);

break;

case 3:
done1 = true;
break;

default:
System.err.println("Invalid Choice");
break;

}
}while(!done1);


}
void updateStaffAccessData()throws IOException{
Map<String,Staff> map=new HashMap<String,Staff>(); 
Map<String,Staff> map1=new HashMap<String,Staff>();       			 	
Scanner sc = new Scanner(System.in);
String line;
int x=0;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
while (x < namearr.length && (line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
namearr[x] = parts[0];
arr.add(namearr[x]);
} 
}

boolean done=false;
do{
  File file = new File("C:/Users/Admin/Desktop/Intern/Java/AB/logindata.txt"); 
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  String st; 
  while ((st = br.readLine()) != null) {
  name1 =st; } 
if(arr.contains(name1)){
System.out.println("---------------------------------------------");
System.out.println("             UPDATE STAFF DETAILS            ");
System.out.println("---------------------------------------------");
System.out.println("Staff Name : "+name1);
System.out.println("1.Update Password");
System.out.println("2.Update Mobile Number");
System.out.println("3.Update Email ID");
System.out.println("4.Exit");
System.out.println("Please enter your choice:");
int staffChoice=sc.nextInt(); 
switch(staffChoice){
case 1:
System.out.println("Enter the new password");
Scanner scc=new Scanner(System.in);
String newpass = scc.nextLine();

reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
password=newpass;
Staff a2=new Staff(password,m,email,access);  
map.put(name,a2);}
else{
Staff a2=new Staff(password,m,email,access);    
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
for (Map.Entry<String, Staff> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Password has been updated successfully");
break;	
case 2:
System.out.println("Enter the new mobile number");
long num = sc.nextLong();
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
m=num;
Staff a2=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
map.put(name,a2);}
else{
Staff a2=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
map.put(name,a2);}
} 
}
PrintWriter pw5 = new PrintWriter(filePath);
pw5.print("");
pw5.close();
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Staff> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Mobile Number has been updated successfully");
break;
case 3:
System.out.println("Enter the new Email ID");
Scanner sc1=new Scanner(System.in);
String newEmail = sc1.nextLine();
System.out.println(newEmail);
reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
parts = line.split(",", 5);
if (parts.length >= 5)
{
name = parts[0];
password=parts[1];
mobile = parts[2];
email= parts[3];
access=parts[4];
m=Long.parseLong(mobile);
if(name1.equals(name)){
email=newEmail;
Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access); 
map1.put(name,a4);}
else{Staff a4=new Staff(password,m,email,access);    
//System.out.println(name+ "," +password+ "," +m+ "," +email+ "," +access);
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
for (Map.Entry<String, Staff> entry : map1.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Email ID has been updated successfully");
break;

case 4:
done = true;
break;
default:
System.err.println("Invalid Choice");
break;
}}
else{
System.out.println("Customer Does not exist");
}}while(!done);
}
public static void main(String args[]) throws IOException
{   /*Map<String,Staff> map=new HashMap<String,Staff>();    
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/staffdata.txt";
StaffData a1=new StaffData(); 	
a1.createStaff();
String str = Long.toString(a1.checknum);
ValidateMobile v = new ValidateMobile();
ValidateEmail v1=new ValidateEmail();
if(v.isValid(str) && v1.isValid(a1.checkemail)){
long c=Long.parseLong(str);  
String a= a1.staffName;
String b=a1.staffPassword;
String d=a1.checkemail;
String e=a1.staffAccess;
Staff a2=new Staff(b,c,d,e);         
map.put(a,a2);    
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Staff> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}}else{
System.out.println("Invalid Mobile or Email ID");

}*/
StaffData a1=new StaffData(); 
a1.updateAdminStaffData();
//a1.displayStaffData();*/
/*
CustomerData a1=new CustomerData(); 	
a1.displayCustomerData();
*/
}
}