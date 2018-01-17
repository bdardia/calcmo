package input;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class Sound extends JFrame
{

	public Sound() 
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setTitle("Test Sound Clip");
	      this.setSize(300, 200);
	      this.setVisible(true);       
	      try {
	         // Open an audio input stream.           
	          File beep = new File(""); //you could also get the sound file with an URL
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(beep);              
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}

}
