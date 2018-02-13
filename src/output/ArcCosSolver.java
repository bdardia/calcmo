package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class ArcCosSolver implements Solver {

	int precedence = Solver.PrecedenceConstants.arccosSolver;
	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		return java.lang.Math.acos(rhs.value);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "arccos";
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
		return new ArcCosSolver();
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
