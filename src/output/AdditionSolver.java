package output;

import input.DimitrisAlgebraicNode;
import input.Solver;
import input.Solver.PrecedenceConstants;

public class AdditionSolver implements Solver {
	
	int precedence = Solver.PrecedenceConstants.additionSolver;

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		lhs.solve();
		rhs.solve();
		return lhs.value + rhs.value;
	}

	@Override
	public String getOperation() {
		return "+";
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public Solver getInverse() {
		return null;
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
		return new AdditionSolver();
	}

}
