package output;

import java.awt.Color;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import history.AbidCalculatorScreen;
import history.JasCustomButton;
import history.JasHistoryScreen;
import main.CalcMoMain;

public class OutputScreen extends AbidCalculatorScreen {
	
	
	
	private Graphic background;
	
	private Button inputButton;
	
	private Button historyButton;
	
	private Button tableButton;
	

	
	public OutputScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {

		
		background = new Graphic(0, 0, "resources/outputscreen.png");
		
		inputButton = new Button(100, 400, 100, 100, "Initial Screen", Color.RED, new Action() {
			public void act() {
				
				switchScreen(CalcMoMain.inputScreen);
				
				System.out.println("Input button pressed");
			}
		});
		JasCustomButton.circleButton(inputButton);
		
		historyButton = new Button(200, 400, 100, 100, "History", Color.BLUE, new Action() {
			public void act() {
				
				switchScreen(CalcMoMain.historyScreen);
				
				System.out.println("History button pressed");
			}
		});
		JasCustomButton.circleButton(historyButton);
		
		tableButton = new Button(300, 400, 100, 100, "Table", Color.GRAY, new Action() {
			public void act() {
				
				//switchScreen(CalcMoMain.tableScreen);
				
				System.out.println("Table button pressed");
			}
		});
		JasCustomButton.circleButton(tableButton);
		
		viewObjects.add(background);
		
		viewObjects.add(inputButton);
		viewObjects.add(historyButton);
		viewObjects.add(tableButton);
	}

}
