package input;

import java.util.ArrayList;

public class DimitrisNodeBuilder {
	private static String logger = "";
	private static boolean debug = true;
	
	private static ArrayList<DimitrisAlgebraicNode> parse(String currentText) {
		ArrayList<DimitrisAlgebraicNode> parsedArray = new ArrayList<DimitrisAlgebraicNode>();

		
		int startIndex = 0;
		for(int index = currentText.length(); index >= 0; index--) {
			
			if(startIndex == currentText.length()) {
				break;
			}
			
			String currentString = currentText.substring(startIndex, index);
			logger += "currentString:" + currentString + "\n";
			

			try {
				double number = Double.parseDouble(currentString);
				
				if(currentString.substring(0, 1).equals("+") || currentString.substring(0, 1).equals("-")) {
					logger += "throwing exeption: missing plus sign is found" + "\n";
					throw new Exception("missing plus sign is found");
				}
				parsedArray.add(new DimitrisAlgebraicNode(number));
				logger += "adding number:" + number + "\n";
				startIndex += currentString.length();
				index = currentText.length() + 1;
			}
			catch(Exception e){
				int solverIndex = getSolverIndex(currentString);
				if(solverIndex != -1) {
					Solver s = DimitrisAlgebraicNode.solverArray[solverIndex];
					if(s.urinaryFunction() == true) {
						DimitrisAlgebraicNode placeHolder = new DimitrisAlgebraicNode(-1);
						placeHolder.isPlaceHolder = true;
						placeHolder.solver = new DefaultSolver(getMaxPrecedence()); //the placeholder needs the correct precedence to properly work with parenthesis
						parsedArray.add(placeHolder);
						logger += "added placeHolder" + "\n";
					}
					
					parsedArray.add( new DimitrisAlgebraicNode(s.createNew()));
					logger += DimitrisAlgebraicNode.solverArray[solverIndex].getOperation() + "\n";
					
					startIndex  += currentString.length();
					index = currentText.length() + 1;
					
				}else {
					if(startIndex == index) {
						logger += "found variable" + "\n";
						String varName;
						
						String testString = currentText.substring(startIndex, currentText.length());
						int lastOpIndex = testString.length();
						
						for(Solver s : DimitrisAlgebraicNode.solverArray) {
							int opIndex = testString.indexOf(s.getOperation());
							if(opIndex < lastOpIndex && opIndex != -1) {
								logger += "found op:" + s.getOperation() + "\n";
								
								lastOpIndex = opIndex;
							}
						}
					

						varName = testString.substring(0, lastOpIndex);

						logger += "varName:" + varName + "\n";
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
	
	
	public static int getSolverIndex(String operation){
		for(int i = 0; i < DimitrisAlgebraicNode.solverArray.length; i++) {
			Solver s = DimitrisAlgebraicNode.solverArray[i];
			if(s.getOperation().equals(operation)) {
				return i;
			}
		}
		return -1;
	}
	
	private static ArrayList<DimitrisAlgebraicNode> reduceParenthesis(ArrayList<DimitrisAlgebraicNode> preprocessedArray){
		logger += "started reduction of parenthesis" + "\n";
		int precedenceIncrease = 0;
		int precedenceInterval = getMaxPrecedence();
		
		//increase precedences
		for(int i = 0; i < preprocessedArray.size(); i++) {
			Solver currentSolver = preprocessedArray.get(i).solver;
			logger += "i:" + i + "\n";
			logger += "precedenceIncrease:" + precedenceIncrease + "\n";
			if(currentSolver.getOperation().equals("(")) {
				precedenceIncrease += precedenceInterval;
				preprocessedArray.remove(i);
				i--;
			}else if(currentSolver.getOperation().equals(")")) {
				precedenceIncrease -= precedenceInterval;
				preprocessedArray.remove(i);
				i--;

			}else {
				currentSolver.increasePrecedence(precedenceIncrease);
			}
		}
		
		
		return preprocessedArray;
	}
	
	
	private static int getMaxPrecedence() {
		return 60;
	}


	private static DimitrisAlgebraicNode buildTree(ArrayList<DimitrisAlgebraicNode> parsedArray, int index) {

		
		logger += "parsedArraylen:" + parsedArray.size() + "\n";
		logger += "index:" + index + "\n";
		for(DimitrisAlgebraicNode n : parsedArray) {
			logger += n.toString() + n.solver.getPrecedence() + "\n";
		
		}
		
		
		if(parsedArray.size() > 2) {
			if(index + 2 >= parsedArray.size()) {
				DimitrisAlgebraicNode lhs = parsedArray.get(parsedArray.size() - 2);
				DimitrisAlgebraicNode rhs = parsedArray.get(parsedArray.size() - 1);
				if(lhs.solver.getPrecedence() <= rhs.solver.getPrecedence()) {
					lhs.rhs = rhs;
					logger += "fold right end" + "\n";
					parsedArray.remove(rhs);
				}
				
				lhs = parsedArray.get(0);
				rhs = parsedArray.get(1);
				
				if(lhs.solver.getPrecedence() > rhs.solver.getPrecedence()){
					rhs.lhs = lhs;
					logger += "fold left end" + "\n";
					parsedArray.remove(lhs);
					
				}
				logger += "reset" + "\n";
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
				
				
				if(lhsPrecedence < middlePrecedence && lhsPrecedence > rhsPrecedence) {
					logger += "folded into left" + "\n";
					lhs.rhs = middle;
					parsedArray.remove(middleIndex);
					return buildTree(parsedArray, index + 1);
				}else if(rhsPrecedence < middlePrecedence && rhsPrecedence > lhsPrecedence) {
					logger += "folded right" + "\n";
					rhs.lhs = middle;
					parsedArray.remove(middleIndex);
					return buildTree(parsedArray, index + 1);
				}else {
					
					if(lhsPrecedence == rhsPrecedence && rhsIndex == parsedArray.size() - 1) {
						if(rhsPrecedence < middlePrecedence) {
							rhs.lhs = middle;
							lhs.rhs = rhs;
							parsedArray.remove(rhs);
							parsedArray.remove(middle);
							logger += "folded complete to the left" +"\n";
							buildTree(parsedArray, index+1);
						}
					}
					
					logger += "default" + "\n";
					return buildTree(parsedArray, index+1);
				}
			}
		}
		else {
			if(parsedArray.size() == 2) {
				DimitrisAlgebraicNode lhs = parsedArray.get(0);
				DimitrisAlgebraicNode rhs = parsedArray.get(1);
				if(lhs.solver.getPrecedence() < rhs.solver.getPrecedence()) { //always try folding rhs first
					lhs.rhs = rhs;
					return lhs;
				}else {
					rhs.lhs = lhs;
					return rhs;
				}
			}else {
				return parsedArray.get(0);
			}
			
		}
		

				
		
	}
	
	public static DimitrisAlgebraicNode compileProgram(String program) {
		
		logger += "starting parser" + "\n";
		ArrayList<DimitrisAlgebraicNode> parsedArray = parse(program);
		logger += "finished parsing";
		
		logger += "starting reduceParenthesis" + "\n";
		parsedArray = reduceParenthesis(parsedArray);
		logger += "finished reduceParenthesis" + "\n";
		
		logger += "started building tree" + "\n";
		DimitrisAlgebraicNode returnNode = buildTree(parsedArray, 0);
		logger += "finished building tree" + "\n";
		
		logger += "filling variables " + "\n";
		fillVariables(returnNode);
		logger += "filled variables " + "\n";
		
		if(debug) {
			System.out.println("printing logger");
			System.out.println(logger);
			System.out.println("printing final tree");
			System.out.println(returnNode.toString(0));
			returnNode.solve();
			System.out.println("evaluation:" + returnNode.value);
		}
		
		

		return returnNode;
	}
	
	
	static ArrayList<Double> getOutputs(String program, ArrayList<Double> inputs){
		DimitrisAlgebraicNode rootNode = compileProgram(program);
		ArrayList<Double> outputs = new ArrayList<Double>();
		
		for(double input: inputs) {
			updateVariable(rootNode, "x", input);
			rootNode.solve();
			outputs.add(rootNode.value);
		}
		
		return outputs;
	}
	
	static void fillVariables(DimitrisAlgebraicNode n) {
		if(n.isVariable && BenVariableStorage.isSet(n.varName)) {
			n.value = BenVariableStorage.getValue(n.varName);
		}else {
			if(!n.isConstant && !(n.solver.getOperation() == "NAO")) { //not end of tree
				if(!(n.lhs == null)) {
					fillVariables(n.lhs);
				}
				if(!(n.rhs == null)) {
					fillVariables(n.rhs);
				}
				
			}
		}
	}
	
	static void updateVariable(DimitrisAlgebraicNode n, String varName, double value) {
		if(n.isVariable && n.varName.equals(varName)) {
			n.value = value;
			n.isEvaluated = true;
		}else {
			if(!n.isConstant && !(n.solver.getOperation().equals("NAO"))) { //not end of tree
				updateVariable(n.lhs,varName, value);
				updateVariable(n.rhs,varName, value);
			}
		}
	}
	
	
	public static void main(String[] args) {
		String testString = "cos(pi/2)";
		debug = true;
//		ArrayList<DimitrisAlgebraicNode> parsedArray = reduceParenthesis(parse(testString));
//		System.out.println(logger);
//		for(DimitrisAlgebraicNode n : parsedArray) {
//			System.out.println(n.toString() + " " + n.solver.getPrecedence());
//		}
		
		compileProgram(testString);
	}
}