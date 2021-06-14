import java.io.*; 
import java.util.*; 
import java.util.Scanner;
public class ServiceDetails { 
public String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/servicedata.txt";
HashMap<String, Integer> map  = new HashMap<String, Integer>(); 
void createService() throws IOException{ 
Scanner sc = new Scanner(System.in);
System.out.println("Enter the Service name");
String name = sc.nextLine();
System.out.println("Enter the Service Cost");
int cost = sc.nextInt();
map.put(name,cost); 
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw=new PrintWriter(bw);
for (Map.Entry<String, Integer> entry : map.entrySet()) {  
pw.println(entry.getKey() + ":"+ entry.getValue()); 
} 
pw.close();
}
catch(IOException e)
{
System.err.println(e);
}
} 
void updateServiceData() throws IOException{
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/servicedata.txt"; 
Scanner sc2 = new Scanner(System.in);
System.out.println("Enter the Service name");
String name1 = sc2.nextLine();
Scanner sc3 = new Scanner(System.in);
System.out.println("Enter the Service cost");
int num = sc3.nextInt();
map.put(name1, num);
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
for (Map.Entry<String, Integer> entry : map.entrySet()) {  
pw1.println(entry.getKey() + ":"+ entry.getValue()); 
} 
pw1.close();
}
catch(IOException e)
{
System.err.println(e);
}
}
void displayServiceData() throws IOException{
String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/servicedata.txt"; 
   String line;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    while ((line = reader.readLine()) != null)
    {
        String[] parts = line.split(":", 2);
        if (parts.length >= 2)
        {
            String key = parts[0];
            String value = parts[1];
			int i=Integer.parseInt(value);  
            map.put(key, i);
        } else {
            System.out.println("ignoring line: " + line);
        }
    }
 for (String key : map.keySet())
    {
        
        System.out.println(key + ":" + map.get(key));
    }
}

public static void main(String args[])throws IOException
{
	ServiceDetails s = new ServiceDetails();
	s.createService();
	s.updateServiceData();
	s.displayServiceData();
}
   }