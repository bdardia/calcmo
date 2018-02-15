package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class ArcTanSolver implements Solver {

	int precedence = Solver.PrecedenceConstants.arctanSolver;
	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		return java.lang.Math.atan(rhs.value);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "arctan";
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
		return new ArcTanSolver();
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