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
		
		
		//allows the user to return to the input screen
		
		Button goInput = new Button(250, 575, 75, 50, "GO BACK", JasCustomButton.getA(), new Action() {
			
			public void act() {
				BenInputScreen.inputArea.setText("");
				switchScreen(CalcMoMain.inputScreen);
			}
		});
		JasCustomButton.circleButton(goInput);
		viewObjects.add(goInput);
		
		
		//clears the arraylist
		
		Button clear = new Button(375, 515, 93, 45, "CLEAR", JasCustomButton.getB(), new Action() {

			public void act() {
				clearHist(fx);
				update();
			}
		});
		viewObjects.add(clear);
		
		
		//area where the inputs and the outputs get displayed
		
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
		
		
		//allows the user to delete an input to clean up the history
		
		TextBox deleteArea = new TextBox(435, 600, 30, 30, "");
		viewObjects.add(deleteArea);
		
		Button delete = new Button(350, 600, 85, 30, "DELETE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				fx.remove(getElement(deleteArea));
				deleteArea.setText("");
				update();
			}
		});
		viewObjects.add(delete);
		
		
		//allows the user to move an input down to the list so it is easier for them to utilize for other inputs
		
		TextBox duplicateArea = new TextBox(435, 635, 30, 30, "");
		viewObjects.add(duplicateArea);
		
		Button duplicate = new Button(350, 635, 85, 30, "DUPLICATE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				fx.add(getElement(duplicateArea));
				duplicateArea.setText("");
				update();
			}
		});
		viewObjects.add(duplicate);
		
		
		//allows the user to select an input and make a table of it
		
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
			return 30 * (x-1) + 30;
		}
		return 30 * (x-1) + 45;
	}
	
	public AbedHistoryNode getElement(TextBox x) {
		return fx.get(Integer.parseInt(x.getText()));
	}
}






/*
 * 
 * package history;

import java.awt.Color;
import java.util.*;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import input.BenInputScreen;
import main.CalcMoMain;

public class JasDemoScreen extends AbidCalculatorScreen {
	
	public ArrayList<String> fx;
	public static int o;
	
	public JasDemoScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		JasCustomButton.setFont("resources//font.ttf");
		new ArrayList<Button>();
		createfx();
		pupulatefx(fx);
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/histMO.png"));
		
		
		//allows the user to return to the input screen
		
		Button goInput = new Button(250, 575, 75, 50, "GO BACK", JasCustomButton.getA(), new Action() {
			
			public void act() {
				BenInputScreen.inputArea.setText("");
				switchScreen(CalcMoMain.inputScreen);
			}
		});
		JasCustomButton.circleButton(goInput);
		viewObjects.add(goInput);
		
		
		//clears the arraylist
		
		Button clear = new Button(375, 515, 93, 45, "CLEAR", JasCustomButton.getB(), new Action() {

			public void act() {
				clearHist(fx);
				setO(getO()+1);
				update();
			}
		});
		viewObjects.add(clear);
		
		
		//area where the inputs and the outputs get displayed
		
		ScrollablePane scroll = new ScrollablePane(this, 35, 39, 443, 275);
		scroll.setBackground(new Color(165, 237, 186));	
		for(int i = 0; i < fx.size(); i++){
			
			String in = fx.get(i);
			
			scroll.addObject(new Button(5, yCo(i, true), 100, 25, i + ": " + in, new Action() {

				public void act() {
					BenInputScreen.inputArea.setText(in);
					switchScreen(CalcMoMain.inputScreen);
				}
			}));	
			
		}
		
		scroll.update();
		
		viewObjects.add(scroll);	
		
		
		//allows the user to delete an input to clean up the history
		
		TextBox deleteArea = new TextBox(435, 600, 30, 30, "");
		viewObjects.add(deleteArea);
		
		Button delete = new Button(350, 600, 85, 30, "DELETE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				fx.remove(getElement(deleteArea));
				deleteArea.setText("");
				update();
			}
		});
		viewObjects.add(delete);
		
		
		//allows the user to move an input down to the list so it is easier for them to utilize for other inputs
		
		TextBox duplicateArea = new TextBox(435, 635, 30, 30, "");
		viewObjects.add(duplicateArea);
		
		Button duplicate = new Button(350, 635, 85, 30, "DUPLICATE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				fx.add(getElement(duplicateArea));
				duplicateArea.setText("");
				update();
			}
		});
		viewObjects.add(duplicate);
		
		
		//allows the user to select an input and make a table of it
		
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
	
	private void createfx() {
		if(getO() == 0) {
		fx = new ArrayList<String>();
	}}

	private void pupulatefx(ArrayList<String> x) {
		if(getO() == 0) {
		for(int j = 0; j < 10; j++) {
			x.add("2 + 0");
		}}
	}

	public void clearHist(ArrayList<String> fx) {
		fx.clear();
		update();
	}
	
	public int yCo(int x, boolean in) {
		if(in) {
			return 30 * (x-1) + 30;
		}
		return 30 * (x-1) + 45;
	}
	
	public String getElement(TextBox x) {
		return fx.get(Integer.parseInt(x.getText()));
	}

	public static int getO() {
		return o;
	}

	public static void setO(int o) {
		JasDemoScreen.o = o;
	}
}
*/
