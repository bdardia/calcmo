package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class AbsSolver implements Solver {

int precedence = Solver.PrecedenceConstants.absSolver;
	
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		
		if(rhs.value < 1) {
			return rhs.value * -1;
		}
		return rhs.value;
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "abs";
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
		return new AbsSolver();
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
