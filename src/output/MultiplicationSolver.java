package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class MultiplicationSolver implements Solver {
	private int precedence = Solver.PrecedenceConstants.multiplicationSolver;
	
	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		lhs.solve();
		rhs.solve();
		return lhs.value * rhs.value;
	}

	@Override
	public String getOperation() {
		return "*";
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public Solver getInverse() {
		return new DivisionSolver();
	}

	@Override
	public void addParent(DimitrisAlgebraicNode n) {
		
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;
		
	}

	@Override
	public Solver createNew() {
		return new MultiplicationSolver();
	}

}
