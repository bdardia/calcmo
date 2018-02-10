package input;

public class VariableSolver implements Solver {

	private DimitrisAlgebraicNode node;
	private int precedence = Solver.PrecedenceConstants.variableSolver;
	
	public VariableSolver(DimitrisAlgebraicNode n) {
		node = n;
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		return node.value;
	}

	@Override
	public String getOperation() {
		return node.varName;
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public Solver getInverse() {
		return null;
	}

	@Override
	public void addParent(DimitrisAlgebraicNode n) {
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += 20;
	}

	@Override
	public Solver createNew() {
		return null; //never called, all vars are new
	}

}
