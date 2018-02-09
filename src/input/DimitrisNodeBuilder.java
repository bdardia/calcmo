package input;

import java.util.ArrayList;

public class DimitrisNodeBuilder {
	
	static ArrayList<DimitrisAlgebraicNode> parse(String currentText) {
		ArrayList<DimitrisAlgebraicNode> parsedArray = new ArrayList<DimitrisAlgebraicNode>();

		int startIndex = 0;
		for(int index = currentText.length(); index >= 0; index--) {
			
			if(startIndex == currentText.length()) {
				break;
			}
			
			String currentString = currentText.substring(startIndex, index);
			System.out.println("currentString:" + currentString);
			try {
				double number = Double.parseDouble(currentString);
				
				if(currentString.substring(0, 1).equals("+")) {
					throw new Exception("missing plus sign is found");
				}
				parsedArray.add(new DimitrisAlgebraicNode(number));
				System.out.println(number);
				startIndex += currentString.length();
				index = currentText.length() + 1;
			}
			catch(Exception e){
				int solverIndex = getSolverIndex(currentString);
				if(solverIndex != -1) {
					Solver s = DimitrisAlgebraicNode.solverArray[solverIndex];
					if(s.urinaryFunction() == true) {
						DimitrisAlgebraicNode placeHolder = new DimitrisAlgebraicNode(-1);
						parsedArray.add(placeHolder);
					}
					
					parsedArray.add( new DimitrisAlgebraicNode(s));
					System.out.println(DimitrisAlgebraicNode.solverArray[solverIndex].getOperation());
					
					startIndex  += currentString.length();
					index = currentText.length() + 1;
					
				}else {
					if(startIndex == index) {
						System.out.println("found variable");
						String varName = currentText.substring(startIndex, currentText.length());
						parsedArray.add(new DimitrisAlgebraicNode(varName));
						
						startIndex += varName.length();
						index = currentText.length() + 1;
					}
				}
			}
		}
		
//		for(DimitrisAlgebraicNode n : parsedArray) {
//			if(!n.isVariable) {
//				System.out.println(n.solver.getOperation());
//			}else {
//				System.out.println(n.varName);
//			}
//			
//		}
		return parsedArray;
	}
	

	static int getSolverIndex(String operation){
		for(int i = 0; i < DimitrisAlgebraicNode.solverArray.length; i++) {
			Solver s = DimitrisAlgebraicNode.solverArray[i];
			if(s.getOperation().equals(operation)) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	static DimitrisAlgebraicNode buildTree(ArrayList<DimitrisAlgebraicNode> parsedArray, int index) {
		System.out.println("parsedArraylen:" + parsedArray.size());
		for(DimitrisAlgebraicNode n : parsedArray) {
			
			if(!n.isVariable) {
				System.out.println(n.solver.getOperation());
			}else {
				System.out.println(n.varName);
			}
		
		}
		
		
		if(parsedArray.size() >= 3) {
			int nodesLeft = parsedArray.size() - index  - 2;
			if(nodesLeft <= 0) {
				return buildTree(parsedArray, 0);
			}else {
				
				int lhsIndex = index;
				int middleIndex = index + 1;
				int rhsIndex = index + 2;
				
				DimitrisAlgebraicNode lhs = parsedArray.get(lhsIndex);
				DimitrisAlgebraicNode middle = parsedArray.get(middleIndex);
				DimitrisAlgebraicNode rhs = parsedArray.get(rhsIndex);
				
				int lhsPrecedence = lhs.solver.getPrecedence();
				int middlePrecedence = middle.solver.getPrecedence();
				int rhsPrecedence = rhs.solver.getPrecedence();
				
				
				
				if(lhsPrecedence < middlePrecedence) {
					return buildTree(parsedArray, middleIndex);
				}
			}
			
			
		}else {
			if(parsedArray.size() == 2) {
				DimitrisAlgebraicNode lhs = parsedArray.get(0);
				DimitrisAlgebraicNode rhs = parsedArray.get(1);
				
				if(lhs.solver.getPrecedence() < rhs.solver.getPrecedence()) {
					rhs.lhs = lhs;
					return rhs;
				}else {
					lhs.rhs = rhs;
					return lhs;
				}
			}
			else {
				
				System.out.println("error");
				return (DimitrisAlgebraicNode)null;
			}
		}
		
		System.out.println("unreachable");
		return null;
				
		
	}
	
	static DimitrisAlgebraicNode compileProgram(String program) {
		DimitrisAlgebraicNode returnNode = buildTree(parse(program),0);
		System.out.println(returnNode.toString(0));
		returnNode.solve();
		System.out.println("evaluation:" + returnNode.value);
		return returnNode;
	}
	

}