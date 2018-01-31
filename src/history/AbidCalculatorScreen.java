package history;

import java.util.List;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import main.CalcMoMain;

public abstract class AbidCalculatorScreen extends FullFunctionScreen{
	
	public AbidCalculatorScreen(int width, int height) {
		super(width, height);
	}

	public abstract void initAllObjects(List<Visible> viewObjects);
	
	public void switchScreen(AbidCalculatorScreen s) {
		CalcMoMain.main.setScreen(new AbidTransitionScreen(getWidth(),getHeight()));
		CalcMoMain.main.setScreen(s);
	}


}
