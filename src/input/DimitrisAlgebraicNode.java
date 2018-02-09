package input;

import output.*;

public class DimitrisAlgebraicNode {
	
	public DimitrisAlgebraicNode lhs;
	public DimitrisAlgebraicNode rhs;
	
	public Solver solver;
	
	public double value;
	public boolean isConstant = false;
	public boolean isEvaluated;
	
	public String varName;
	public boolean isVariable = false;
	
	public static Solver[] solverArray = {new AdditionSolver(), new MultiplicationSolver(), new DivisionSolver(), new SubtractionSolver()}; //set up in main
	
	
	
	
	
	public DimitrisAlgebraicNode(Solver s){
		this.solver = s;
	}
	
	public DimitrisAlgebraicNode(double value){
		this.value = value;
		this.isEvaluated = true;
		this.isConstant = true;
		
		this.solver = new ConstantSolver(this);
	}
	
	public DimitrisAlgebraicNode(String varName) {
		isVariable = true;
		this.varName = varName;
		this.solver = new VariableSolver(this);
	}
	
	
	
	public void solve() {
		this.value = solver.solveNode(lhs, rhs);
	}


	public String toString(int indentation) {
		String tabs = "";
		for(int i = 0; i < indentation; i++) {
			tabs += "\t";
		}
		
		
		if(isVariable) {
			return tabs + this.varName;
		}else if(isConstant){
			return tabs + Double.toString(this.value);
		}else {
			return tabs + this.solver.getOperation() + "\n" + lhs.toString(indentation+1) + "\n" + rhs.toString(indentation+1);
			
		}
	}
}
