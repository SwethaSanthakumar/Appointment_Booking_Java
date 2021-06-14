import java.io.*; 
import java.util.*;
import java.util.Scanner;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class Menu {    
    public static void main(String [] args) throws IOException{
        Scanner sc = new Scanner(System.in);
		System.out.println("------------WELCOME----------");
		System.out.println("1.Customer");
        System.out.println("2.Admin");
        System.out.println("Please enter your choice:");
        int choice=sc.nextInt();
		switch(choice){
			
        System.out.println("1.Customers");
        System.out.println("2.Services");
        System.out.println("3.Appointments");
        System.out.println("4.Exit");
        System.out.println("Please enter your choice:");
        int menuChoice=sc.nextInt();
        switch (menuChoice) {
        case 1: 
        System.out.println("------------CUSTOMER------------"); 
        System.out.println("1.Create New Customer");
        System.out.println("2.Update Customer");
        System.out.println("3.View Customer");
        System.out.println("Please enter your choice:");
        int customerMenuChoice=sc.nextInt();
		switch(customerMenuChoice){
			case 1:
			try{
			CustomerData c = new CustomerData();
			c.createCustomer();}
			catch(IOException e)
            {
             System.err.println(e);
            }
			break;
			case 2:
			try{
			CustomerData c1 = new CustomerData();
			c1.updateCustomerData();}
			catch(IOException e)
            {
             System.err.println(e);
            }
			break;
			case 3:
			try{
			CustomerData c2 = new CustomerData();
			c2.displayCustomerData();}
			catch(IOException e)
            {
             System.err.println(e);
            }
			break;
			default: 
            System.out.println("Invalid choice");
		}
	    break;
        case 2: 
        System.out.println("------------SERVICES------------"); 
        System.out.println("1.Create New Service");
        System.out.println("2.Update Service");
        System.out.println("3.View Services");
        System.out.println("Please enter your choice:");
        int serviceMenuChoice=sc.nextInt();
		switch(serviceMenuChoice){
			case 1:
			try{
			ServiceData s = new ServiceData();
			s.createService();}
			catch(IOException e)
            {
             System.err.println(e);
            }
			break;
			case 2:
			try{
			ServiceData s = new ServiceData();
			s.updateServiceData();}
			catch(IOException e)
            {
             System.err.println(e);
            }
			break;
			case 3:
			try{
			ServiceData s = new ServiceData();
			s.displayServiceData();}
			catch(IOException e)
            {
             System.err.println(e);
            }
			break;
			default: 
            System.out.println("Invalid choice");
		}
        break;
        case 3: 
        System.out.println("------------APPOINTMENTS------------"); 
        System.out.println("1.Book Appointment");
        System.out.println("2.View Appointment");
        System.out.println("Please enter your choice:");
        int appointmentMenuChoice=sc.nextInt();
		switch(appointmentMenuChoice){
			case 1:
			Map<String,AppointmentDetails> map=new HashMap<String,AppointmentDetails>();    
			String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/appointmentdata.txt";
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String data = df.format(new Date());
		    AppointmentDetails a1=new AppointmentDetails(); 
		    a1.selectCustomer();
			a1.selectService();
			a1.selectTimeSlot();	
			String a= a1.customerName;
			long b= a1.mobile;
			String c=a1.serviceName;
			int d=a1.cost;
			String e=a1.timeSlot;
			AppointmentDetails a2=new AppointmentDetails(a,b,c,d,e);         
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
			break;		
			case 2:
			System.out.println("------------VIEW APPOINTMENTS------------"); 
			System.out.println("1.View All Appointments");
			System.out.println("2.View Appointments by Date");
			System.out.println("Please enter your choice:");
			int appointmentChoice=sc.nextInt();
			switch(appointmentChoice){
				case 1:
			AppointmentDetails a3=new AppointmentDetails(); 
			a3.displayAllAppointments();
			break;
			    case 2:
				AppointmentDetails a4=new AppointmentDetails(); 
			a4.displayAppointmentsByDate();
			}
        break;
        default: 
        System.out.println("Invalid choice");
        }
    }
}}}
}