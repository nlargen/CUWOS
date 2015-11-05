
public class Driver {

	public static void main(String[] args)
	{
		//Initialize the OS
		OS theOS = new OS(); 
		
		for(int i = 0; i < 10; i++)
		{
			theOS.theProcessScheduler.createPCB();
		}
     
	}

}
