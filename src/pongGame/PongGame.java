/**
 * 
 */
package pongGame;

/**
 * @author Not Carl Hulbert
 * 
 * All source code for this project
 * gotten from: 
 * https://www.youtube.com/watch?v=oLirZqJFKPE
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
	
}