package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class LogSolver implements Solver {

	int precedence = Solver.PrecedenceConstants.logSolver;
	
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		lhs.solve();
		rhs.solve();
		
		double base = lhs.value;
		double argument = rhs.value;
		
		return java.lang.Math.log(argument)/java.lang.Math.log(base);
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "log";
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
		return new LogSolver();
	}

	@Override
	public boolean urinaryFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;

	}

}
