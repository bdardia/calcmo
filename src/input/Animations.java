package input;

import guiTeacher.components.AnimatedComponent;

public class Animations extends AnimatedComponent{

	public Animations(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		addSequence("resources/beemo-sprite.png",110,25,20,85,105,3);
		
		Thread go = new Thread(this);
		go.start();
	}

}
