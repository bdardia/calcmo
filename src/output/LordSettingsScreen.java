package output;

import java.awt.*;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import history.AbidCalculatorScreen;
import history.JasCustomButton;
import history.JasHistoryScreen;
import input.DimitrisAlgebraicNode;
import main.CalcMoMain;

public class LordSettingsScreen extends AbidCalculatorScreen {

	private Graphic background;
	private Button backButton;
	public static int lastScreen;
	
	
	private Button soundONButton;
	private Button soundOFFButton;
	public static boolean soundToggle = true;
	private TextLabel soundArea;
	
	
	private TextBox roundInput;
	private TextLabel roundArea;
	private Button rounderButton;
	public static int roundNumber = 5;
	
	private TextLabel fontSize;
	private Button fontSmall;
	private Button fontLarge;
	
	private Button clearHistory;
	
	private Button radiansButton;
	private Button degreesButton;
	public static boolean radians;
	
	
	public LordSettingsScreen(int width, int height) {
		super(width,height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, "resources/outputscreen.png");
		
		backButton = new Button(20,400,75, 50, "GO BACK", JasCustomButton.getA(), new Action() {
			public void act() {
				if(lastScreen == 0) {
					switchScreen(CalcMoMain.outputScreen);
				}
				if(lastScreen == 1) {
					switchScreen(CalcMoMain.historyScreen);
				}
			}
		});
		
		soundONButton = new Button(20, 450, 75, 50, "ON", JasCustomButton.getA(), new Action() {

			@Override
			public void act() 
			{	
				soundONButton.setBackground(Color.RED);
				soundOFFButton.setBackground(Color.GRAY);
				soundToggle = true;
				
				soundArea.setText("Sound: ON");
			}
		});
		soundOFFButton = new Button(120, 450, 75, 50, "OFF", JasCustomButton.getA(), new Action() {

			@Override
			public void act() 
			{	
				soundONButton.setBackground(Color.GRAY);
				soundOFFButton.setBackground(Color.RED);
				soundToggle = false;
				
				soundArea.setText("Sound: OFF");
			}
		});
		
		soundArea = new TextLabel(37, 37, 400, 37, "Sound: ON");
		
		
		

		roundInput = new TextBox(140, 520, 30, 30, "");
		//asking user how many decimal places they'd like to round to
		rounderButton = new Button(120, 520, 75, 50, "Decimals Rounded: ", JasCustomButton.getA(), new Action() {

			@Override
			public void act() 
			{	
			    int n = Integer.parseInt(roundArea.getText());
				if (n % 1 == 0 && n < 10) {
					n = roundNumber;
					roundArea.setText("Answers will be rounded to " + n + " decimal places");
				}
			}
		});
		roundArea = new TextLabel(37, 67, 400, 37, "Answers will be rounded to 5 decimal places");

//		
//		
//		
//		fontSize = new TextLabel(50,50,50,50,"Font Size:");
//		fontSmall = new Button(60,60,30,15, "Small", new Action() {
//
//			@Override
//			public void act() 
//			{	
//				//set the input area and output area fonts small
//			}
//		});
//		fontLarge = new Button(90,60,30,15, "Large", new Action() {
//
//			@Override
//			public void act() 
//			{	
//				//set the input area and output area fonts large
//			}
//		});
//		
//		
//		
//		clearHistory = new Button(100,100,30,15, "Clear History", new Action() {
//			public void act() {
//				messageArea.setText("History has been cleared!");
//				//in here clear the history
//			}
//		});
//		
//		
//		radiansButton = new Button(200,200,30,15, "Radians", new Action() {
//			public void act() {
//				radiansButton.setBackground(Color.RED);
//				degreesButton.setBackground(Color.GRAY);
//				
//				radians = true;
//				//change the trig functions and convert to degrees by 180/pi
//				
//			}
//		});
//		
//		degreesButton = new Button(250,200,30,15, "Degrees",Color.RED, new Action() {
//				public void act() {
//					degreesButton.setBackground(Color.RED);
//					radiansButton.setBackground(Color.GRAY);
//					
//					radians = false;
//					//use regular methods
//				}
//		});
//		
//		
		viewObjects.add(background);
		viewObjects.add(backButton);
		
		viewObjects.add(soundONButton);
		viewObjects.add(soundOFFButton);
		viewObjects.add(soundArea);
		
		viewObjects.add(roundArea);
		viewObjects.add(roundInput);
		viewObjects.add(rounderButton);
		
//		viewObjects.add(fontSize);
//		viewObjects.add(fontSmall);
//		viewObjects.add(fontLarge);
//		viewObjects.add(clearHistory);
	}
	
	

}
