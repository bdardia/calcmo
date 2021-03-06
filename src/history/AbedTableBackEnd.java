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
	public static String function ;
	public static ArrayList<AbedHistoryNode> masterHistory = new ArrayList<AbedHistoryNode>();
	
	///compile on the string called first n.solve then fill
	
	
	public static void convertInputs()
	{
		for(int i = 0; i < inputs.size();i++)
		{
			functionalInputs.add(i,Double.parseDouble(inputs.get(i)));
		}
		inputs.clear();
		
	}
	
	public static void createOutputs()
	{
		convertInputs();
		outputs = DimitrisNodeBuilder.getOutputs(function,functionalInputs);
		for(int i = 0; i < outputs.size();i++)
		{
			
			coordinates.add(new AbedHistoryNode(functionalInputs.get(i),outputs.get(i)));
			masterHistory.add(new AbedHistoryNode(functionalInputs.get(i),outputs.get(i)));
		}
		
		
		/*for(int i = 0; i < coordinates.size(); i++)
		{
			System.out.println(coordinates.get(i).getIn());
			System.out.println(coordinates.get(i).getput());
		}*/
	
		
	}
	
}
