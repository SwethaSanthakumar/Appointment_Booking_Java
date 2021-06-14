import java.io.*; 
import java.util.*; 
import java.util.Scanner;
public class CustomerDetails{
HashMap<String, String> map = new HashMap<String, String>();
void createCustomer() throws IOException{ 
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/customerdata.txt"; 
Scanner sc = new Scanner(System.in);
System.out.println("Enter the Customer name");
String name = sc.nextLine();
System.out.println("Enter the Customer's mobile number");
String mobile = sc.nextLine();
map.put(name,mobile); 
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw=new PrintWriter(bw);
for (Map.Entry<String, String> entry : map.entrySet()) {  
pw.println(entry.getKey() + ":"+ entry.getValue()); 
} 
pw.close();
}
catch(IOException e)
{
System.err.println(e);
}
} 

void displayCustomerData() throws IOException{
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/customerdata.txt"; 
   String line;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    while ((line = reader.readLine()) != null)
    {
        String[] parts = line.split(":", 2);
        if (parts.length >= 2)
        {
            String key = parts[0];
            String value = parts[1];
            map.put(key, value);
        } else {
            System.out.println("ignoring line: " + line);
        }
    }
 for (String key : map.keySet())
    {
        System.out.println(key + ":" + map.get(key));
    }
}
void updateCustomerData() throws IOException{
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/customerdata.txt"; 
Scanner sc2 = new Scanner(System.in);
System.out.println("Enter the Customer's name");
String name1 = sc2.nextLine();
Scanner sc3 = new Scanner(System.in);
System.out.println("Enter the Customer's mobile no");
long num = sc3.nextLong();
String s=String.valueOf(num);
map.put(name1, s);
    for (String key : map.keySet())
    {
        
        System.out.println(key + ":" + map.get(key));
    }

try { 
PrintWriter pw = new PrintWriter(filePath);
pw.print("");
pw.close();
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw1=new PrintWriter(bw);
for (Map.Entry<String, String> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ":"+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e)
{
System.err.println(e);
}
}
}