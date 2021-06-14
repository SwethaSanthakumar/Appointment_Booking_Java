import java.io.*; 
import java.util.*; 
import java.util.Scanner;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
import java.text.ParseException;
import java.io.Serializable;
public class AppointmentDetails implements Serializable { 
public String customerName;
public long mobile;
public String serviceName;
public String email;
public int cost;
public String customerEmail;
public String timeSlot;
public String s3;
public int count=0;
public int duration =1;
public boolean res;
public String[] slot1 = new String[100];
public ArrayList<String> list = new ArrayList<String>();
private static final DateFormat TWELVE_TF = new SimpleDateFormat("hh a");
private static final DateFormat TWENTY_FOUR_TF = new SimpleDateFormat("HH");
public AppointmentDetails(){}

public AppointmentDetails(String customerName,long mobile,String email,String serviceName, int cost,String timeSlot) {    
this.customerName = customerName;    
this.mobile = mobile;
this.email=email;    
this.serviceName = serviceName;    
this.cost = cost;    
this.timeSlot = timeSlot;    
}  

@Override
public String toString() {
return new StringBuffer("").append(this.customerName)
.append(",").append(this.mobile).append(",").append(this.email).append(",").append(this.serviceName)
.append(",").append(this.cost)
.append(",").append(this.timeSlot).toString();
}


public void selectCustomerFromList() throws IOException{
HashMap<String, Long> customerMap  = new HashMap<String, Long>(); 
String customerFilePath = "C:/Users/Admin/Desktop/Intern/Java/AB/customerdata.txt";
String line;
int i=1;
BufferedReader reader = new BufferedReader(new FileReader(customerFilePath));
while ((line = reader.readLine()) != null)
{
String[] parts = line.split(",", 3);
if (parts.length >= 3)
{
String key = parts[0];
long value=Long.parseLong(parts[1]);
String email=parts[2]; 
list.add(email);
customerMap.put(key, value);
} else {
System.out.println("ignoring line: " + line);
}
}
System.out.println("SELECT CUSTOMER :");
for (String key : customerMap.keySet())
{
System.out.println(+i+"." +key + " : " +customerMap.get(key));
i++;
}

Set<Map.Entry<String, Long>> mapSet = customerMap.entrySet();
Scanner sc = new Scanner(System.in);
System.out.println("Please select a customer");
int index = sc.nextInt();
Map.Entry<String, Long> element1 = (new ArrayList<Map.Entry<String, Long>>(mapSet)).get(index-1);
customerName = element1.getKey();
mobile = element1.getValue();
customerEmail=list.get(index-1);
} 
public void selectCustomer() throws IOException{
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/customerdata.txt";
ValidateCustomer v=new ValidateCustomer();
v.validateCustomerDetails();

customerName = v.name1;
mobile=v.num;
res=v.result;
String line;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
String[] parts = line.split(",", 3);
if (parts.length >= 3)
{
String name = parts[0];
String mobile1 = parts[1];
String email= parts[2];
long m=Long.parseLong(mobile1); 
//System.out.println(customerName);
if (name.equals(customerName) && m==mobile){
customerEmail =email;
}
} 
}
}
public void selectService() throws IOException{
HashMap<String, Integer> map  = new HashMap<String, Integer>(); 
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/servicedata.txt";
String line;
int i=1;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
String[] parts = line.split(",", 2);
if (parts.length >= 2)
{
String key = parts[0];
int value=Integer.parseInt(parts[1]); 
map.put(key, value);
} else {
System.out.println("ignoring line: " + line);
}
}
System.out.println("SELECT SERVICE:");
for (String key : map.keySet())
{
System.out.println(+i+"." +key + " : " + map.get(key));
i++;
}

