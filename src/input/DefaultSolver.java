package input;

public class DefaultSolver implements Solver {
	private int precedence;
	
	public DefaultSolver(int precedence) {
		this.precedence = precedence;
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		return 0;
	}

	@Override
	public String getOperation() {
		return "NAO"; //not an operation
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
		return false; //keep false unless you like segfaults --> check NodeBuilder, a new DefaultSolver is created for each unary function
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;
		
	}

	@Override
	public Solver createNew() {
		return new DefaultSolver(Solver.PrecedenceConstants.defaultSolver);
	}

}
