package main;

import guiTeacher.GUIApplication;
import history.AbidTableScreen;
import history.AbidTransitionScreen;
import history.JasHistoryScreen;
import input.BenInputScreen;
import output.OutputScreen;


public class CalcMoMain extends GUIApplication{
	
	public static CalcMoMain main;
	public static JasHistoryScreen historyScreen;
	public static BenInputScreen inputScreen;
	public static OutputScreen outputScreen;
	public static AbidTransitionScreen transitionScreen;
	public static AbidTableScreen tableScreen;

	public CalcMoMain(int width, int height) {
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
		main = new CalcMoMain(518, 696);
		Thread runner = new Thread(main);
		runner.start();
	}
}
