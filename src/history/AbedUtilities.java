package history;

import java.util.ArrayList;

public class AbedUtilities
{
	public boolean search(ArrayList<AbedHistoryNode> h,String t)
	{
		for(int i = 0; i < h.size();i++)
		{
			if(h.get(i).print().get(0).equals(t))
			{
				return true;
			}
		}
		return false; 
	}
	
}
