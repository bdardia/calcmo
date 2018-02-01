package input;

import java.util.ArrayList;

public class DimitrisParser {
	
	String currentText;

	public DimitrisParser() {
		// TODO Auto-generated constructor stub
	}
	
	ArrayList<DimitrisAlgebraicNode> parse() {
		ArrayList<DimitrisAlgebraicNode> parsedArray = new ArrayList<DimitrisAlgebraicNode>();
		int start = 0;
		for(int index = 0; index < currentText.length(); index++) {
			String currentSubString = currentText.substring(start, index);
			int nodeIndex = getAlgebraicNode(currentSubString);
			if(nodeIndex != -1) {
				parsedArray.add(new DimitrisAlgebraicNode(DimitrisAlgebraicNode.solverArray[nodeIndex]));
				start = index;
			}
		}
		return parsedArray;
	}
	

	int getAlgebraicNode(String operation){
		for(int i = 0; i < DimitrisAlgebraicNode.solverArray.length; i++) {
			Solver s = DimitrisAlgebraicNode.solverArray[i];
			if(s.getOperation() == operation) {
				return i;
			}
		}
		return -1;
	}
	

}
