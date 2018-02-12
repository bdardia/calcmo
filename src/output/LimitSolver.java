package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class LimitSolver implements Solver {

	int precedence = Solver.PrecedenceConstants.limitSolver;
	
	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		if(limit == 0) {
			return ;
		}
		return java.lang.Math.sin(rhs.value);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "limit";
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
		return new LimitSolver();
	}

	@Override
	public boolean urinaryFunction() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void increasePrecedence(int amount) {
		// TODO Auto-generated method stub
		
	}

}
