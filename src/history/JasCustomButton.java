package history;

import java.awt.Color;

import guiTeacher.components.*;

public abstract class JasCustomButton extends Button {
	
	private static Color a = new Color(153, 217, 234);
	private static Color b = new Color(241, 75, 84);
	private static Color c = new Color(111, 119, 217);
	
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

	public static Color getA() {
		return a;
	}

	public static Color getB() {
		return b;
	}

	public static Color getC() {
		return c;
	}
}
