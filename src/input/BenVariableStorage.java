package input;

public class BenVariableStorage 
{
	
	private String name;
	private double value;
	private boolean isSet;
	
	public BenVariableStorage(String name, double value, boolean isSet)
	{
		this.name = name;
		this.value = value;
		this.isSet = isSet;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getValue()
	{
		return this.value;
	}
	
	public void setValue(double value)
	{
		this.value = value;
	}
	
	public void setSet(boolean isSet)
	{
		this.isSet = isSet;
	}
	
	public boolean getSet()
	{
		return this.isSet;
	}
}
