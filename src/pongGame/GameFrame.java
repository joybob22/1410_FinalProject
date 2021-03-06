/**
 * 
 */
package pongGame;

/**
 * @author Not Carl Hulbert
 *
 */
import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{

	GamePanel panel;
	
	GameFrame(){
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public void destroy() {
		this.setVisible(false);
		this.dispose();
	}
}