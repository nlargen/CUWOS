import java.util.LinkedList;
import java.util.Random;
//Hmwk8
public class ProcessScheduler
{
	
	private int currPID;
	private Random r = new Random();
	
	public ProcessScheduler()
	{
		//call the object default constructor
		this.currPID = 0;
	}
	
	public void createPCB()
	{
		int numInstructions = r.nextInt(41) + 10;
		System.out.println("Creating PCB with: " + numInstructions);
		LinkedList<String> theInstructions = new LinkedList<String>();
		for(int i = 0; i < numInstructions; i++)
		{
			theInstructions.add("instruction" + i); 
		}
		PCB theNewPCB = new PCB(this.currPID, null, theInstructions);
		//increment the PID for the next PCB
		this.currPID++; 
		//add the new pcb to the job que
		theNewPCB.setPriorityHigh();
		QFactory.theJobQ.addPCB(theNewPCB, false );
		
		System.out.println("Added to job q");
		
		//add the new pcb to the Ready Q 
		theNewPCB.setStateReady();
		QFactory.theReadyQ.addPCB(theNewPCB, true);
		
	}

}
