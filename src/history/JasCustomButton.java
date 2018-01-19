package history;

import guiTeacher.components.*;
import guiTeacher.components.Button;

public abstract class JasCustomButton extends Button {

	public JasCustomButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}
	
	public static void circleButton(Button b){
		b.setCurve(90, 90);
	}
	
	public static void triangleButton(Button b) {

	}
	
}