Set<Map.Entry<String, Integer>> mapSet = map.entrySet();
Scanner sc = new Scanner(System.in);
System.out.println("Please select a service");
int index = sc.nextInt();
Map.Entry<String, Integer> element = (new ArrayList<Map.Entry<String, Integer>>(mapSet)).get(index-1);
serviceName=element.getKey();
cost = element.getValue();
}
public void selectTimeSlot() throws IOException {
ArrayList<String> arr = new ArrayList<String>(); 
Calendar calendar = Calendar.getInstance();
DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss"); 
String s = dateFormat.format(calendar.getTime());    
DateFormat dateFormat1 = new SimpleDateFormat("HH aa"); 
calendar.add(Calendar.HOUR_OF_DAY, +1);
String s1 = dateFormat1.format(calendar.getTime()); 
String startDate = s;
String stopDate = "23:00:00";
SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");  
Date d1 = null;
Date d2 = null;
try {
d1 = format.parse(startDate);
d2 = format.parse(stopDate);
} 
catch (ParseException e) {
e.printStackTrace();
}    
long diff 
= d2.getTime() - d1.getTime();       
long diffHours = diff / (60 * 60 * 1000);                       
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
String line;

String[] parts = new String[100];

int x=0;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
String data = df.format(new Date());
while ( x < slot1.length && (line = reader.readLine()) != null)
{
parts = line.split(",", 7);
if ((parts.length >= 7) && parts[0].equals(data))
{
slot1[x]=parts[6];
count++;
arr.add(slot1[x]);
} 
} 
Scanner sc = new Scanner(System.in);
System.out.println("Enter the duration");
duration = sc.nextInt();
String s2;
DateFormat dateFormat2 = new SimpleDateFormat("hh a"); 
s1 = dateFormat2.format(calendar.getTime());
List<String> list=new ArrayList<String>();
for(int j=0; j<((diffHours+1)/duration); j++){
calendar.add(Calendar.HOUR_OF_DAY, +duration);
s2 = dateFormat2.format(calendar.getTime()); 
list.add(s1+"-"+s2);
s1=s2;
}
System.out.println("SELECT TIME SLOT:");
list.removeAll(arr);
boolean ans = list.isEmpty(); 
if (ans == true) {
System.out.println("No slots available"); 
return;
}
else{
for (int i = 0; i < list.size(); i++)   
{  
System.out.println((i+1)+"."+list.get(i));  
} 
}
int choice=sc.nextInt();
String element = list.get(choice-1); 
timeSlot= element; 
System.out.println("Appointment Booked Successfully");
} 

