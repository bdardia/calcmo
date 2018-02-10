package input;

public class ConstantSolver implements Solver {
	DimitrisAlgebraicNode parent;
	int precedence = 20;
	
	public ConstantSolver(DimitrisAlgebraicNode self) {
		parent = self;
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		return parent.value; 
	}

	@Override
	public String getOperation() {
		return ""; //the empty string will never match and never thow a null pointer exeption
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public Solver getInverse() {
		return null; //there should never be an inverse
	}

	@Override
	public void addParent(DimitrisAlgebraicNode n) {
		parent = n;
		
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
