package history;

import java.util.ArrayList;

public interface AbedHistoryTransfer 
{
	 //this is used to pass the history instance around 
	void transferNode(AbedHistoryNode a, ArrayList<AbedHistoryNode> s);
	
}
