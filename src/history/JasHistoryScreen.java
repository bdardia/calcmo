package history;

import java.awt.Color;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import main.CalcMoMain;

public class JasHistoryScreen extends AbidCalculatorScreen {
	
	private ArrayList<AbedHistoryNode> fx;
	private ArrayList<Button> hist;

	public JasHistoryScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		
		fx = new ArrayList<AbedHistoryNode>();
		hist = new ArrayList<Button>();
		
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/histMO.png"));
		
		Button goInput = new Button(150, 625, 130, 40, "Go Back", new Color(63, 72, 204), new Action() {
			
			public void act() {
				switchScreen(CalcMoMain.inputScreen);
			}
		});
		viewObjects.add(goInput);
		
		Button select = new Button(375, 575, 85, 85,"Select", new Color(237, 28, 36), new Action() {
			//should take the function clicked on by the user, return to the input screen, and enter the function as an input
			public void act() {
				
			}
		});
		JasCustomButton.circleButton(select);
		viewObjects.add(select);
		
		//triangle - shape
		Button clear = new Button(375, 515, 93, 45, "Clear", new Color(153, 217, 234), new Action() {

			public void act() {
				clearHist(fx);
				clearPane(hist);
				update();
			}
		});
		viewObjects.add(clear);
		
		//make the array list all button so when the user clicks on it, it will return to the input screen with the function entered
		ScrollablePane scroll = new ScrollablePane(this, 35, 39, 443, 275);
		scroll.setBackground(new Color(165, 237, 186));	
		for(int i = 0; i < fx.size(); i++){
			
			scroll.addObject(new Button(5,30*i,100,25,fx.get(i).getInput(), new Action() {

				public void act() {
					switchScreen(CalcMoMain.inputScreen);
				}
			}));	
			
			scroll.addObject(new Button(35,30*i,100,25,fx.get(i).getOutput(), new Action() {

				public void act() {
					switchScreen(CalcMoMain.inputScreen);
				}
			}));
		}
		scroll.update();
		
		viewObjects.add(scroll);	
	}
	
	public void clearHist(ArrayList<AbedHistoryNode> arr) {
		arr.clear();
		arr.trimToSize();
	}
	
	public void clearPane(ArrayList<Button> arr) {
		arr.clear();
		arr.trimToSize();
	}
}
