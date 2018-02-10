package input;

public class ExampleSolver implements Solver {

	public ExampleSolver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getOperation() {
		return "NAO"; //not an operation
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addParent(DimitrisAlgebraicNode n) {
		// TODO Auto-generated method stub

	}

	@Override
	public Solver getInverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean urinaryFunction() {
		// TODO Auto-generated method stub
		return false;
	}

}
