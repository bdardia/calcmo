package input;

public class CosineSolver implements Solver {
	int precedence = 10;
	
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
		return precedence;
	}

	@Override
	public void addParent(DimitrisAlgebraicNode n) {

	}

	@Override
	public Solver getInverse() {
		return null;
	}

	@Override
	public boolean urinaryFunction() {
		return true;
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;
		
	}

}
