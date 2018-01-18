package history;

import java.util.ArrayList;

public class AbedHistoryNode 
{
	private String input;
	private String output;
	public AbedHistoryNode(String input,String output)
	{
		this.input = input;
		this.output = output;
	}
	public ArrayList<String> print(ArrayList<String> a)
	{
		a.add(input);
		a.add(output);
		return a;
	}
	
}
