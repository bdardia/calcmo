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
	public void addParent(DimitrisAlgebraicNode n) {
	}

	@Override
	public Solver getInverse() {
		return new RhsParenthesis();
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

}
