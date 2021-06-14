import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.*;  
import java.io.*; 
public class Appointment extends AppointmentDetails{    
String customerName;
long mobile;
String serviceName;
int cost;
String timeSlot;  
public Appointment(){
	
}
public Appointment(String customerName,long mobile,String serviceName,int cost,String timeSlot) {    
    this.customerName = customerName;    
    this.mobile = mobile;    
    this.serviceName = serviceName;    
    this.cost = cost;    
    this.timeSlot = timeSlot;    
}    
public String getCustomerName() {
    return customerName;
  }
public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
public long getMobile() {
    return mobile;
  }
public void setMobile(long mobile) {
    this.mobile = mobile;
  }
 public String getServiceName() {
    return serviceName;
  }
public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }
  public int getCost() {
    return cost;
  }
public void setCost(int cost) {
    this.cost = cost;
  }
  public String getTimeSlot() {
    return timeSlot;
  }
public void setTimeSlot(String timeSlot) {
    this.timeSlot = timeSlot;
  }
public static void main(String[] args) throws IOException{       
   Map<String,Appointment> map=new HashMap<String,Appointment>();    
   DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String data = df.format(new Date());
    System.out.println(data);
    Appointment a1=new Appointment();
a1.selectCustomer();
	a1.selectService();
	a1.selectTimeSlot();
	System.out.println(a1.customerName);
	System.out.println(a1.mobile);
	System.out.println(a1.serviceName);
	System.out.println(a1.cost);
	System.out.println(a1.timeSlot);   
   a1.setCustomerName(a1.customerName);
	a1.setMobile(a1.mobile);
	a1.setServiceName(a1.serviceName);
	a1.setCost(a1.cost);
	a1.setTimeSlot(a1.timeSlot);
    map.put(data,a1);  
 
    for(Map.Entry<String, Appointment> entry:map.entrySet()){    
        String key=entry.getKey();  
        Appointment a=entry.getValue();  
        System.out.println(key+" Details:");  
        System.out.println(a.customerName+" "+a.mobile+" "+a.serviceName+" "+a.cost+" "+a.timeSlot);   
    }    
}    
}    