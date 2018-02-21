package main;

import guiTeacher.GUIApplication;
import history.AbedTableScreen;
import history.AbidTransitionScreen;
import history.JasHistoryScreen;
import input.BenInputScreen;
import output.LordSettingsScreen;
import output.AchillesOutputScreen;
import output.LordNotesScreen;


public class CalcMoMain extends GUIApplication{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static CalcMoMain main;
	public static JasHistoryScreen historyScreen;
	public static BenInputScreen inputScreen;
	public static AchillesOutputScreen outputScreen;
	public static AbidTransitionScreen transitionScreen;
	public static AbedTableScreen tableScreen;
	public static LordSettingsScreen settingsScreen;
	public static LordNotesScreen notesScreen;

	public CalcMoMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		historyScreen = new JasHistoryScreen(getWidth(), getHeight());
		inputScreen = new BenInputScreen(getWidth(), getHeight());
		outputScreen = new AchillesOutputScreen(getWidth(), getHeight());
		tableScreen = new AbedTableScreen(getWidth(), getHeight());
		settingsScreen = new LordSettingsScreen(getWidth(), getHeight());
		notesScreen = new LordNotesScreen(getWidth(), getHeight());
		
		setScreen(inputScreen);
	}

	public static void main(String[] args) {
		main = new CalcMoMain(518, 696);
		Thread runner = new Thread(main);
		runner.start();
	}
}