/**
 * 
 */
package pongGame;

/**
 * @author Not Carl Hulbert
 * 
 * 
 *
 */
public class PongGame {
	//This is the instance to our FrameController. 
	//So any reference to its methods needs to happen from this class.
	static FrameController controller;

	public static void main(String[] args) {
		controller = new FrameController();
		controller.startTitleScreen();
	}
	
	//The method simply refers to the method in the controller to move to the start screen.
	
	public static void transitionFromTitleToStart() {
		controller.TitleFrameToStartFrame();
	}
	
	public static void endGame() {
		
	}
	
}