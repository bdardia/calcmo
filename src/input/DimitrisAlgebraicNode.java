package input;

public abstract class DimitrisAlgebraicNode {
	
	public DimitrisAlgebraicNode lhs;
	public DimitrisAlgebraicNode rhs;
	
	public double value;
	public boolean isEvaluated;
	
	DimitrisAlgebraicNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs){
		this.lhs = lhs;
		this.rhs = rhs;
		this.isEvaluated = false;
	}
	
	DimitrisAlgebraicNode(double value){
		this.value = value;
		this.isEvaluated = true;
	}
	
	
	DimitrisAlgebraicNode getLhs(){
		return lhs;
	}
	
	DimitrisAlgebraicNode getRhs(){
		return rhs;
	}
	
	void Solve(Solver s){
		s.SolveNode(lhs, rhs);
	}
	
	void ExtractOperation() {
		
	}
	
	int getOperation() {
		return 0;
	}
}
