package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class AlgebraSolver implements Solver {
	
	public String left;
	
	public String right;
	
	
	public DimitrisAlgebraicNode variable;
	
	public String expression = left + " = " + right;
	
	
	public void evaluateExpression(String expression) {
		for(int i = 0; i < expression.length(); i++) {
			if(expression[i] == "=") {
				left = expression.substring(0, i-1);
				right = expression.substring(i+1, expression.length());
			}
		}
		
		DimitrisAlgebraicNode lhs = new DimitrisAlgebraicNode(left);
		DimitrisAlgebraicNode rhs = new DimitrisAlgebraicNode(right);
	}

	public AlgebraSolver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Solver getInverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solver createNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean urinaryFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
		// TODO Auto-generated method stub
		
	}

}
