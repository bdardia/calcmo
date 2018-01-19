package history;

import java.util.ArrayList;

public class AbedHistoryNode 
{
	private String input;
	private String output;
	private ArrayList<String> a;

	public AbedHistoryNode(String input,String output)
	{
		this.input = input;
		this.output = output;
	}
	public ArrayList<String> print()
	{
		a.add(input);
		a.add(output);
		return a;
	}
	
	public String getInput()
	{
		return input;
	}
	
	public void setInput(String input) 
	{
		this.input = input;
	}
	
	public String getOutput() 
	{
		return output;
	}
	
	public void setOutput(String output)
	{
		this.output = output;
	}
	
	
}
