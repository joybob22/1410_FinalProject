/**
 * 
 */
package pongGame;
import java.io.File;
import java.io.IOException;

/**
 * @author Not Carl Hulbert
 * 
 * 
 *
 */
public class PongGame {
	// This is the instance to our FrameController.
	// So any reference to its methods needs to happen from this class.
	static FrameController controller;

	public static void main(String[] args) {
		controller = new FrameController();
		controller.startTitleScreen();
		fileCreate();
	}

	// The method simply refers to the method in the controller to move to the start
	// screen.

	public static void transitionFromTitleToStart() {
		controller.TitleFrameToStartFrame();
	}

	public static void transitionFromRestartToStart() {
		controller.RestartFrameWinBuildToStartFrame();
	}

	public static void endGame(int score1, int score2) {
		controller.endGame(score1, score2);
	}

	/**
	 * Method to create and check if the highScore.txt file exists.
	 */
	public static void fileCreate() {
		try {
			File myObj = new File("highScores.txt"); //SET FILE NAME HERE
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File: "+myObj.getName()+" already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}