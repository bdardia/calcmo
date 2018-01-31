package input;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import history.AbidCalculatorScreen;
import history.JasHistoryScreen;
import main.CalcMoMain;

public class BenInputScreen extends AbidCalculatorScreen 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7132035530444379674L;
	public static Graphic background;
	public static Button limButton;
	public static Button derivButton;
	public static Button linsolveButton;
	public static Button quadsolveButton;
	public static Button historyButton;
	public static Button exponentButton;
	
	public BenInputScreen(int width, int height) 
	{
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) 
	{
		background = new Graphic(0, 0, "resources/calcmoscreen.png");
		
		// add 7 to y value
		limButton = new Button(60, 405, 26, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("lim button pressed");
			}
		});
		derivButton = new Button(60, 437, 31, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("deriv button pressed");
			}	
		});
		linsolveButton = new Button(60, 470, 47, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("linsolve button pressed");
			}
		});
		quadsolveButton = new Button(60, 498, 66, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("quadsolve button pressed");
			}
		});
		// 60, 527, 84, 15
		exponentButton = new Button(60, 527, 84, 15, "", new Action( ) {
			
			@Override
			public void act() 
			{
				System.out.println("exponentsolve button pressed");
			}
		});
		historyButton = new Button(62, 623, 44, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				CalcMoMain.main.setScreen(CalcMoMain.historyScreen);
				
			}
		});
		
		viewObjects.add(background);
		viewObjects.add(limButton);
		viewObjects.add(derivButton);
		viewObjects.add(linsolveButton);
		viewObjects.add(quadsolveButton);
		viewObjects.add(exponentButton);
		viewObjects.add(historyButton);
	}

	
}
