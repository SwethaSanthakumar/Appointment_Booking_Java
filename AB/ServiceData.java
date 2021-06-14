import java.io.*; 
import java.util.*; 
import java.util.Scanner;
public class ServiceData
{
HashMap<String, Integer> serviceMap = new HashMap<String, Integer>();
public String filePath = "C:/Users/Admin/Desktop/Intern/Java/AB/servicedata.txt"; 
public String serviceName;
public int serviceCost;
UpdateServiceDetails u = new UpdateServiceDetails();
void createService() throws IOException
{ 
Scanner sc = new Scanner(System.in);
System.out.println("------------------------------------------");
System.out.println("            CREATING NEW SERVICE          ");
System.out.println("------------------------------------------");
System.out.println("Enter the Service name");
serviceName = sc.nextLine();
System.out.println("Enter the Service Cost");
serviceCost = sc.nextInt();
serviceMap.put(serviceName,serviceCost); 
try { 
FileWriter fw=new FileWriter(filePath,true);
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw=new PrintWriter(bw);
for (Map.Entry<String, Integer> entry : serviceMap.entrySet()) {  
pw.println(entry.getKey() + ","+ entry.getValue()); 
} 
pw.close();
}
catch(IOException e)
{
System.err.println(e);
}
System.out.println("Created New Service Successfully");
} 

void displayServiceData() throws IOException
{
String line;
BufferedReader reader = new BufferedReader(new FileReader(filePath));
while ((line = reader.readLine()) != null)
{
String[] parts = line.split(",", 2);
if (parts.length >= 2)
{
String key = parts[0];
String value = parts[1];
int cost=Integer.parseInt(value);  
serviceMap.put(key, cost);
}
}
System.out.println("---------------------------------------------------");
System.out.printf("%25s %10s" , "SERVICE NAME", "COST");
System.out.println();
System.out.println("---------------------------------------------------");

for (String key : serviceMap.keySet())
{
System.out.format("%25s %10d",key,serviceMap.get(key));
System.out.println();
}
System.out.println("---------------------------------------------------");
}


void updateServiceData()throws IOException
{
Scanner sc2 = new Scanner(System.in);
System.out.println("------------------------------------------");
System.out.println("           UPDATE EXISTING SERVICE        ");
System.out.println("------------------------------------------");
System.out.println("Enter the Service name");
String name1 = sc2.nextLine();
u.updateCost(name1);	
System.out.println("Service Updated Successfully");
}

public static void main(String args[]) throws IOException
{
ServiceData d = new ServiceData();
//d.createService();
//d.displayServiceData();
d.displayServiceData();
d.updateServiceData();
d.displayServiceData();
}
}