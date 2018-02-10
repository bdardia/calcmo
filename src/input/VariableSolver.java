package input;

public class VariableSolver implements Solver {

	private DimitrisAlgebraicNode node;
	
	public VariableSolver(DimitrisAlgebraicNode n) {
		node = n;
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		return node.value;
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return node.varName;
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return 20;
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

}
