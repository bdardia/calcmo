package output;

import input.DimitrisAlgebraicNode;
import input.MultiplicationSolver;
import input.Solver;

public class Parenthesis implements Solver {

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		// TODO Auto-generated method stub
		return lhs.solveNode() / rhs.solveNode();
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
		return new MultiplicationSolver();
	}

	@Override
	public void addParent(DimitrisAlgebraicNode n) {
		// TODO Auto-generated method stub
		
	}
	
}



// trig type (when input is trig funcitons)
// normal (integer type, polynomial )

// based on what it returns whatever
//and a method will solve based on the type returned 