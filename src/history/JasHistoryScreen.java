package history;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import main.JasMainScreen;

public class JasHistoryScreen extends FullFunctionScreen {

	public JasHistoryScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/histMO.png"));
		
		Button goInput = new Button(150, 625, 130, 40, "Go Back", new Color(63, 72, 204), new Action() {
			
			public void act() {
				JasMainScreen.main.setScreen(JasMainScreen.inputScreen);
			}
		});
		viewObjects.add(goInput);
		
		//circle - shape
		Button select = new Button(375, 615, 93, 45,"Select", new Color(237, 28, 36), new Action() {
			//should take the function clicked on by the user, return to the input screen, and enter the function as an input
			public void act() {
				
			}
		});
		viewObjects.add(select);
		
		//triangle - shape
		Button clear = new Button(375, 515, 93, 45, "Clear", new Color(153, 217, 234), new Action() {
			//should clear the history(remove all items from arraylist) and update screen
			public void act() {
				
			}
		});
		viewObjects.add(clear);
		
		ScrollablePane scroll = new ScrollablePane(this, 35, 39, 443, 275);
		scroll.setBorderWidth(3);
		for(int i=0; i < 10; i++){
			
			scroll.addObject(new TextLabel(5,30*i,100,25,"Label "+(i+1)));
		}
		scroll.update();
		
		viewObjects.add(scroll);
		 
		
		//need dpad to scroll (left right does nothing)(up down scrolls the scrollpane)
	}

}
