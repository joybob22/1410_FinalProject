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
	RestartFrame restartFrame;
	
	//All other frames would need to be declared here.
	//That way there is one class that holds all the instances of our frames
	GameFrame gameFrame;
	
	public void startTitleScreen() {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
	
	public void RestartFrameToStartFrame() {
		restartFrame.destroy();
		gameFrame = new GameFrame();
	}
	
	/**
	 * Determine if any of the scores are a high score.
	 * If so then open the high score frame to enter the users name.
	 * 
	 * If there is no high score then simply pull up the restart screen.
	 */
	
	public void endGame(int score1, int score2) {
		
		//Determine if either score is a high score.
		
		
		//This code is to be run if there is no high score
		gameFrameToRestart();
	}
	
	public void gameFrameToRestart() {
		gameFrame.destroy();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					restartFrame = new RestartFrame();
					restartFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
