import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*; 
import java.util.*;
public class ObjectIOExample {
 
    private static final String filepath="C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
 
    public static void main(String args[]) throws IOException{
 
        ObjectIOExample objectIO = new ObjectIOExample();
        AppointmentDetails a1=new AppointmentDetails(); 
    a1.selectCustomer();
a1.selectService();
a1.selectTimeSlot();	
    String a= a1.customerName;
	long b= a1.mobile;
	String c=a1.serviceName;
	int d=a1.cost;
	String e=a1.timeSlot; 
    ArrayList<AppointmentDetails> e1 = new ArrayList<>();
		e1.add(new AppointmentDetails(a,b,c,d,e));
 
        try
        {
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(e1);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
    }
 
   
}
