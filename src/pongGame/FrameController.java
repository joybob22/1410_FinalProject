package pongGame;

import java.awt.EventQueue;

/**
 * 
 * @author braydenlemke
 *
 */

public class FrameController {
	//Immediately instantiate the title frame because that is our first frame
	TitleFrame1WinBuild titleFrame;
	RestartFrameWinBuild RestartFrameWinBuild;
	
	//All other frames would need to be declared here.
	//That way there is one class that holds all the instances of our frames
	GameFrame gameFrame;
	
	public void startTitleScreen() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					titleFrame = new TitleFrame1WinBuild();
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
	
	public void RestartFrameWinBuildToStartFrame() {
		RestartFrameWinBuild.destroy();
		gameFrame = new GameFrame();
	}
	
	/**
	 * Determine if any of the scores are a high score.
	 * If so then open the high score frame to enter the users name.
	 * 
	 * If there is no high score then simply pull up the restart screen.
	 */
	
	public void endGame(int score1, int score2) {
		//Extra endGame function if needed.
		//For now just passes info to restart
		gameFrameToRestart(score1, score2);
	}
	
	public void gameFrameToRestart(int p1Score, int p2Score) {
		gameFrame.destroy();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RestartFrameWinBuild = new RestartFrameWinBuild(p1Score, p2Score);
					RestartFrameWinBuild.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
