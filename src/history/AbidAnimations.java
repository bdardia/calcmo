package history;

import java.util.Random;

import guiTeacher.components.AnimatedComponent;

public class AbidAnimations extends AnimatedComponent{

	public AbidAnimations(int x, int y, int w, int h) {
		super(x, y, w, h);
		randomAnimation();
		Thread go = new Thread(this);
		go.start();
	}
	public void randomAnimation() {
		int  n = (int)(Math.random() * 6)+1;
		if(n == 1) 
			addSequence("resources/beemo-sprite.png",300,20,20,120,120,4);
		if(n == 2)
			addSequence("resources/beemo-sprite.png",300,0,770,130,124,4);
		if(n == 3)
			addSequence("resources/beemo-sprite.png",300,128,528,128,107,4);
		if(n == 4)
			addSequence("resources/beemo-sprite.png",300,128,400,128,112,3);
		if(n == 5)
			addSequence("resources/beemo-sprite.png",300,256,257,128,125,3);
		if(n == 6)
			addSequence("resources/beemo-sprite.png",300,8,642,128,125,3);
	}

}
