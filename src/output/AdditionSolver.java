package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class AdditionSolver implements Solver {
	
	int precedence = 2;

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		lhs.solve();
		rhs.solve();
		return lhs.value + rhs.value;
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "+";
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return precedence;
	}

	@Override
	public Solver getInverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addParent(DimitrisAlgebraicNode n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean urinaryFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;
		
	}

}
