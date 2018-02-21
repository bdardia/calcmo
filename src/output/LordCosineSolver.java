package output;

import input.DimitrisAlgebraicNode;
import input.Solver;
import input.Solver.PrecedenceConstants;

public class LordCosineSolver implements Solver {
	int precedence = Solver.PrecedenceConstants.cosineSolver;
	
	public static boolean inversecos = false;
	
	public LordCosineSolver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		
		if(inversecos) {
			if(LordSettingsScreen.radians) {
				return 1/(java.lang.Math.cos(Math.toRadians(rhs.value)));
			}
			return 1/(java.lang.Math.cos(rhs.value));
		}
		if(LordSettingsScreen.radians) {
			return java.lang.Math.cos(Math.toRadians(rhs.value));
		}
		return java.lang.Math.cos(rhs.value);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "cos";
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
	public boolean urinaryFunction() {
		return true;
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;
		
	}

	@Override
	public Solver createNew() {
		return new LordCosineSolver();
	}

}