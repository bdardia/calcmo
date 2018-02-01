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

	
}
