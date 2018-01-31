package history;

import java.util.List;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import main.CalcMoMain;

public abstract class AbidCalculatorScreen extends FullFunctionScreen implements SwitchScreen{

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
