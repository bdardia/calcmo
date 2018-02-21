package output;

import java.util.ArrayList;

import input.DimitrisAlgebraicNode;
import input.Solver;

public class AchillesLimitsSolver implements Solver {

	public static ArrayList<Double> values = new ArrayList<Double>();
	
	public AchillesLimitsSolver() {
		
	}
	
	

	@Override
	public double solveNode(DimitrisAlgebraicNode lhs, DimitrisAlgebraicNode rhs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Solver getInverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solver createNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean urinaryFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void increasePrecedence(int amount) {
		// TODO Auto-generated method stub
		
	}
	
	public static void createBounds(double x) {
		double upper = x * 1.001;
		double lower = x * 0.999;
		
		ArrayList[] values;
	}
	

}
