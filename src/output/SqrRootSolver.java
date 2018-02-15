package output;

import input.DimitrisAlgebraicNode;
import input.Solver;


//need to make a button for this
public class SqrRootSolver implements Solver {
	
	int precedence = Solver.PrecedenceConstants.sqrrootSolver;
	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		return java.lang.Math.sqrt(rhs.value);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "sqrroot";
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
		return new SqrRootSolver();
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
