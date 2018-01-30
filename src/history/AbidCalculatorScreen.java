package history;

import java.util.List;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.Screen;
import main.JasMain;

public abstract class AbidCalculatorScreen extends JasMain implements SwitchScreen{

	private AbidTransitionScreen transitionScreen;
	public AbidCalculatorScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public abstract void initAllObjects(List<Visible> viewObjects);
	
	public void switchScreen(Screen s) {
		setScreen(transitionScreen);
		setScreen(s);
	};

}
