package history;

import java.awt.Color;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import input.BenInputScreen;
import main.CalcMoMain;

public class JasHistoryScreen extends AbidCalculatorScreen {
	
	public static ArrayList<AbedHistoryNode> fx;
	
	public JasHistoryScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		JasCustomButton.setFont("resources//font.ttf");
		fx = new ArrayList<AbedHistoryNode>();
		new ArrayList<Button>();
		
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/histMO.png"));
		
		Button goInput = new Button(250, 575, 75, 50, "GO BACK", JasCustomButton.getA(), new Action() {
			
			public void act() {
				switchScreen(CalcMoMain.inputScreen);
			}
		});
		JasCustomButton.circleButton(goInput);
		viewObjects.add(goInput);
		
		Button clear = new Button(375, 515, 93, 45, "CLEAR", JasCustomButton.getB(), new Action() {

			public void act() {
				clearHist(fx);
				update();
			}
		});
		viewObjects.add(clear);
		
		ScrollablePane scroll = new ScrollablePane(this, 35, 39, 443, 275);
		scroll.setBackground(new Color(165, 237, 186));	
		for(int i = 0; i < fx.size(); i++){
			
			String in = fx.get(i).getInput();
			String out = fx.get(i).getOutput();
			
			scroll.addObject(new Button(5, yCo(i, true), 100, 25, i + ": " + in, new Action() {

				public void act() {
					BenInputScreen.inputArea.setText(in);
					switchScreen(CalcMoMain.inputScreen);
				}
			}));	
			
			scroll.addObject(new Button(35, yCo(i, false), 100, 25, out, new Action() {

				public void act() {
					BenInputScreen.inputArea.setText(out);
					switchScreen(CalcMoMain.inputScreen);
				}
			}));
		}
		
		scroll.update();
		
		viewObjects.add(scroll);	
		
		TextBox deleteArea = new TextBox(435, 600, 30, 30, "");
		viewObjects.add(deleteArea);
		
		Button delete = new Button(350, 600, 85, 30, "DELETE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				fx.remove(Integer.parseInt(deleteArea.getText()));
				deleteArea.setText("");
				update();
			}
		});
		viewObjects.add(delete);
		
		TextBox duplicateArea = new TextBox(435, 635, 30, 30, "");
		viewObjects.add(duplicateArea);
		
		Button duplicate = new Button(350, 635, 85, 30, "DUPLICATE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				fx.remove(Integer.parseInt(duplicateArea.getText()));
				duplicateArea.setText("");
				update();
			}
		});
		viewObjects.add(duplicate);
		
		TextBox tableArea = new TextBox(435, 565, 30, 30, "");
		viewObjects.add(tableArea);
		
		Button table = new Button(350, 565, 85, 30, "TABLE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				//function selected goes to table screen and displays table
			}
		});
		viewObjects.add(table);
	}
	
	public void clearHist(ArrayList<AbedHistoryNode> arr) {
		arr.clear();
		update();
	}
	
	public int yCo(int x, boolean in) {
		if(in) {
			return 30 * (x-1) + 10;
		}
		return 30 * (x-1) + 25;
	}
	
	public void remove(ArrayList<AbedHistoryNode> arr, int x) {
		arr.remove(x);
	}
	
	public void duplicate(ArrayList<AbedHistoryNode> arr, int x) {
		arr.add(arr.get(x));
	}
}
