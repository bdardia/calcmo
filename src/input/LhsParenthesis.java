package input;

public class LhsParenthesis implements Solver {

	public LhsParenthesis() {
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		return 0;
	}

	@Override
	public String getOperation() {
		return "(";
	}

	@Override
	public int getPrecedence() {
		return -1;
	}

	@Override
	public Solver getInverse() {
		return new RhsParenthesis();
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
	}

	@Override
	public Solver createNew() {
		return new LhsParenthesis();
	}

}
