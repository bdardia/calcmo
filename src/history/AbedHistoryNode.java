package history;

import java.util.ArrayList;

public class AbedHistoryNode 
{
	private Double in;
	private Double put;
	private String input;
	private String output;
	private ArrayList<String> xCoordinate;
	private ArrayList<String> yCoordinate;
	private AbidAnimations animate;
	private int count;
	private double out;

	public AbedHistoryNode(String input,String output)
	{
		this.input = input;
		this.output = output;
	}
	public AbedHistoryNode(String input,double out)
	{
		this.input = input;
		this.out = out;
	}
	public AbedHistoryNode(String input, ArrayList<String> xCoordinate,ArrayList<String> yCoordinate)
	{
		this.input = input;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	public AbedHistoryNode(int count,AbidAnimations animate)
	{
		this.count = count;
		this.animate = animate;
	}
	
	public AbedHistoryNode(Double input,Double Output)
	{
		this.in = input;
		this.put = Output;
	}
	
	public String getInput()
	{
		return input;
	}
	
	public void setInput(String input) 
	{
		this.input = input;
	}
	
	public String getOutput() 
	{
		return output;
	}
	
	public void setOutput(String output)
	{
		this.output = output;
	}
	public void setOut(double out)
	{
		this.out = out;
	}
	public double getOut()
	{
		return out;
	}
	public Double getPut()
	{
		return put;
	}
	public Double getIn()
	{
		return in;
	}
	
	
}
