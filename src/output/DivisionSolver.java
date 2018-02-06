package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class DivisionSolver implements Solver {

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		// TODO Auto-generated method stub
		return lhs.solveNode() / rhs.solveNode();
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return "/";
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Solver getInverse() {
		// TODO Auto-generated method stub
		return new MultiplicationSolver();
	}

	@Override
	public void addParent(DimitrisAlgebraicNode n) {
		// TODO Auto-generated method stub
		
	}

}
