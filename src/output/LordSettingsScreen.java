package output;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import history.AbidCalculatorScreen;
import history.JasCustomButton;
import history.JasHistoryScreen;
import input.DimitrisAlgebraicNode;
import main.CalcMoMain;

public abstract class LordSettingsScreen extends AbidCalculatorScreen {

	private Graphic background;
	private Button backButton;
	private Button soundButton;
	public static JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 40, 10);
	
	public LordSettingsScreen(int width, int height) {
		super(width,height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, "resources/outputscreen.png");
		
		
		
		
		
		add(slider);
		
		viewObjects.add(background);
		viewObjects.add(backButton);
		viewObjects.add(soundButton);
	}
	
	/* public static void main(String[] args) {
		  final JFrame frame = new JFrame("JSlider Demo");
		
		
		  slider.setMinorTickSpacing(5);
		  slider.setMajorTickSpacing(20);
		  slider.setPaintTicks(true);
		  slider.setPaintLabels(true);
		  slider.setLabelTable(slider.createStandardLabels(10));
		
		  
		  frame.setLayout(new FlowLayout());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(300, 200);
		  frame.getContentPane().add(slider);
		  frame.setVisible(true);
	}
	*/

}
