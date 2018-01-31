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
		AbidTransitionScreen tt = new AbidTransitionScreen(getWidth(), getHeight());
		tt.s = s;
		Thread t = new Thread(tt);
		t.start();
		CalcMoMain.main.setScreen(s);
	}
}
