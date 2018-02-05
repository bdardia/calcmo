package input;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.classfile.Field;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextBox;
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
	public static TextBox variableArea;
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
	public static Button threeButton;
	public static Button fourButton;
	public static Button fiveButton;
	public static Button sixButton;
	public static Button sevenButton;
	public static Button eightButton;
	public static Button nineButton;
	public static Button zeroButton;
	public static Button dotButton;
	public static Button dashButton;
	public static Button normalSolveButton;
	public static Button addVariableButton;
	public static BenSound soundControl;
	public static boolean inputValid;
	public static ArrayList<BenVariableStorage> variables = new ArrayList<BenVariableStorage>();
	
	public BenInputScreen(int width, int height) 
	{
		super(width, height);
		inputValid = false;
	}
	
	// make arraylist for variable entry

	@Override
	public void initAllObjects(List<Visible> viewObjects) 
	{
		soundControl = new BenSound();
		background = new Graphic(0, 0, "resources/calcmoscreen.png");
		inputArea = new TextLabel(37, 37, 400, 37, "");
		variableArea = new TextBox(193, 403, 30, 30, "");
		// usually add 7 to y value
		limButton = new Button(60, 405, 26, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("lim button pressed");
				solverPress();
			}
		});
		derivButton = new Button(60, 437, 31, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("deriv button pressed");
				solverPress();
			}	
		});
		linsolveButton = new Button(60, 475, 47, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "+");
				buttonPress();
			}
		});
		quadsolveButton = new Button(60, 508, 66, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "-");
				buttonPress();
			}
		});
		exponentButton = new Button(60, 537, 84, 15, "", new Action( ) {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "*");
				buttonPress();
			}
		});
		logSolveButton = new Button(60, 569, 57, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "/");
				buttonPress();
			}
		});
		historyButton = new Button(62, 623, 44, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				switchScreen(CalcMoMain.historyScreen);
				switchPress();
			}
		});
		summationButton = new Button(60, 603, 70, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + ";");
				buttonPress();
			}
		});
		// add 42 to x, 32 to y
		oneButton = new Button(278, 385, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "1");
				buttonPress();
			}
		});
		twoButton = new Button(320, 385, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "2");
				buttonPress();
			}
		});
		threeButton = new Button(362, 385, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "3");
				buttonPress();
			}
		});
		fourButton = new Button(278, 417, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "4");
				buttonPress();
			}
		});
		fiveButton = new Button(320, 417, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "5");
				buttonPress();
			}
		});
		sixButton = new Button(362, 417, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "6");
				buttonPress();
			}
		});
		sevenButton = new Button(278, 449, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "7");
				buttonPress();
			}
		});
		eightButton = new Button(320, 449, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "8");
				buttonPress();
			}
		});
		nineButton = new Button(362, 449, 15, 15, "", new Action() {
			
			@Override
			public void act() 
			{
				inputArea.setText(inputArea.getText() + "9");
				buttonPress();
			}
		});
		normalSolveButton = new Button(242, 540, 91, 131, "", new Action() {
			
			@Override
			public void act() 
			{
				System.out.println("normal solve");
				switchScreen(CalcMoMain.outputScreen);
				solverPress();
			}
		});
		addVariableButton = new Button(132, 396, 54, 30, "", new Action() {
			
			@Override
			public void act() 
			{
				String variableName = variableArea.getText().substring(0, 1);
				variables.add(0, new BenVariableStorage(variableName, 0, false));
				inputArea.setText(inputArea.getText() + variableName);
				variableArea.setText("");
				buttonPress();
			}
		});
				
		Thread cleanUp = new Thread(new BenSound());
		Runtime.getRuntime().addShutdownHook(cleanUp);
		
		viewObjects.add(background);
		viewObjects.add(inputArea);
		viewObjects.add(variableArea);
		viewObjects.add(limButton);
		viewObjects.add(derivButton);
		viewObjects.add(linsolveButton);
		viewObjects.add(quadsolveButton);
		viewObjects.add(exponentButton);
		viewObjects.add(historyButton);
		viewObjects.add(logSolveButton);
		viewObjects.add(summationButton);
		viewObjects.add(oneButton);
		viewObjects.add(twoButton);
		viewObjects.add(threeButton);
		viewObjects.add(fourButton);
		viewObjects.add(fiveButton);
		viewObjects.add(sixButton);
		viewObjects.add(sevenButton);
		viewObjects.add(eightButton);
		viewObjects.add(nineButton);
		viewObjects.add(normalSolveButton);
		viewObjects.add(addVariableButton);
	}

	public void buttonPress()
	{
		soundControl.playSound("plop_amplified.wav");
	}

	public void solverPress()
	{
		soundControl.playSound("beeep_distorted.wav");
	}
	
	public void switchPress()
	{
		soundControl.playSound("ping_pong_8bit_peeeeeep.wav");
	}
	
}
