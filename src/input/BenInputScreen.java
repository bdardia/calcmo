package input;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import history.AbidCalculatorScreen;
import main.CalcMoMain;

public class BenInputScreen extends AbidCalculatorScreen 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7132035530444379674L;
	public static Graphic background;
	public static TextLabel inputArea;
	public static TextLabel currentArea;
	public static Button limButton;
	public static Button derivButton;
	public static Button linsolveButton;
	public static Button quadsolveButton;
	public static Button historyButton;
	public static Button exponentButton;
	public static Button logSolveButton;
	public static Button summationButton;
	public static Button oneButton;
	public static Button twoButton;
	public static Button normalSolveButton;
	public static ArrayList<BenVariableStorage> variables;
	
	public BenInputScreen(int width, int height) 
	{
		super(width, height);
	}
	
	// make arraylist for variable entry

	@Override
	public void initAllObjects(List<Visible> viewObjects) 
	{
		background = new Graphic(0, 0, "resources/calcmoscreen.png");
		inputArea = new TextLabel(37, 37, 400, 37, "");
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
		exponentButton = new Button(60, 527, 84, 15, "", new Action( ) {
			
			@Override
			public void act() 
			{
				System.out.println("exponentsolve button pressed");
			}
		});
		logSolveButton = new Button(60, 559, 57, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("logsolve button pressed");
			}
		});
		historyButton = new Button(62, 623, 44, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				switchScreen(CalcMoMain.historyScreen);
			}
		});
		summationButton = new Button(60, 598, 70, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("summation button pressed");
			}
		});
		oneButton = new Button(278, 385, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "1");
			}
		});
		twoButton = new Button(318, 385, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "1");
			}
		});
		normalSolveButton = new Button(240, 540, 91, 131, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("normal solve");
			}
		});
				
		Thread cleanUp = new Thread(new BenSound());
		Runtime.getRuntime().addShutdownHook(cleanUp);
		
		viewObjects.add(background);
		viewObjects.add(inputArea);
		viewObjects.add(limButton);
		viewObjects.add(derivButton);
		viewObjects.add(linsolveButton);
		viewObjects.add(quadsolveButton);
		viewObjects.add(exponentButton);
		viewObjects.add(historyButton);
		viewObjects.add(logSolveButton);
		viewObjects.add(summationButton);
		viewObjects.add(oneButton);
		viewObjects.add(normalSolveButton);
	}



	
}
