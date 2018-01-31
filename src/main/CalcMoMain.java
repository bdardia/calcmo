package main;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;
import history.AbidTransitionScreen;
import history.JasHistoryScreen;
import history.SwitchScreen;
import input.BenInputScreen;
import output.OutputScreen;


public class CalcMoMain extends GUIApplication implements SwitchScreen{
	
	public static CalcMoMain main;
	public static JasHistoryScreen historyScreen;
	public static BenInputScreen inputScreen;
	public static OutputScreen outputScreen;
	public static AbidTransitionScreen transitionScreen;

	public CalcMoMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		historyScreen = new JasHistoryScreen(getWidth(), getHeight());
		inputScreen = new BenInputScreen(getWidth(), getHeight());
		outputScreen = new OutputScreen(getWidth(), getHeight());
		transitionScreen = new AbidTransitionScreen(getWidth(),getHeight());
		setScreen(inputScreen);
	}

	public static void main(String[] args) {
		main = new CalcMoMain(518, 696);
		Thread runner = new Thread(main);
		runner.start();
	}

	@Override
	public void switchScreen(FullFunctionScreen s) {
		// TODO Auto-generated method stub
		
	}

}
