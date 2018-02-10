package input;

public interface Solver {
	double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs);
	String getOperation();
	int getPrecedence(); //higher number means more important
	void addParent(DimitrisAlgebraicNode n);
	Solver getInverse();
	
	boolean urinaryFunction(); //default is binary function
	
	void increasePrecedence(int amount); //used when handling parenthesis
}
