package output;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class FactorialSolver implements Solver {

	//need to make factorial button for ben
int precedence = Solver.PrecedenceConstants.factorialSolver;
	
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		rhs.solve();
		if(rhs.value % 1 == 0) {
			return factorial(rhs.value);
		}
		return 0;
	}
	
	public double factorial(double n){    
		if (n == 0)    
			return 1;    
		else    
			return(n * factorial(n-1));    
	}    
	public String getOperation() {
		// TODO Auto-generated method stub
		return "factorial";
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
		return new FactorialSolver();
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
