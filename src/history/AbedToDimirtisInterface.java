package history;

import java.util.ArrayList;

public interface AbedToDimirtisInterface
{	
	///Create an instance and fill in the node with ur respective info
	AbedHistoryNode createNode(String input,String output);
	///send the node to lord/ achillies 
	AbedHistoryNode transfer(AbedHistoryNode a);
}
