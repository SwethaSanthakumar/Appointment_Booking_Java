import java.io.*; 
import java.util.*;
import java.util.Scanner;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class MenuOption {   
public String staffNameLogged; 
public static void main(String [] args) throws IOException{
Scanner sc = new Scanner(System.in);
boolean done4=false;
do{
System.out.println("--------------------------");
System.out.println("        WELCOME           ");
System.out.println("--------------------------");
System.out.println("1.Customer");
System.out.println("2.Staff");
System.out.println("3.Exit");
System.out.println("Please enter your choice:");
int choice=sc.nextInt();
switch(choice)
{
case 1:
Map<String,AppointmentDetails> map=new HashMap<String,AppointmentDetails>();    
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
String data = df.format(new Date());
AppointmentDetails a1=new AppointmentDetails(); 
a1.selectCustomer();
	if(a1.res==true){
System.out.println("-----------------------------------");
System.out.println("          BOOK APPOINTMENT          ");
System.out.println("------------------------------------");
a1.selectService();
a1.selectTimeSlot();	
String a= a1.customerName;
long b= a1.mobile;
String c=a1.serviceName;
int d=a1.cost;
String e=a1.timeSlot;
String f = a1.customerEmail;
AppointmentDetails a2=new AppointmentDetails(a,b,f,c,d,e);         
map.put(data,a2);    
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, AppointmentDetails> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
	}}

break;
case 2:
ValidateStaff admin = new ValidateStaff();
admin.validateStaffDetails();
boolean done3=false;
if(admin.result==true && admin.staffAccessRole.equals("Admin Access")){
do{	
System.out.println("--------------------------------");
System.out.println("         WELCOME ADMIN          ");
System.out.println("--------------------------------");
System.out.println("1.Customers");
System.out.println("2.Services");
System.out.println("3.Staff");
System.out.println("4.Appointments");
System.out.println("5.Exit");
System.out.println("Please enter your choice:");
int menuChoice=sc.nextInt();
switch (menuChoice)
{
case 1:
boolean done2 = false;
do{
	
System.out.println("--------------------------");
System.out.println("        CUSTOMER          ");
System.out.println("--------------------------");
System.out.println("1.Create New Customer");
System.out.println("2.Update Customer");
System.out.println("3.View Customer");
System.out.println("4.Exit");
System.out.println("Please enter your choice:");
int customerMenuChoice=sc.nextInt();
switch(customerMenuChoice){
case 1:
try{
Map<String,Cust> cusmap=new HashMap<String,Cust>();    
String filePath1 = "C:/Users/Admin/Desktop/Intern/Java/AB/customerdata.txt";
CustomerData cusa1=new CustomerData(); 	
cusa1.createCustomer();
String str = Long.toString(cusa1.checknum);
ValidateMobile v = new ValidateMobile();
ValidateEmail v1=new ValidateEmail();
if(v.isValid(str) && v1.isValid(cusa1.checkemail)){
long cusb=Long.parseLong(str);  
String cusa= cusa1.customerName;
String cusc=cusa1.checkemail;
Cust cusa2=new Cust(cusb,cusc);         
cusmap.put(cusa,cusa2);    
try { 
FileWriter fw=new FileWriter(filePath1,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Cust> entry : cusmap.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}}else{
System.out.println("Invalid Mobile or Email ID");

}}
catch(IOException e2)
{
System.err.println(e2);
}
break;
case 2:
try{
CustomerData c1 = new CustomerData();
c1.updateCustomerData();}
catch(IOException e3)
{
System.err.println(e3);
}
break;
case 3:
try{
CustomerData c2 = new CustomerData();
c2.displayCustomerData();}
catch(IOException e4)
{
System.err.println(e4);
}
break;
case 4:
done2 = true;
break;
default: 
System.out.println("Invalid choice");
break;
} 
} while(!done2);
break;
case 2:
boolean done1 =false;
do{		
System.out.println("--------------------------");
System.out.println("        SERVICES          ");
System.out.println("--------------------------"); 
System.out.println("1.Create New Service");
System.out.println("2.Update Service");
System.out.println("3.View Services");
System.out.println("4.Exit");
System.out.println("Please enter your choice:");
int serviceMenuChoice=sc.nextInt();
switch(serviceMenuChoice){
case 1:
try{
ServiceData s = new ServiceData();
s.createService();}
catch(IOException e5)
{
System.err.println(e5);
}
break;
case 2:
try{
ServiceData s = new ServiceData();
s.updateServiceData();}
catch(IOException e6)
{
System.err.println(e6);
}
break;
case 3:
try{
ServiceData s = new ServiceData();
s.displayServiceData();}
catch(IOException e7)
{
System.err.println(e7);
}
break;
case 4:
done1 =true;
break;
default: 
System.out.println("Invalid choice");
break;
} }while(!done1);
break;
case 3:
boolean done22 = false;
do{
System.out.println("--------------------------");
System.out.println("          STAFF           ");
System.out.println("--------------------------");
System.out.println("1.Create New Staff");
System.out.println("2.Update Staff Details");
System.out.println("3.View Staff");
System.out.println("4.Exit");
System.out.println("Please enter your choice:");
int staffMenuChoice=sc.nextInt();
switch(staffMenuChoice){
case 1:
try{
Map<String,Staff> staffmap=new HashMap<String,Staff>();    
String stafffilePath = "C:/Users/Admin/Desktop/Intern/Java/AB/staffdata.txt";
StaffData sda1=new StaffData(); 	
sda1.createStaff();
String str = Long.toString(sda1.checknum);
ValidateMobile v = new ValidateMobile();
ValidateEmail v1=new ValidateEmail();
if(v.isValid(str) && v1.isValid(sda1.checkemail)){
long c=Long.parseLong(str);  
String a= sda1.staffName;
String b=sda1.staffPassword;
String d=sda1.checkemail;
String e=sda1.staffAccess;
Staff a2=new Staff(b,c,d,e);         
staffmap.put(a,a2);    
try { 
FileWriter fw=new FileWriter(stafffilePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, Staff> entry : staffmap.entrySet()) {  
pw1.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e1)
{
System.err.println(e1);
}}else{
System.out.println("Invalid Mobile or Email ID");
}}catch(IOException e1)
{
System.err.println(e1);
}
System.out.println("Staff Created Successfully");
break;
case 2:
try{
StaffData sdc1 = new StaffData();
sdc1.updateAdminStaffData();}
catch(IOException e3)
{
System.err.println(e3);
}
break;
case 3:
try{
StaffData sdc2 = new StaffData();
sdc2.displayStaffData();}
catch(IOException e4)
{
System.err.println(e4);
}
break;
case 4:
done22 = true;
break;
default:
System.out.println("Invalid choice");
break;
}
}while(!done22);
break;
case 4:
boolean done = false;
do{		 
System.out.println("-------------------------------------");
System.out.println("         VIEW APPOINTMENTS           ");
System.out.println("-------------------------------------");
System.out.println("1.Schedule Appointments");
System.out.println("2.View All Appointments");
System.out.println("3.View Appointments by Date");
System.out.println("4.View Upcoming Appointments");
System.out.println("5.View Previous Appointments");
System.out.println("6.Exit");
System.out.println("Please enter your choice:");
int appointmentChoice=sc.nextInt();
switch(appointmentChoice){
case 1: 
Map<String,AppointmentDetails> map112=new HashMap<String,AppointmentDetails>();    
String filePath112 = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
DateFormat df112= new SimpleDateFormat("dd/MM/yyyy");
String data112 = df112.format(new Date());
AppointmentDetails a112=new AppointmentDetails(); 
a112.selectCustomerFromList();
System.out.println("-----------------------------------");
System.out.println("          BOOK APPOINTMENT          ");
System.out.println("------------------------------------");
a112.selectService();
a112.selectTimeSlot();	
String a= a112.customerName;
long b= a112.mobile;
String c=a112.serviceName;
int d=a112.cost;
String e=a112.timeSlot;
String f = a112.customerEmail;
AppointmentDetails a222=new AppointmentDetails(a,b,f,c,d,e);         
map112.put(data112,a222);    
try { 
FileWriter fw=new FileWriter(filePath112,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, AppointmentDetails> entry : map112.entrySet()) {  
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
AppointmentDetails a3=new AppointmentDetails(); 
System.out.println("ALL APPOINTMENTS");
a3.displayAllAppointments();
break;
case 3:
AppointmentDetails a4=new AppointmentDetails(); 
System.out.println("APPOINTMENTS BY DATE");
a4.displayAppointmentsByDate();
break;
case 4:
AppointmentDetails a5=new AppointmentDetails(); 
System.out.println("UPCOMING APPOINTMENTS");
a5.displayUpcomingAppointments();
break;
case 5:
AppointmentDetails a6=new AppointmentDetails(); 
System.out.println("PREVIOUS APPOINTMENTS");
a6.displayPreviousAppointments();
break;
case 6:
done =true;
break;
default: 
System.out.println("Invalid choice");
break;
}}while(!done);
break;
case 5:
done3 =true;
break;
default:
break;
}
}while(!done3);
}else if(admin.result==true && admin.staffAccessRole.equals("Staff Access")){
	do{	
System.out.println("--------------------------------");
System.out.println("         WELCOME ADMIN          ");
System.out.println("--------------------------------");
System.out.println("1.Customers");
System.out.println("2.Services");
System.out.println("3.Staff");
System.out.println("4.Appointments");
System.out.println("5.Exit");
System.out.println("Please enter your choice:");
int menuChoice=sc.nextInt();
switch (menuChoice)
{
case 1:
boolean done2 = false;
do{
	
System.out.println("--------------------------");
System.out.println("        CUSTOMER          ");
System.out.println("--------------------------");
System.out.println("1.View Customer");
System.out.println("2.Exit");
System.out.println("Please enter your choice:");
int customerMenuChoice=sc.nextInt();
switch(customerMenuChoice){
case 1:
try{
CustomerData c2 = new CustomerData();
c2.displayCustomerData();}
catch(IOException e4)
{
System.err.println(e4);
}
break;
case 2:
done2 = true;
break;
default: 
System.out.println("Invalid choice");
break;
} 
} while(!done2);
break;
case 2:
boolean done1 =false;
do{		
System.out.println("--------------------------");
System.out.println("        SERVICES          ");
System.out.println("--------------------------"); 
System.out.println("1.View Services");
System.out.println("2.Exit");
System.out.println("Please enter your choice:");
int serviceMenuChoice=sc.nextInt();
switch(serviceMenuChoice){
case 1:
try{
ServiceData s = new ServiceData();
s.displayServiceData();}
catch(IOException e7)
{
System.err.println(e7);
}
break;
case 2:
done1 =true;
break;
default: 
System.out.println("Invalid choice");
break;
} }while(!done1);
break;
case 3:
boolean done22 = false;
do{
System.out.println("--------------------------");
System.out.println("          STAFF           ");
System.out.println("--------------------------");
System.out.println("1.Update Staff Details");
System.out.println("2.Exit");
System.out.println("Please enter your choice:");
int staffMenuChoice=sc.nextInt();
switch(staffMenuChoice){
case 1:
try{
StaffData sdc1 = new StaffData();
sdc1.updateStaffAccessData();}
catch(IOException e3)
{
System.err.println(e3);
}
break;
case 2:
done22 = true;
break;
default:
System.out.println("Invalid choice");
break;
}
}while(!done22);
break;
case 4:
boolean done = false;
do{		 
System.out.println("-------------------------------------");
System.out.println("         VIEW APPOINTMENTS           ");
System.out.println("-------------------------------------");
System.out.println("1.Schedule Appointments");
System.out.println("2.View All Appointments");
System.out.println("3.View Appointments by Date");
System.out.println("4.View Upcoming Appointments");
System.out.println("5.View Previous Appointments");
System.out.println("6.Exit");
System.out.println("Please enter your choice:");
int appointmentChoice=sc.nextInt();
switch(appointmentChoice){
case 1:
Map<String,AppointmentDetails> map11=new HashMap<String,AppointmentDetails>();    
String filePath11 = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
DateFormat df11= new SimpleDateFormat("dd/MM/yyyy");
String data11 = df11.format(new Date());
AppointmentDetails a11=new AppointmentDetails(); 
System.out.println("-----------------------------------");
System.out.println("          BOOK APPOINTMENT          ");
System.out.println("------------------------------------");
a11.selectCustomerFromList();
a11.selectService();
a11.selectTimeSlot();	
String a= a11.customerName;
long b= a11.mobile;
String c=a11.serviceName;
int d=a11.cost;
String e=a11.timeSlot;
String f = a11.customerEmail;
AppointmentDetails a21=new AppointmentDetails(a,b,f,c,d,e);         
map11.put(data11,a21);    
try { 
FileWriter fw=new FileWriter(filePath11,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, AppointmentDetails> entry : map11.entrySet()) {  
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
AppointmentDetails a3=new AppointmentDetails(); 
System.out.println("ALL APPOINTMENTS");
a3.displayAllAppointments();
break;
case 3:
AppointmentDetails a4=new AppointmentDetails(); 
System.out.println("APPOINTMENTS BY DATE");
a4.displayAppointmentsByDate();
break;
case 4:
AppointmentDetails a5=new AppointmentDetails(); 
System.out.println("UPCOMING APPOINTMENTS");
a5.displayUpcomingAppointments();
break;
case 5:
AppointmentDetails a6=new AppointmentDetails(); 
System.out.println("PREVIOUS APPOINTMENTS");
a6.displayPreviousAppointments();
break;
case 6:
done =true;
break;
default: 
System.out.println("Invalid choice");
break;
}}while(!done);
break;
case 5:
done3 =true;
break;
default:
break;
}
}while(!done3);
}
break;
case 3:
done4 =true;
break;
default:
System.out.println("Invalid Choice");
break;
}
}while(!done4);
}
}