package input;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.*;
import javax.swing.*;

public class BenSound extends JFrame implements Runnable
{

	public static ArrayList<BenVariableStorage> variables = new ArrayList<BenVariableStorage>();
	
	public BenSound() 
	{
		
	}
	
	public void run()
	{
		try {
			// 300000 + (int)(Math.random() * ((1200000 - 300000) + 1))
			Thread.sleep(300000 + (int)(Math.random() * ((1200000 - 300000) + 1)));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true)
		{
			
			double rand = Math.random();
			while (rand > .05)
			{
				if (Math.random() > 0.4)
				   {
					   try {
					         // Open an audio input stream.           
					          File plop = new File("resources/plop_amplified.wav");
					          AudioInputStream audioIn = AudioSystem.getAudioInputStream(plop);              
					         // Get a sound clip resource.
					         Clip clip = AudioSystem.getClip();
					         // Open audio clip and load samples from the audio input stream.
					         clip.open(audioIn);
					         FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					         gainControl.setValue(6.0f);
					         clip.start();
					         try {
								Thread.sleep(200 + (int)(Math.random() * ((600 - 200) + 1)));
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					      } catch (UnsupportedAudioFileException e) {
					         e.printStackTrace();
					      } catch (IOException e) {
					         e.printStackTrace();
					      } catch (LineUnavailableException e) {
					         e.printStackTrace();
					      }
				   }
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      this.setTitle("Test Sound Clip");
			      this.setSize(300, 200);
			      this.setVisible(false);       
			      try {
			         // Open an audio input stream.           
			          File beep = new File("resources/beeep_distorted.wav"); //you could also get the sound file with an URL
			          AudioInputStream audioIn = AudioSystem.getAudioInputStream(beep);              
			         // Get a sound clip resource.
			         Clip clip = AudioSystem.getClip();
			         // Open audio clip and load samples from the audio input stream.
			         clip.open(audioIn);
			         FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			         gainControl.setValue(6.0f);
			         clip.start();
			         try {
						Thread.sleep(600 + (int)(Math.random() * ((1200 - 600) + 1)));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      } catch (UnsupportedAudioFileException e) {
			         e.printStackTrace();
			      } catch (IOException e) {
			         e.printStackTrace();
			      } catch (LineUnavailableException e) {
			         e.printStackTrace();
			      }
			   rand = Math.random();
			   
			}    
		      try {
		         // Open an audio input stream.           
		          File peep = new File("resources/ping_pong_8bit_peeeeeep.wav");
		         AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(peep);              
		         // Get a sound clip resource.
		         Clip clip2 = AudioSystem.getClip();
		         // Open audio clip and load samples from the audio input stream.
		         clip2.open(audioIn2);
		         FloatControl gainControl = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
		         gainControl.setValue(6.0f);
		         clip2.start();
		         try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
		}
		
		
	}
	
	public static final void main(String[] args)
	{
		BenSound pong = new BenSound();
	}

}
