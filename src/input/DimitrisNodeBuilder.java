package input;

import java.util.ArrayList;

public class DimitrisNodeBuilder {
	
	

	public DimitrisNodeBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	ArrayList<DimitrisAlgebraicNode> parse(String currentText) {
		ArrayList<DimitrisAlgebraicNode> parsedArray = new ArrayList<DimitrisAlgebraicNode>();
		int start = 0;
		for(int index = 0; index < currentText.length(); index++) {
			String currentSubString = currentText.substring(start, index);
			try {
				parsedArray.add(new DimitrisAlgebraicNode(Double.parseDouble(currentSubString)));
				
			}
			catch(Exception e) {
				int nodeIndex = getAlgebraicNode(currentSubString);
				if(nodeIndex != -1) {
					parsedArray.add(new DimitrisAlgebraicNode(DimitrisAlgebraicNode.solverArray[nodeIndex]));
					start = index;
				}
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
	
	
	
	DimitrisAlgebraicNode buildTree(ArrayList<DimitrisAlgebraicNode> parsedArray) {
		if(parsedArray.size() > 1) {
			DimitrisAlgebraicNode lhs = parsedArray.get(0);
			DimitrisAlgebraicNode rhs = parsedArray.get(1);
			int lhsPrecedence = lhs.solver.getPrecedence();
			int rhsPrecedence = rhs.solver.getPrecedence();
			
			if(lhsPrecedence < rhsPrecedence) {
				rhs.lhs = lhs;
				parsedArray.remove(lhs);
				return buildTree(parsedArray);
			}else {
				parsedArray.remove(rhs);
				lhs.rhs = buildTree(parsedArray);
				return lhs;
			}
			
		}else {
			return parsedArray.get(0);
		}
				
		
	}
	
	
	DimitrisAlgebraicNode compileProgram(String program) {
		return buildTree(parse(program));
	}
	

}