package input;

public class Exponent implements Solver {
	
	int precedence = Solver.PrecedenceConstants.exponentSolver;
	
	public Exponent() {
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		lhs.solve();
		rhs.solve();
		return Math.pow(lhs.value, rhs.value);
	}

	@Override
	public String getOperation() {
		return "^";
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
	public Solver createNew() {
		return new Exponent();
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;

	}

}
