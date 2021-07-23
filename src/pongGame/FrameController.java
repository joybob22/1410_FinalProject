package pongGame;

import java.awt.EventQueue;

/**
 * 
 * @author braydenlemke
 *
 */

public class FrameController {
	//Immediately instantiate the title frame because that is our first frame
	TitleFrame1 titleFrame;
	
	//All other frames would need to be declared here.
	//That way there is one class that holds all the instances of our frames
	GameFrame gameFrame;
	
	public void startTitleScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					titleFrame = new TitleFrame1();
					titleFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		TitleFrame1.main(null);
	}
	
	//This method sets the visibility to the title frame to false.
	//It then declares the gameFrame. Later it will instead move to
	//the frame where the users input their names.
	public void TitleFrameToStartFrame() {
		titleFrame.destroy();
		gameFrame = new GameFrame();
	}
}
