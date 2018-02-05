package input;

import output.*;

public class DimitrisAlgebraicNode {
	
	public DimitrisAlgebraicNode lhs;
	public DimitrisAlgebraicNode rhs;
	
	public Solver solver;
	
	private double value;
	public boolean isEvaluated;
	
	public String varName;
	public boolean isVariable;
	
	public static Solver[] solverArray = {new AdditionSolver(), new MultiplicationSolver(), new DivisionSolver()}; //set up in main
	
	
	
	
	
	public DimitrisAlgebraicNode(Solver s){
		this.solver = s;
	}
	
	public DimitrisAlgebraicNode(double value){
		this.value = value;
		this.isEvaluated = true;
	}
	
	public DimitrisAlgebraicNode(String varName) {
		isVariable = true;
		this.varName = varName;
	}
	
	
	
	void Solve() {
		this.value = solver.solveNode(lhs, rhs);
	}
	
	public static void main(String[] args) {
		DimitrisAlgebraicNode test = new DimitrisAlgebraicNode(10.0);
	}

	public int solveNode() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString(int indentation) {
		String tabs = "";
		for(int i = 0; i < indentation; i++) {
			tabs += "\t";
		}
		
		
		if(isVariable) {
			return tabs + Double.toString(this.value) + "\n" + lhs.toString(indentation+1) + "\n" + rhs.toString(indentation+1);
		}else {
			return tabs + this.solver.getOperation();
		}
	}
}
