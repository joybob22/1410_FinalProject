package pongGame;

public class FrameController {
	//Immediately instantiate the title frame because that is our first frame
	TitleFrame titleFrame = new TitleFrame();
	
	//All other frames would need to be declared here.
	//That way there is one class that holds all the instances of our frames
	GameFrame gameFrame;
	
	//This method sets the visibility to the title frame to false.
	//It then declares the gameFrame. Later it will instead move to
	//the frame where the users input their names.
	public void TitleFrameToStartFrame() {
		titleFrame.destroy();
		gameFrame = new GameFrame();
	}
}
