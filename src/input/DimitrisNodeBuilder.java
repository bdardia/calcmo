package input;

import java.util.ArrayList;

public class DimitrisNodeBuilder {
	
	static ArrayList<DimitrisAlgebraicNode> parse(String currentText) {
		ArrayList<DimitrisAlgebraicNode> parsedArray = new ArrayList<DimitrisAlgebraicNode>();
		int start = 0;
		for(int index = 1; index <= currentText.length(); index++) {
			
			String currentSubString = currentText.substring(start, index);
			
			System.out.println("main loop");
			//System.out.println(currentSubString);
			
			Double number = (Double)null;
			for(int i = start + 1; i <= currentText.length(); i++) {
				String numberSubString = currentText.substring(start, i);
				try {
					number = Double.parseDouble(numberSubString);
					System.out.println(number);
				}
				catch(Exception e){
					System.out.println("caught exeption");
					System.out.println("currentSubString: " + currentSubString);
					System.out.println("numberSubString: " + numberSubString);
					if(number == null ) { //no number has been found
						int nodeIndex = getAlgebraicNode(currentSubString);
						if(nodeIndex != -1) {
							parsedArray.add(new DimitrisAlgebraicNode(DimitrisAlgebraicNode.solverArray[nodeIndex]));
							start = i - 1;
						}
					}
					else { //number has been found
						DimitrisAlgebraicNode n = new DimitrisAlgebraicNode(number);
						n.solver = new ConstantSolver(n);
						n.isConstant = true;
						parsedArray.add(n);
						start = index;
					}
					
					
					System.out.println("result substring:" + currentText.substring(start, index));
					break;
				}
			}

				
				
			
			
			

		}
		return parsedArray;
	}
	

	static int getAlgebraicNode(String operation){
		for(int i = 0; i < DimitrisAlgebraicNode.solverArray.length; i++) {
			Solver s = DimitrisAlgebraicNode.solverArray[i];
			if(s.getOperation().equals(operation)) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	static DimitrisAlgebraicNode buildTree(ArrayList<DimitrisAlgebraicNode> parsedArray, int precedence) {
		if(parsedArray.size() > 1) {
			DimitrisAlgebraicNode lhs = parsedArray.get(0);
			DimitrisAlgebraicNode rhs = parsedArray.get(1);
			int lhsPrecedence = lhs.solver.getPrecedence();
			int rhsPrecedence = rhs.solver.getPrecedence();
			
			if(lhsPrecedence < rhsPrecedence ) {
				if(rhsPrecedence > precedence) {
					rhs.lhs = lhs;
					parsedArray.remove(lhs);
					return buildTree(parsedArray, rhsPrecedence);
				}else {
					throw new NullPointerException("array cannot be simplified into one node");
				}
				
			}else {
				
				try {
					lhs.rhs = buildTree((ArrayList<DimitrisAlgebraicNode>) parsedArray.subList(1, parsedArray.size()), lhsPrecedence);
				}
				catch(Exception e){// array cannot be simplified into one node
					lhs.rhs = rhs;
					parsedArray.remove(rhs);
					return buildTree(parsedArray, lhsPrecedence);
				}
				
				return lhs;
				
			}			
			
		}else {
			return parsedArray.get(0);
		}
				
		
	}
	
	static DimitrisAlgebraicNode compileProgram(String program) {
		DimitrisAlgebraicNode returnNode = buildTree(parse(program),0);
		System.out.println(returnNode.toString(0));;
		return returnNode;
	}
	

}