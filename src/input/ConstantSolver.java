package input;

public class ConstantSolver implements Solver {

	public ConstantSolver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		// TODO Auto-generated method stub
		return (Double) null; //should not be called
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return ""; //the empty string will never match and never thow a null pointer exeption
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public Solver getInverse() {
		// TODO Auto-generated method stub
		return null; //there should never be an inverse
	}

}
