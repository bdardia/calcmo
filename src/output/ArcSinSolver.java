package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class ArcSinSolver implements Solver {

	int precedence = Solver.PrecedenceConstants.arcsinSolver;
	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		return java.lang.Math.asin(rhs.value);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "arcsin";
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return precedence;
	}

	@Override
	public Solver getInverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solver createNew() {
		// TODO Auto-generated method stub
		return new ArcSinSolver();
	}

	@Override
	public boolean urinaryFunction() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;

	}
}