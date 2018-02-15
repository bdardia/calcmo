package history;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import input.BenInputScreen;
import main.CalcMoMain;

public class AbedTableScreen extends AbidCalculatorScreen
{
		
	
	public AbedTableScreen(int width, int height) 
	{
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	public void initAllObjects(List<Visible> viewObjects) 
	{
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/outputScreen.png"));

		ScrollablePane scroll = new ScrollablePane(this, 35, 39, 443, 275);
		scroll.setBackground(new Color(165, 237, 186));	
		
		Button goInput = new Button(250, 575, 75, 50, "GO BACK", JasCustomButton.getA(), new Action() 
		{
			
			public void act() 
			{
				
				switchScreen(CalcMoMain.inputScreen);
			}
		});
		JasCustomButton.circleButton(goInput);
		viewObjects.add(goInput);
		Button clear = new Button(375, 515, 93, 45, "CLEAR", JasCustomButton.getB(), new Action() 
		{

			public void act() 
			{
				
				scroll.update();
			}
		});
		TextBox deleteArea = new TextBox(435, 600, 30, 30, "");
		viewObjects.add(deleteArea);
		Button delete = new Button(350, 600, 85, 30, "DELETE", JasCustomButton.getC(), new Action() 
		{
			public void act() 
			{
				deleteArea.setText("");
				scroll.update();
			}
		});
		viewObjects.add(delete);
		viewObjects.add(clear);
		viewObjects.add(scroll);
		TextBox input = new TextBox(200, 600, 50, 50, "");
		Button insert = new Button(150,600,30,30,"INSERT",JasCustomButton.getB(),new Action() 
		{
			
			@Override
			public void act() 
			{
				AbedTableBackEnd.inputs.add(input.getText());
			}
		});
		viewObjects.add(insert);
		viewObjects.add(input);
		
		TextBox functionInput = new TextBox(30,30,30,30,"");
		Button functionSubmit = new Button(140,300,50,50,"", JasCustomButton.getA(), new Action() {
	
			@Override
			public void act() 
			{
				AbedTableBackEnd.function = functionInput.getText();
			}
		});
		Button compile  = new Button(150,500,30,30,"SUBMIT",JasCustomButton.getB(),new Action() 
		{
			
			@Override
			public void act() 
			{
				AbedTableBackEnd.createOutputs();
				
			}
		});
		
		viewObjects.add(functionSubmit);
		viewObjects.add(compile);
		viewObjects.add(functionInput);
		
	}
}

