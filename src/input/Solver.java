package input;

public interface Solver {
	double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs);
	String getOperation();
	int getPrecedence(); //higher number means more important
	Solver getInverse();
	
	void addParent(DimitrisAlgebraicNode n);
}
