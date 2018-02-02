package history;

import java.util.ArrayList;

public class AbedUtilities
{
	public boolean search(ArrayList<AbedHistoryNode> h,String t)
	{
		for(int i = 0; i < h.size();i++)
		{
			if(h.get(i).equals(t))
			{
				return true;
			}
		}
		return false; 
	}
	public ArrayList<AbedHistoryNode> sort(ArrayList<AbedHistoryNode> a)
	{
		
		return a;
	}
}
