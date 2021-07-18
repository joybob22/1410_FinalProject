package pongGame;

import java.awt.*;
import javax.swing.*;

public class TitleFrame extends JFrame {
	TitlePanel panel;
	TitleFrame() {
		panel = new TitlePanel();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	//For some reason this method has to be called destroy.
	//Literally everything breaks if you name it anything else.
	public void destroy() {
		this.setVisible(false);
	}
}
