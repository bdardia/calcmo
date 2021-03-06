package output;

import input.DimitrisAlgebraicNode;
import input.Solver;
import input.Solver.PrecedenceConstants;

public class AchillesSubtractionSolver implements Solver{
	
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
		return new AchillesAdditionSolver();
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

	@Override
	public Solver createNew() {
		return new AchillesSubtractionSolver();
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;
	}

	
}
