package output;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import history.AbedHistoryNode;
import history.AbidCalculatorScreen;
import history.JasCustomButton;
import history.JasHistoryScreen;
import input.DimitrisAlgebraicNode;
import main.CalcMoMain;

public class AchillesOutputScreen extends AbidCalculatorScreen {
	
	private Graphic background;
	private Button inputButton;
	private Button historyButton;
	private Button tableButton;
	private Button settingsButton;
	private static TextLabel outputArea;
	
	public static ArrayList<AbedHistoryNode> unfinishedNodes = new ArrayList<AbedHistoryNode>();

	
	public static double output;
	
	
	public AchillesOutputScreen(int width, int height) {
		super(width, height);
	}
	
	//Lord Crawford
	public static void recieveTopNode(DimitrisAlgebraicNode n) {
		n.solve();
		System.out.println(n.value); 
		
		
		double rounder = Math.pow(10, LordSettingsScreen.roundNumber);
		output = Math.round (n.value * rounder) / rounder; ;
		outputArea.setText(outputArea.getText() + output);
		
		
		
		unfinishedNodes.get(unfinishedNodes.size()-1).setOut(output);
		JasHistoryScreen.fx.add(unfinishedNodes.get(unfinishedNodes.size()-1));
		System.out.print(JasHistoryScreen.fx.get(JasHistoryScreen.fx.size()-1));
	}
	
	

	public void initAllObjects(List<Visible> viewObjects) {

		
		background = new Graphic(0, 0, "resources/outputscreen.png");
		
		outputArea = new TextLabel(37, 37, 400, 37, "Answer: ");
		
		inputButton = new Button(100, 400, 100, 100, "Initial Screen", JasCustomButton.getA(), new Action() {
			public void act() {
				
				switchScreen(CalcMoMain.inputScreen);
				
				System.out.println("Input button pressed");
				outputArea.setText("Answer: ");
			}
		});
		JasCustomButton.circleButton(inputButton);
		
		historyButton = new Button(200, 400, 100, 100, "History", JasCustomButton.getB(), new Action() {
			public void act() {
				
				CalcMoMain.historyScreen.populateScroll();

				switchScreen(CalcMoMain.historyScreen);
				
				System.out.println("History button pressed");
				outputArea.setText("Answer: ");
			}
		});
		JasCustomButton.circleButton(historyButton);
		
		tableButton = new Button(300, 400, 100, 100, "Table", JasCustomButton.getC(), new Action() {
			public void act() {
				
				//CalcMoMain.tableScreen.fillScroll();
				switchScreen(CalcMoMain.tableScreen);
				
				System.out.println("Table button pressed");
				outputArea.setText("Answer: ");
			}
		});
		JasCustomButton.circleButton(tableButton);
		
		
		settingsButton = new Button(200, 500, 100, 100, "Settings", JasCustomButton.getB(), new Action() {
			public void act() {
				
				switchScreen(CalcMoMain.settingsScreen);
				
				System.out.println("Settings button pressed");
				outputArea.setText("Answer: ");
				
				LordSettingsScreen.lastScreen = 0;
			}
		});
		
		viewObjects.add(background);
		viewObjects.add(outputArea);
		
		viewObjects.add(inputButton);
		viewObjects.add(historyButton);
		viewObjects.add(tableButton);
		viewObjects.add(settingsButton);
	}

}