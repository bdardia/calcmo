package output;

import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import history.AbidCalculatorScreen;

public abstract class LordSettingsScreen extends AbidCalculatorScreen {

	private Graphic background;
	private Button backButton;
	
	
	public LordSettingsScreen(int width, int height) {
		super(width,height);
	}

}
