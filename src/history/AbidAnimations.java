package history;

import java.util.Random;

import guiTeacher.components.AnimatedComponent;

public class AbidAnimations extends AnimatedComponent{

	public AbidAnimations(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		Thread go = new Thread(this);
		go.start();
	}
	public void randomAnimation() {
		Random rand = new Random();
		int  n = rand.nextInt(3) + 1;
		if(n == 1) 
			addSequence("resources/beemo-sprite.png",110,20,20,120,120,4);
		if(n == 2)
			addSequence("resources/beemo-sprite.png",200,0,770,130,124,4);
		if(n == 3)
			addSequence("resources/beemo-sprite.png",200,128,528,128,107,4);
	}

}
