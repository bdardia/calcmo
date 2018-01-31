package input;

public class DimitrisAlgebraicNode {
	
	public DimitrisAlgebraicNode lhs;
	public DimitrisAlgebraicNode rhs;
	
	public Solver solver;
	
	private double value;
	public boolean isEvaluated;
	
	public String varName;
	public boolean isVariable;
	
	public static Solver[] solverArray; //set up in main
	
	
	
	
	
	public DimitrisAlgebraicNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs){
		this.lhs = lhs;
		this.rhs = rhs;
		this.isEvaluated = false;
	}
	
	public DimitrisAlgebraicNode(double value){
		this.value = value;
		this.isEvaluated = true;
	}
	
	public DimitrisAlgebraicNode(String varName) {
		isVariable = true;
		this.varName = varName;
	}
	
	
	DimitrisAlgebraicNode getLhs(){
		return lhs;
	}
	
	DimitrisAlgebraicNode getRhs(){
		return rhs;
	}
	
	void addSolver(Solver s){
		solver = s;
	}
	
	void Solve() {
		this.value = solver.solveNode(lhs, rhs);
	}
	
	public static void main(String[] args) {
		DimitrisAlgebraicNode test = new DimitrisAlgebraicNode(10.0);
	}
}
