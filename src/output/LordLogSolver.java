package output;

import java.util.ArrayList;

import input.DimitrisAlgebraicNode;
import input.ParameterSolver;
import input.Solver;

public class LordLogSolver implements Solver {

	int precedence = Solver.PrecedenceConstants.logSolver;
	
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		ArrayList<DimitrisAlgebraicNode> paramList = ParameterSolver.getParameterList(rhs);
		
		DimitrisAlgebraicNode base = paramList.get(0);
		DimitrisAlgebraicNode argument = paramList.get(1);
		
		base.solve();
		argument.solve();
		 
		
		return java.lang.Math.log(argument.value)/java.lang.Math.log(base.value);
		
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
		return new LordLogSolver();
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
