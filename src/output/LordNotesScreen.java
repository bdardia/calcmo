package output;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import history.AbidCalculatorScreen;
import history.JasCustomButton;
import history.JasHistoryScreen;
import input.BenInputScreen;
import input.DimitrisAlgebraicNode;
import main.CalcMoMain;

public class LordNotesScreen extends AbidCalculatorScreen {

	private Graphic background;
	private Button backButton;
	
	private TextLabel calcNotes;
	
	private Button addNote;
	private TextBox noteArea;
	private TextArea notesDisplay;
	
	private TextBox deleteInput;
	private Button deleteButton;
	
	static List<String> notes = new ArrayList<String>();
	
	//public static ScrollablePane scroll;
	
	public LordNotesScreen(int width, int height) {
		super(width,height);
	}
	
	
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, "resources/outputscreen.png");
		
		backButton = new Button(20,400,75, 50, "GO BACK", JasCustomButton.getA(), new Action() {
			public void act() {
					switchScreen(CalcMoMain.settingsScreen);
			}
		});
		
//		scroll = new ScrollablePane(this, 35, 39, 443, 275);
//		scroll.setBackground(new Color(165, 237, 186));	
		
		calcNotes = new TextLabel(150, 360, 100, 37, "CalcMo Notes");
		
		notesDisplay = new TextArea(37, 37, 400, 300, displayNotes());
		addNote = new Button(100, 400, 100, 37, "Add New Note", JasCustomButton.getA(), new Action() {

			int count = 0;
			@Override
			public void act() 
			{	
				notes.add(noteArea.getText());
				notesDisplay.setText(displayNotes());
//				scroll.removeAll();
//				scroll.addObject(new TextLabel(37, 37, 400, 37, notes.get(count)));	
//				scroll.update();
//				count++;
			}
		});
		
		noteArea = new TextBox(100, 450, 370, 50, "");
		
		deleteInput = new TextBox(395, 500, 30, 30, "");
		
		deleteButton = new Button(310, 500, 85, 30, "DELETE", JasCustomButton.getC(), new Action() {
			public void act() 
			{
				try {
					int n = Integer.parseInt(deleteInput.getText().trim()) - 1;
					if(n < notes.size() && n >= 0) {
						notes.remove(n);
						notesDisplay.setText(displayNotes());
					}
				}
				catch(NumberFormatException e) {
					
				}
			}
		});
		
		
		

		viewObjects.add(background);
		viewObjects.add(backButton);
		viewObjects.add(calcNotes);
	//	viewObjects.add(scroll);
		viewObjects.add(addNote);
		viewObjects.add(noteArea);
		viewObjects.add(notesDisplay);
		viewObjects.add(deleteInput);
		viewObjects.add(deleteButton);

	}
	
	public static String displayNotes() {
		String res = String.join("\n", notes);
		return res;
	}

}
