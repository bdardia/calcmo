package input;

public class RhsParenthesis implements Solver {

	public RhsParenthesis() {
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		return 0;
	}

	@Override
	public String getOperation() {
		return ")";
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

		return new LhsParenthesis();
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
		// TODO Auto-generated method stub
		
	}

}
