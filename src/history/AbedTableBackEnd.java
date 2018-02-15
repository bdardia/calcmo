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
	}
	public AbedTableBackEnd() 
	{
		s = new DimitrisNodeBuilder();
		
	}
	public static void createOutputs()
	{
		 DimitrisAlgebraicNode n = DimitrisNodeBuilder.compileProgram("x^2");
		 DimitrisNodeBuilder.updateVariable(n, "x", 0);
		 n.solve();
		 System.out.println(n.value);
		
	}
	
}
