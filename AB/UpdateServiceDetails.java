import java.io.*; 
import java.util.*; 
public class UpdateServiceDetails
{
	public Map<String,Integer> serviceMap=new HashMap<String,Integer>(); 
	
	public String name;
	public String cost;
	public int price;
	
	public int newCost;
	
	public String serviceDataFilePath = "C:/Users/Admin/Desktop/Intern/Java/AB/servicedata.txt"; 
	public String line;
	public String parts[];
	public BufferedReader serviceDataReader;
	public BufferedWriter serviceDataBufferedWriter;
	public FileWriter serviceDataFileWriter;
	public PrintWriter serviceDataPrintWriter ;
	public ArrayList<String> existingServiceName = new ArrayList<String>();
	
	public void existingServiceData() throws IOException
	{
	serviceDataReader = new BufferedReader(new FileReader(serviceDataFilePath));
	while ((line = serviceDataReader.readLine()) != null)
	{
	parts = line.split(",", 2);
	if (parts.length >= 2)
	{
	existingServiceName.add(parts[0]);
	} 
	}
	}	
	
	public void updateCost(String serviceName) throws IOException
    {
		System.out.println("Enter the new Service cost");
		Scanner sc1=new Scanner(System.in);
        newCost = sc1.nextInt();
		serviceDataReader = new BufferedReader(new FileReader(serviceDataFilePath));
		while ((line = serviceDataReader.readLine()) != null)
		{
			parts = line.split(",", 2);
			if (parts.length >= 2)
			{
			name = parts[0];
			cost = parts[1];
			price=Integer.parseInt(cost);
			
			if(serviceName.equals(name))
			{
				price=newCost; 
				serviceMap.put(name,price);
			}
			else
			{
			serviceMap.put(name,price);
			}
			} 
		}
		serviceDataPrintWriter = new PrintWriter(serviceDataFilePath);
		serviceDataPrintWriter.print("");
		serviceDataPrintWriter.close();
		
		try 
		{ 
		serviceDataFileWriter=new FileWriter(serviceDataFilePath,true);
		serviceDataBufferedWriter=new BufferedWriter(serviceDataFileWriter);
		serviceDataPrintWriter=new PrintWriter(serviceDataBufferedWriter);
		
		for (Map.Entry<String, Integer> entry : serviceMap.entrySet()) 
		{  
		serviceDataPrintWriter.println(entry.getKey() + ","+ entry.getValue()); 
		} 
		serviceDataPrintWriter.close();
		}
		catch(IOException e1)
		{
		System.err.println(e1);
		}
    }
	}