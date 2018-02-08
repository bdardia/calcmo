package output;

import java.awt.Color;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import history.AbidCalculatorScreen;
import history.JasCustomButton;
import history.JasHistoryScreen;
import input.DimitrisAlgebraicNode;
import main.CalcMoMain;

public class OutputScreen extends AbidCalculatorScreen {
	
	private Graphic background;
	private Button inputButton;
	private Button historyButton;
	private Button tableButton;
	private TextLabel outputArea;

	public double output;
	
	
	public OutputScreen(int width, int height) {
		super(width, height);
	}
	
	
	public void recieveTopNode(DimitrisAlgebraicNode n) {
		n.solve();
		System.out.println(n.value); 
		
		output = n.value;
	}

	public void initAllObjects(List<Visible> viewObjects) {

		
		background = new Graphic(0, 0, "resources/outputscreen.png");
		
		inputButton = new Button(100, 400, 100, 100, "Initial Screen", JasCustomButton.getA(), new Action() {
			public void act() {
				
				switchScreen(CalcMoMain.inputScreen);
				
				System.out.println("Input button pressed");
			}
		});
		JasCustomButton.circleButton(inputButton);
		
		historyButton = new Button(200, 400, 100, 100, "History", JasCustomButton.getB(), new Action() {
			public void act() {
				
				switchScreen(CalcMoMain.historyScreen);
				
				System.out.println("History button pressed");
			}
		});
		JasCustomButton.circleButton(historyButton);
		
		tableButton = new Button(300, 400, 100, 100, "Table", JasCustomButton.getC(), new Action() {
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
