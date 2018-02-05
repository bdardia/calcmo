package output;

import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import history.AbidCalculatorScreen;
import history.JasHistoryScreen;
import main.CalcMoMain;

public class OutputScreen extends AbidCalculatorScreen {
	
	/*
	
	private Button addButton;
	private Button subtractButton;
	private Button multiplyButton;
	private Button divideButton;
	private Button enterButton;
	
	private Button sinButton;
	private Button cosButton;
	private Button tanButton;
	private Button arcsinButton;
	private Button arccosButton;
	private Button arctanButton;
	
	
	private Button eButton;
	private Button piButton;
	private Button xButton;
	private Button powerButton;
	private Button percentButton;
	private Button negativeButton;
	private Button openParenthesisButton;
	private Button closeParenthesisButton;
	private Button decimalButton;
	private Button lnButton;
	private Button logButton;
	
	*/
	
	private Graphic background;
	
	private Button inputButton;
	
	private Button historyButton;
	
	private Button tableButton;
	

	
	public OutputScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
/*
		addButton = new Button(100, 100, 100, 100, "ADD");
		
		subtractButton = new Button();
		
		multiplyButton = new Button();
		
		divideButton = new Button();
		
		enterButton = new Button();
		
		sinButton = new Button(100, 100, 100, 100, "ADD");
	
		cosButton = new Button(100, 100, 100, 100, "ADD");
		
		addButton = new Button(100, 100, 100, 100, "ADD");
		
		addButton = new Button(100, 100, 100, 100, "ADD");
		
		
		
		
*/		
		
		background = new Graphic(0, 0, "resources/blankface.png");
		
		inputButton = new Button(100, 100, 100, 100, "GO BACK TO INPUT", new Action() {
			public void act() {
				
				switchScreen(CalcMoMain.inputScreen);
				
				System.out.println("Input button pressed");
			}
		});
		
		historyButton = new Button(200, 100, 100, 100, "GO TO HISTORY", new Action() {
			public void act() {
				
				switchScreen(CalcMoMain.historyScreen);
				
				System.out.println("History button pressed");
			}
		});
		
		tableButton = new Button(300, 100, 100, 100, "GO TO TABLE", new Action() {
			public void act() {
				
				//switchScreen(CalcMoMain.tableScreen);
				
				System.out.println("Table button pressed");
			}
		});
		viewObjects.add(background);
		
		viewObjects.add(inputButton);
		viewObjects.add(historyButton);
		viewObjects.add(tableButton);
	}

}
