package history;

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
		
		//#3f48cc - color		rectangle - shape
		Button goInput = new Button(234, 684, 130, 40,"Go Back",new Action() {
			
			public void act() {
				JasMainScreen.main.setScreen(JasMainScreen.inputScreen);
			}
		});
		viewObjects.add(goInput);
		
		//#ed1c24 - color		circle - shape
		Button select = new Button(438, 684, 93, 7,"Select",new Action() {
			//should take the function clicked on by the user, return to the input screen, and enter the function as an input
			public void act() {
				
			}
		});
		viewObjects.add(select);
		
		//#99d9ea - color		triangle - shape
		Button clear = new Button(234, 684, 130, 40,"Clear",new Action() {
			//should clear the history(remove all items from arraylist) and update screen
			public void act() {
				
			}
		});
		viewObjects.add(clear);
		
		//need scrollpane
			//look as sampler orcmath
		 
		
		//need dpad to scroll (left right does nothing)(up down scrolls the scrollpane)
	}

}
