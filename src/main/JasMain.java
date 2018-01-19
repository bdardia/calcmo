package main;

import guiTeacher.GUIApplication;
import history.JasHistoryScreen;
import input.BenInputScreen;
import output.OutputScreen;


public class JasMain extends GUIApplication {
	
	public static JasMain main;
	public static JasHistoryScreen historyScreen;
	public static BenInputScreen inputScreen;
	public static OutputScreen outputScreen;

	public JasMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		historyScreen = new JasHistoryScreen(getWidth(), getHeight());
		inputScreen = new BenInputScreen(getWidth(), getHeight());
		outputScreen = new OutputScreen(getWidth(), getHeight());
		setScreen(inputScreen);
	}

	public static void main(String[] args) {
		main = new JasMain(518, 696);
		Thread runner = new Thread(main);
		runner.start();
	}

}
