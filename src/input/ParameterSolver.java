package input;

import java.util.ArrayList;

public class ParameterSolver implements Solver {
	
	int precedence = Solver.PrecedenceConstants.parameterSolver;

	public ParameterSolver() {
	}
	
	
	public static ArrayList<DimitrisAlgebraicNode> getParameterList(DimitrisAlgebraicNode node){
		ArrayList<DimitrisAlgebraicNode> paramList = new ArrayList<DimitrisAlgebraicNode>();
		if(node.solver instanceof ParameterSolver) {
			paramList.add(node.lhs);
			paramList.addAll(getParameterList(node.rhs));
		}
		else {
			paramList.add(node);
		}
		return paramList;
	}

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		return 0;
	}

	@Override
	public String getOperation() {
		return ",";
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public Solver getInverse() {
		return null;
	}

	@Override
	public Solver createNew() {
		return new ParameterSolver();
	}

	@Override
	public boolean urinaryFunction() {
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
		precedence += amount;
	}

}
