package history;

import java.awt.Color;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import input.BenInputScreen;
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
		
		Button goInput = new Button(250, 575, 75, 50, "Go Back", new Color(237, 28, 36), new Action() {
			
			public void act() {
				switchScreen(CalcMoMain.inputScreen);
			}
		});
		JasCustomButton.circleButton(goInput);
		viewObjects.add(goInput);
				
		//triangle - shape
		Button clear = new Button(375, 515, 93, 45, "Clear", new Color(153, 217, 234), new Action() {

			public void act() {
				clearHist(fx);
				clearPane(hist);
				update();
			}
		});
		viewObjects.add(clear);
		
		ScrollablePane scroll = new ScrollablePane(this, 35, 39, 443, 275);
		scroll.setBackground(new Color(165, 237, 186));	
		for(int i = 0; i < fx.size(); i++){
			
			String in = fx.get(i).getInput();
			String out = fx.get(i).getOutput();
			
			scroll.addObject(new Button(5, 30 * i + 10, 100, 25, in, new Action() {

				public void act() {
					BenInputScreen.inputArea.setText(in);
					switchScreen(CalcMoMain.inputScreen);
				}
			}));	
			
			scroll.addObject(new Button(35, 30 * i + 25, 100, 25, out, new Action() {

				public void act() {
					BenInputScreen.inputArea.setText(out);
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
