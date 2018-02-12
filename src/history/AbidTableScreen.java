package history;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;

public class AbidTableScreen extends AbidCalculatorScreen{

	public AbidTableScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/outputScreen.png"));
	}
}