void displayUpcomingAppointments() throws IOException{
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
String line;
String cName;
String cMail;
long value; 
String sName;
int price;
String slot;
String[] parts = new String[100];
String[] slots = new  String[100];
String slot1,start,end;
String a;
String newstart;
String date;
int x=0;
Calendar calendar = Calendar.getInstance();   
DateFormat dateFormat1 = new SimpleDateFormat("HH aa"); 
String s1 = dateFormat1.format(calendar.getTime());
BufferedReader reader = new BufferedReader(new FileReader(filePath));
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
String data = df.format(new Date());
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

System.out.printf("%10s %15s %15s %25s %25s %10s %15s", "DATE", "CUSTOMER NAME", "MOBILE", "EMAIL-ID","SERVICE NAME", "COST", "TIME");
System.out.println();
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

while ((line = reader.readLine()) != null)
{
parts = line.split(",", 7);
if ((parts.length >= 7))
{
date=parts[0];
slot1=parts[6];
cName = parts[1];
cMail = parts[3];
value=Long.parseLong(parts[2]); 
sName = parts[4];
price=Integer.parseInt(parts[5]);
slots = slot1.split("-", 2);
if((slots.length >= 2))
{
start= slots[0];
end= slots[1];
try {
newstart = convertTo24HoursFormat(start);
int i=Integer.parseInt(newstart);  
String currentTime = new SimpleDateFormat("HH").format(new Date());
int j=Integer.parseInt(currentTime);  


if((i > j) && date.equals(data))
{
System.out.format("%10s %15s %15d %25s %25s %10d %15s",date,cName,value,cMail,sName,price,slot1);
System.out.println();
}
//System.out.println("-----------------------------------------------------------------------------");

} 
catch (ParseException ex) {
ex.printStackTrace();
}


}
} 
} 
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

}
void displayPreviousAppointments() throws IOException{
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
String line;
String cName;
String cMail;
long value; 
String sName;
int price;
String slot;
String[] parts = new String[100];
String[] slots = new  String[100];
String slot1,start,end;
String a;
String newstart;
String date;
int x=0;
Calendar calendar = Calendar.getInstance();   
DateFormat dateFormat1 = new SimpleDateFormat("HH aa"); 
String s1 = dateFormat1.format(calendar.getTime());
BufferedReader reader = new BufferedReader(new FileReader(filePath));
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
String data = df.format(new Date());
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

System.out.printf("%10s %15s %15s %25s %25s %10s %15s", "DATE", "CUSTOMER NAME", "MOBILE", "EMAIL-ID", "SERVICE NAME", "COST", "TIME");
System.out.println();
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

while ((line = reader.readLine()) != null)
{
parts = line.split(",", 7);
if ((parts.length >= 7))
{
date=parts[0];
slot1=parts[6];
cName = parts[1];
value=Long.parseLong(parts[2]); 
cMail=parts[3];
sName = parts[4];
price=Integer.parseInt(parts[5]);
slots = slot1.split("-", 2);
if((slots.length >= 2))
{
start= slots[0];
end= slots[1];
try {
newstart = convertTo24HoursFormat(start);
int i=Integer.parseInt(newstart);  
String currentTime = new SimpleDateFormat("HH").format(new Date());
int j=Integer.parseInt(currentTime);  
if((i < j) && date.equals(data))
{

System.out.format("%10s %15s %15d %25s %25s %10d %15s",date,cName,value,cMail,sName,price,slot1);
System.out.println();
}		
} 
catch (ParseException ex) {
ex.printStackTrace();
}		
}
}
} 
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

}
public static String convertTo24HoursFormat(String twelveHourTime)
throws ParseException {
return TWENTY_FOUR_TF.format(
TWELVE_TF.parse(twelveHourTime));
}
void displayAllAppointments() throws IOException
{
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
String date;
String line;
String cName;
String cMail;
long value; 
String sName;
int price;
String slot;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

System.out.printf("%10s %15s %15s %25s %25s %10s %15s", "DATE", "CUSTOMER NAME", "MOBILE", "EMAIL-ID", "SERVICE NAME", "COST", "TIME");
System.out.println();
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

while ((line = reader.readLine()) != null)
{
String[] parts = line.split(",", 7);
if (parts.length >= 7)
{
date =parts[0];
cName = parts[1];
value=Long.parseLong(parts[2]); 
sName = parts[4];
cMail =parts[3];
price=Integer.parseInt(parts[5]);
slot=parts[6];
System.out.format("%10s %15s %15d %25s %25s %10d %15s",date,cName,value,cMail,sName,price,slot);
System.out.println();

} 
}
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

}
void displayAppointmentsByDate() throws IOException
{
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
String date;
String line;
long value; 
String cName;
String sName;
String cMail;
int price;
String slot;
Scanner sc=new Scanner(System.in);
System.out.println("Please enter the date(dd/MM/yyyy) to view appointments");
String searchDate = sc.nextLine();
BufferedReader reader = new BufferedReader(new FileReader(filePath));
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
System.out.printf("%10s %15s %15s %25s %25s %10s %15s", "DATE", "CUSTOMER NAME", "MOBILE", "EMAIL-ID", "SERVICE NAME", "COST", "TIME");
System.out.println();
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
while ((line = reader.readLine()) != null)
{
String[] parts = line.split(",", 7);
if (parts.length >= 7 && parts[0].equals(searchDate))
{
date =parts[0];
cName = parts[1];
value=Long.parseLong(parts[2]); 
cMail=parts[3];
sName = parts[4];
price=Integer.parseInt(parts[5]);
slot=parts[6];
System.out.format("%10s %15s %15d %25s %25s %10d %15s",date,cName,value,cMail,sName,price,slot);
System.out.println();
} 
}
System.out.println("-------------------------------------------------------------------------------------------------------------------------------");


}
/*public static void main(String args[]) throws IOException{
Map<String,AppointmentDetails> map=new HashMap<String,AppointmentDetails>();    
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
String data = df.format(new Date());
AppointmentDetails a1=new AppointmentDetails(); 
a1.selectCustomer();
a1.selectService();
//a1.setDuration();
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
}
a1.displayAllAppointments();
a1.displayAppointmentsByDate();
a1.displayUpcomingAppointments();
a1.displayPreviousAppointments();*/
/*a1.displayAllAppointments();
a1.displayAppointmentsByDate();
AppointmentDetails a1=new AppointmentDetails(); 
a1.selectCustomer();*/
/*System.out.println("UPCOMING APPOINTMENTS");
a1.displayUpcomingAppointments();
System.out.println(" APPOINTMENTS");
a1.displayPreviousAppointments();*/
}
