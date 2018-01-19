package history;

import guiTeacher.components.AnimatedComponent;

public class Animations extends AnimatedComponent{

	public Animations(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		//happy walking addSequence("resources/beemo-sprite.png",110,20,20,120,120,4);
		//blowing up addSequence("resources/beemo-sprite.png",200,0,770,130,124,4);
		//playing video games addSequence("resources/beemo-sprite.png",200,128,528,128,107,4);
		
		Thread go = new Thread(this);
		go.start();
	}

}
