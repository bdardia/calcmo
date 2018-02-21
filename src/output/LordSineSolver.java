package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class LordSineSolver implements Solver {
	
	public static boolean inversesin;
	int precedence = Solver.PrecedenceConstants.sineSolver;
	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		if(inversesin) {
			return 1/(java.lang.Math.sin(rhs.value));
		}
		return java.lang.Math.sin(rhs.value);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "sin";
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
		return new LordSineSolver();
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
