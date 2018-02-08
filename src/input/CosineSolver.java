package input;

public class CosineSolver implements Solver {

	public CosineSolver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		return java.lang.Math.cos(rhs.value);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "cos";
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return 10;
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
		return true;
	}

}
