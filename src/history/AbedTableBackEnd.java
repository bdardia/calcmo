package history;

import java.util.ArrayList;

import input.DimitrisAlgebraicNode;
import input.DimitrisNodeBuilder;

public class AbedTableBackEnd 
{
	private ArrayList<AbedHistoryNode> functionNodes = JasHistoryScreen.fx;
	public static ArrayList<String> inputs = new ArrayList<String>();
	public static ArrayList<Double> functionalInputs = new ArrayList<Double>();
	public static ArrayList<Double> outputs = new ArrayList<Double>();
	public static ArrayList<AbedHistoryNode> coordinates = new ArrayList<AbedHistoryNode>();
	public static String function;
	
	///compile on the string called first n.solve then fill
	
	
	public static void convertInputs()
	{
		for(int i = 0; i < inputs.size();i++)
		{
			functionalInputs.add(i,Double.parseDouble(inputs.get(i)));
		}
		
	}
	
	public static void createOutputs()
	{
		convertInputs();
		outputs = DimitrisNodeBuilder.getOutputs(function,functionalInputs);
		for(int i = 0; i < outputs.size();i++)
		{
			System.out.println(outputs.get(i));
			coordinates.add(new AbedHistoryNode(functionalInputs.get(i),outputs.get(i)));
			
		}
	}
	
}
