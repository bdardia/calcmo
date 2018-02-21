package input;

import output.LordAbsSolver;
import output.AdditionSolver;
import output.LordArcCosSolver;
import output.LordArcSinSolver;
import output.LordArcTanSolver;
import output.LordCosineSolver;
import output.DerivativeSolver;
import output.DivisionSolver;
import output.FactorialSolver;
import output.LordLnSolver;
import output.LordLogSolver;
import output.MultiplicationSolver;
import output.LordSineSolver;
import output.SqrRootSolver;
import output.SubtractionSolver;
import output.LordTanSolver;

public class DimitrisAlgebraicNode {
	
	public DimitrisAlgebraicNode lhs;
	public DimitrisAlgebraicNode rhs;
	
	public Solver solver = new DefaultSolver(Solver.PrecedenceConstants.defaultSolver);
	
	public double value;
	public boolean isConstant = false;
	public boolean isEvaluated;
	
	public boolean isPlaceHolder = false; //for urinary funcitons debug print
	
	public String varName;
	public boolean isVariable = false;
	
	public static Solver[] solverArray = {new AdditionSolver(), new MultiplicationSolver(), new DivisionSolver(), new SubtractionSolver(), new LhsParenthesis(), new RhsParenthesis(), 
											new LordCosineSolver(),new Exponent(), 
											new LordSineSolver(), new LordTanSolver(), new LordArcCosSolver(), new LordArcSinSolver(), new LordArcTanSolver(), new LordLogSolver(), new LordLnSolver(), new ParameterSolver(), new LordAbsSolver(),
											//new SqrRootSolver(), new DerivativeSolver(), new FactorialSolver()  //I have no idea which one does not work
											}; 
	
	
	
	
	
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
		}else if(isPlaceHolder) {
			return tabs + "placeHolder"; // a placeholder is a constant, so it must come before.
			//this condition makes print look cooler
		}
		else if(isConstant){
			return tabs + Double.toString(this.value);
		}else {
			String lhsString;
			if(lhs == null) {
				lhsString = tabs + "\t" +  "null";
			}else {
				lhsString = lhs.toString(indentation+1);
			}
			
			String rhsString;
			if(rhs == null) {
				rhsString = tabs + "\t" +  "null";
			}else {
				rhsString = rhs.toString(indentation+1);
			}
			
			
			return tabs + this.solver.getOperation() + "\n" + lhsString + "\n" + rhsString;
			
		}
	}
	
	public String toString() {
		return toString(0);
	}
}
