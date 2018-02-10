package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class SubtractionSolver implements Solver{

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		// TODO Auto-generated method stub
		lhs.solve();
		rhs.solve();
		return lhs.value - rhs.value;
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "-";
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Solver getInverse() {
		// TODO Auto-generated method stub
		return new AdditionSolver();
	}

	@Override
	public void addParent(DimitrisAlgebraicNode n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean urinaryFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
