package history;

import java.util.ArrayList;

import input.DimitrisAlgebraicNode;
import input.DimitrisNodeBuilder;

public class AbedTableBackEnd 
{
	private ArrayList<AbedHistoryNode> functionNodes = JasHistoryScreen.fx;
	public static ArrayList<String> inputs;
	public static ArrayList<Double> functionalInputs;
	public static ArrayList<Double> outputs;
	public static ArrayList<AbedHistoryNode> hist;
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
	}
	
}
