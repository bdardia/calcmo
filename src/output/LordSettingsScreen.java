package output;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import input.BenSound;
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
	private Graphic soundLabel;
	
	
	private TextBox roundInput;
	private TextLabel roundArea;
	private Button rounderButton;
	public static int roundNumber = 5;
	
	private Button radiansButton;
	private Button degreesButton;
	public static boolean radians;
	private TextLabel modeArea;
	
	static Thread counter = new Thread();
	private TextLabel clock;
	
	private Button notesButton;
	
	
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
				if(lastScreen == 2) {
					switchScreen(CalcMoMain.inputScreen);
				}
			}
		});
		
		soundLabel = new Graphic(180, 400, 50,50,"resources/sound.png");
				
		soundONButton = new Button(120, 450, 75, 50, "ON", JasCustomButton.getA(), new Action() {

			@Override
			public void act() 
			{	
				soundToggle = true;
				
				soundArea.setText("Sound: ON");
			}
		});
		soundOFFButton = new Button(220, 450, 75, 50, "OFF", JasCustomButton.getA(), new Action() {

			@Override
			public void act() 
			{	
				soundToggle = false;
				
				soundArea.setText("Sound: OFF");
			}
		});
		
		soundArea = new TextLabel(37, 37, 400, 37, "Sound: ON");
		
		
		

		roundInput = new TextBox(280, 520, 30, 30, "");
		//asking user how many decimal places they'd like to round to
		rounderButton = new Button(120, 520, 150, 50, "Decimals Rounded: ", JasCustomButton.getA(), new Action() {

			@Override
			public void act() 
			{	
				try {
					int n = Integer.parseInt(roundInput.getText().trim());
				
					if(n < 11 && n % 1 == 0) {
						roundArea.setText("Answers will be rounded to " + n + " decimal places");
						roundNumber = n;
					}
				
				}
				catch(NumberFormatException e) {
					
				}
			}
		});
		roundArea = new TextLabel(37, 67, 400, 37, "Answers will be rounded to 5 decimal places");
		
		
		radiansButton = new Button(120,590,90,50, "Radians",JasCustomButton.getB(), new Action() {
			public void act() {
				
				modeArea.setText("Mode: Radians");
				
				radians = true;
				//change the trig functions and convert to degrees by 180/pi
				
			}
		});
		
		degreesButton = new Button(210,590,90,50, "Degrees",JasCustomButton.getC(), new Action() {
				public void act() {
					
					modeArea.setText("Mode: Degrees");
					
					radians = false;
					//use regular methods
				}
		});
		
		modeArea = new TextLabel(37, 97, 400, 37, "Mode: Degrees");

		
		
		clock = new TextLabel(37, 300, 400, 37, "Clock: " + time());
		
		boolean time = true;
		Thread counter = new Thread(new Runnable(){
			public void run() {
				while(time) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					clock.setText("Clock: " + time());;
					}
			}
		});
		counter.start();
		
		
		notesButton = new Button(320,400,75, 50, "NOTES", JasCustomButton.getC(), new Action() {
			public void act() {
					switchScreen(CalcMoMain.notesScreen);
			}
		});


		viewObjects.add(background);
		viewObjects.add(backButton);
		
		viewObjects.add(soundONButton);
		viewObjects.add(soundOFFButton);
		viewObjects.add(soundArea);
		viewObjects.add(soundLabel);
		
		viewObjects.add(roundArea);
		viewObjects.add(roundInput);
		viewObjects.add(rounderButton);
		
		viewObjects.add(radiansButton);
		viewObjects.add(degreesButton);
		viewObjects.add(modeArea);
		
		viewObjects.add(clock);
		
		viewObjects.add(notesButton);

		
	}
	
	public static String time() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd    HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	//change sound ?

	

}
