package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class LnSolver implements Solver {

	int precedence = Solver.PrecedenceConstants.lnSolver;
	
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		return java.lang.Math.log(rhs.value);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "ln";
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
		return new LnSolver();
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
