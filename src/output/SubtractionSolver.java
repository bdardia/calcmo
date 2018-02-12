package output;

import input.AdditionSolver;
import input.DimitrisAlgebraicNode;
import input.Solver;
import input.Solver.PrecedenceConstants;

public class SubtractionSolver implements Solver{
	
	private int precedence = Solver.PrecedenceConstants.subtractionSolver;
	
	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		lhs.solve();
		rhs.solve();
		return lhs.value - rhs.value;
	}

	@Override
	public String getOperation() {
		return "-";
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public Solver getInverse() {
		return new AdditionSolver();
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

	@Override
	public Solver createNew() {
		return new SubtractionSolver();
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;
	}

	
}
