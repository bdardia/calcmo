package history;

import java.util.ArrayList;

import input.DimitrisAlgebraicNode;
import input.DimitrisNodeBuilder;

public class AbedTableBackEnd 
{
	private ArrayList<AbedHistoryNode> functionNodes = JasHistoryScreen.fx;
	private ArrayList<String> domain;
	///compile on the string called first n.solve then fill
	
	public static void main(String[] args)
	{
		createOutputs();
		System.out.println("s");
	}
	public AbedTableBackEnd() 
	{
		
		
	}
	public static void createOutputs()
	{
		ArrayList<Double> n = new ArrayList<Double>();
		ArrayList<Double> t = DimitrisNodeBuilder.getOutputs("x",n);
		for(int i  = 0; i < t.size();i++)
		{
			System.out.println(t.get(i));
		}
		
	}
	
}
