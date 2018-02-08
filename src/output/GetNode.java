package output;

import input.DimitrisAlgebraicNode;

public class GetNode {
	
	
	public void recieveTopNode(DimitrisAlgebraicNode n) {
		n.solve();
		System.out.println(n.value); 
	}
	
	
}
