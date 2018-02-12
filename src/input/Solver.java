package input;

public interface Solver {
	public static class PrecedenceConstants {

		public PrecedenceConstants() {
			// TODO Auto-generated constructor stub
		}
		
		public static int constantSolver = 40;
		public static int variableSolver = 40;
		
		public static int defaultSolver = -1; //this is used in algebraic node;
		
		//urinary functions >= 30
		public static int cosineSolver = 30;
		public static int sineSolver = 30;
		public static int tanSolver = 30;
		public static int arccosSolver = 30;
		public static int arcsinSolver = 30;
		public static int arctanSolver = 30;
		
		//binary functions >=10
		public static int exponentSolver = 6;
		public static int multiplicationSolver = 4;
		public static int additionSolver = 2;
		public static int subtractionSolver = 2;
		

	}

	double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs);
	String getOperation();
	int getPrecedence(); //higher number means more important
	
	Solver getInverse();
	Solver createNew();
	
	boolean urinaryFunction(); //default is binary function
	
	void increasePrecedence(int amount); //used when handling parenthesis
	
}
