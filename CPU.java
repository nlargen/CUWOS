import java.util.LinkedList;

class Register
	{
		private String name;
		private String binaryValue;
		
		public Register(String name)
		{
			this.name = name; 
			this.binaryValue = "00000000";
		}
		public Register getcopy()
		{
			Register r = new Register(this.name);
			r.binaryValue = this.binaryValue;
			return r; 
		}
		public String getBinaryValue() {
			return binaryValue;
		}

		public void setBinaryValue(String binaryValue) {
			this.binaryValue = binaryValue;
		}

		public String getName() {
			return name;
		}
		
	}

public class CPU 
{
	
	private PCB thePCB; 
	private LinkedList<Register> theRegisters = new LinkedList<Register>();
	
	
	public CPU()
	{
		this.thePCB = null;
		this.theRegisters.add(new Register("AX"));
		this.theRegisters.add(new Register("BX"));
		this.theRegisters.add(new Register("CX"));
		this.theRegisters.add(new Register("DX"));
		
	}
	
	public void contextSwitchIn(PCB goat)
	{
		for(Register r : this.theRegisters)
		{
			String val = goat.getValueForRegister(r.getName());
			if(val != null)
			{
				r.setBinaryValue(val);
			}
		}
		this.thePCB = goat;
	}
	public PCB contextSwitchOut(PCB goat)
	{
		this.thePCB.clearRegisterStorage();
		for(Register r : this.theRegisters)
		{
			this.thePCB.storeRegister(r.getcopy()); 
		}
		PCB temp = this.thePCB; 
		this.thePCB = null; 
		return temp; 
	}
	
}
