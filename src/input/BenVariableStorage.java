package input;

import java.util.ArrayList;
import java.util.Arrays;

public class BenVariableStorage 
{
	
	static ArrayList<BenVariableStorage> variableArray = 
			new ArrayList<BenVariableStorage>(Arrays.asList(new BenVariableStorage("pi", Math.PI, true))); //default values
	
	
	
	private String name;
	private double value;
	private boolean isSet;
	
	
	public static void setValue(String varName, double value) 
	{
		for(int i=0; i < variableArray.size(); i++) 
		{
			if(variableArray.get(i).getName().equals(varName)) 
			{
				variableArray.get(i).setValue(value);
				return;
			}
			
		}
	}
	
	@SuppressWarnings("null")
	public static double getValue(String varName) { //check if value exits first
		for(int i=0; i < variableArray.size(); i++) 
		{
			if(variableArray.get(i).getName().equals(varName)) 
			{
				return variableArray.get(i).getValue();
			}
			
		}
		return (Double) null;
		
	}
	
	public static boolean isSet(String varName) {
		for(int i=0; i < variableArray.size(); i++) 
		{
			if(variableArray.get(i).getName().equals(varName)) 
			{
				return true;
			}
			
		}
		return false;
		
	}
	
	public static void createNewVariable(String varName, double value)
	{
		variableArray.add(new BenVariableStorage(varName, value, true));
	}
	
	public static void removeVariable(String varName)
	{
		for(int i=0; i < variableArray.size(); i++) 
		{
			if(variableArray.get(i).getName().equals(varName)) 
			{
				variableArray.remove(i);
			}
			
		}
	}
	
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
