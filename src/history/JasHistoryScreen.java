package history;

import java.awt.Color;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import input.BenInputScreen;
import main.CalcMoMain;

public class JasHistoryScreen extends AbidCalculatorScreen {
	
	public ScrollablePane scroll;
	public static ArrayList<AbedHistoryNode> fx =  new ArrayList<AbedHistoryNode>();
	
	public JasHistoryScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		JasCustomButton.setFont("resources//font.ttf");
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
				scroll.update();
			}
		});
		viewObjects.add(clear);
		scroll = new ScrollablePane(this, 35, 39, 443, 275);
		scroll.setBackground(new Color(165, 237, 186));	
		populateScroll();
		viewObjects.add(scroll);	
		
		TextBox deleteArea = new TextBox(435, 600, 30, 30, "");
		viewObjects.add(deleteArea);
		
		Button delete = new Button(350, 600, 85, 30, "DELETE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				deleteHist(fx, Integer.parseInt(deleteArea.getText()));
				deleteArea.setText("");
				scroll.update();
			}
		});
		viewObjects.add(delete);
		
		TextBox duplicateArea = new TextBox(435, 635, 30, 30, "");
		viewObjects.add(duplicateArea);
		
		Button duplicate = new Button(350, 635, 85, 30, "DUPLICATE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				duplicateHist(fx, Integer.parseInt(duplicateArea.getText()));
				duplicateArea.setText("");
				scroll.update();
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
	
	public void populateScroll() {
		scroll.removeAll();
		for(int i = 0; i < fx.size(); i++){
			
			String in = fx.get(i).getInput();
			System.out.println(in);
			String out = Double.toString(fx.get(i).getOut());
			
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
	}

	public void clearHist(ArrayList<AbedHistoryNode> arr) {
		arr.clear();
		scroll.removeAll();
	}
	
	public void deleteHist(ArrayList<AbedHistoryNode> arr, int x) {
		arr.remove(x);
		populateScroll();
	}
	
	public void duplicateHist(ArrayList<AbedHistoryNode> arr, int x) {
		arr.add(arr.get(x));
		populateScroll();
	}
	
	public int yCo(int x, boolean in) {
		if(in) {
			return 30 * (x) + 10;
		}
		return 30 * (x) + 25;
	}
	
	public void remove(ArrayList<AbedHistoryNode> arr, int x) {
		arr.remove(x);
	}
	
	public void duplicate(ArrayList<AbedHistoryNode> arr, int x) {
		arr.add(arr.get(x));
	}
}
