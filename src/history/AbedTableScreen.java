package history;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import input.BenInputScreen;
import main.CalcMoMain;

public class AbedTableScreen extends AbidCalculatorScreen
{
	public static ScrollablePane scroll;
	public static ArrayList<AbedHistoryNode> dummyList = new ArrayList<AbedHistoryNode>();
	
	public AbedTableScreen(int width, int height) 
	{
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	public void initAllObjects(List<Visible> viewObjects) 
	{
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/outputScreen.png"));

		scroll = new ScrollablePane(this, 35, 39, 443, 275);
		scroll.setBackground(new Color(165, 237, 186));	
		
		Button goInput = new Button(250, 575, 75, 50, "GO BACK", JasCustomButton.getA(), new Action() 
		{
			
			public void act() 
			{
				
				switchScreen(CalcMoMain.inputScreen);
			}
		});
		JasCustomButton.circleButton(goInput);
		viewObjects.add(goInput);
		Button clear = new Button(375, 515, 93, 45, "CLEAR", JasCustomButton.getB(), new Action() 
		{

			public void act() 
			{
				clearAll();
			
			}
		});
		viewObjects.add(clear);
		viewObjects.add(scroll);
		TextBox input = new TextBox(40, 440, 50, 50,"");
		Button insert = new Button(90,440,55,30,"INSERT",JasCustomButton.getB(),new Action() 
		{
			
			@Override
			public void act() 
			{
				AbedTableBackEnd.inputs.add(input.getText());
				//System.out.println("adding to inputs:" + AbedTableBackEnd.inputs.get(AbedTableBackEnd.inputs.size()-1));
				input.clear();
			}
		});
		viewObjects.add(insert);
		viewObjects.add(input);
		TextBox functionInput = new TextBox(40,380,50,50,"ENTER");
		Button functionSubmit = new Button(90,380,55,30,"Submit", JasCustomButton.getA(), new Action() {
			
			@Override
			public void act() 
			{
				AbedTableBackEnd.function = functionInput.getText();
				System.out.println(AbedTableBackEnd.function);
			}
		});
		Button compile  = new Button(175,575,75,50,"Comp",JasCustomButton.getB(),new Action() 
		{
			
			@Override
			public void act() 
			{
				scroll.removeAll();
				AbedTableBackEnd.createOutputs();
				refill();
				scroll.update();
				
				
				
			}
		
		});
		
		
		JasCustomButton.circleButton(compile);
		viewObjects.add(functionInput);
		viewObjects.add(functionSubmit);
		viewObjects.add(compile);
	}
	public String modString(ArrayList<AbedHistoryNode> a , int x)
	{
		String coord = "";
		coord = Double.toString(a.get(x).getIn()) + ": " + Double.toString(a.get(x).getput()); 
		return coord;
	}
	public void refill()
	{
		scroll.removeAll();
		scroll.update();
		for(int i = 0; i < AbedTableBackEnd.coordinates.size();i++)
		{
			dummyList.add(AbedTableBackEnd.coordinates.get(i));
			System.out.println(dummyList.get(i).getIn());
			System.out.println(dummyList.get(i).getput());
		}
		for(int i = 0; i < dummyList.size();i++)
		{
			scroll.addObject(new TextArea(30, (30 * i) + 30 , 89, 89, modString(dummyList,i)));
		}
		dummyList.clear();
		AbedTableBackEnd.coordinates.clear();
		scroll.update();
		
		
		
	}
	public void clearAll()
	{	
		AbedTableBackEnd.inputs.clear();
		AbedTableBackEnd.functionalInputs.clear();
		AbedTableBackEnd.outputs.clear();
		AbedTableBackEnd.coordinates.clear();
		scroll.removeAll();
		scroll.update();
		
		
	}
}
