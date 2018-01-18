package main;

import guiTeacher.GUIApplication;
import history.JasHistoryScreen;
import input.InputScreen;
import output.OutputScreen;


public class JasMain extends GUIApplication {
	
	public static JasMain main;
	public static JasHistoryScreen historyScreen;
	public static InputScreen inputScreen;
	public static OutputScreen outputScreen;

	public JasMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		historyScreen = new JasHistoryScreen(getWidth(), getHeight());
		inputScreen = new InputScreen(getWidth(), getHeight());
		outputScreen = new OutputScreen(getWidth(), getHeight());
		setScreen(historyScreen);
	}

	public static void main(String[] args) {
		main = new JasMain(800, 500);
		Thread runner = new Thread(main);
		runner.start();
	}

}
