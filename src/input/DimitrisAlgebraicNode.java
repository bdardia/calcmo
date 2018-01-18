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
	
	
	
	
	
	
}
