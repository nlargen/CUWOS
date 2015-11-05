 import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PSQueue
{
	private LinkedList<PCB> theLowQ = new LinkedList<PCB>();
	private LinkedList<PCB> theNormalQ = new LinkedList<PCB>();
	private LinkedList<PCB> theHighQ = new LinkedList<PCB>();
	private LinkedList<LinkedList<PCB>> theQs = new LinkedList<LinkedList<PCB>>();
	
	public PSQueue()
	{
		theQs.add(this.theLowQ); 
		theQs.add(this.theNormalQ); 
		theQs.add(this.theHighQ); 
	}
	
	public PCB getPCBwithPriority(int priority)
	{
		try
		{
			
		return this.theQs.get(priority).removeFirst();
		
		}
		catch(NoSuchElementException e)
		{
			return PCB.PCBNotFound; 
		}
	}
	public void addPCB(PCB p, boolean withPriority)
	{
		if(!withPriority)
		{
			theQs.get(PCB_Priority.NORMAL).addLast(p);
		}
		else 
		{
			theQs.get(p.getPriority()).addLast(p);
			//Hmwk 9
		}
	}
}
