package monster.model;

public class MarshmallowMonster
{
	// Declaration section for the data members
	private String name;
	private int eyeCount;
	private int armCount;
	private double tentacleAmount;
	private boolean hasBloop;
	
	public MarshmallowMonster()
	{
		//Unless we specify values, all data members
		//are a zero, false, or null
	}
	
	public MarshmallowMonster(String name, int eyeCount, int armCount, double tentacleAmount, boolean hasBloop)
	{
		this.name = name;
		this.eyeCount = eyeCount;
		this.armCount = armCount;
		this.tentacleAmount = tentacleAmount;
		this.hasBloop = hasBloop;
	}
	
	public String toString()
	{
		 String description = "";
		 return description;
	}
}
