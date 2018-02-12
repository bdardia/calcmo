package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class DivisionSolver implements Solver {
	private int precedence = 3;
	
	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		lhs.solve();
		rhs.solve();
		
		return lhs.value / rhs.value;
	}

	@Override
	public String getOperation() {
		return "/";
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public Solver getInverse() {
		return new MultiplicationSolver();
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

	@Override
	public Solver createNew() {
		return new DivisionSolver();
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;
	}

}
