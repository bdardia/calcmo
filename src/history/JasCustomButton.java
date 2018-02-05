package history;

import java.awt.Color;

import guiTeacher.components.*;
import guiTeacher.components.Button;

public abstract class JasCustomButton extends Button {

	public JasCustomButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}
	
	public JasCustomButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
	}
	
	public static void circleButton(Button b){
		b.setDimensions(b.getWidth(), b.getWidth());
		b.setCurve(90, 90);
	}
	
	//public static void triangleButton(Button b) {}
	
}
