package pongGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author braydenlemke
 *
 */

public class TitlePanel extends JPanel implements Runnable {
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	
	TitlePanel() {
		this.setFocusable(true);
		this.setLayout(new BorderLayout(0,0));
		this.setPreferredSize(SCREEN_SIZE);
		JButton startButton = new JButton("Start");
		startButton.setAlignmentY(200);
		startButton.setAlignmentX(200);
		startButton.setSize(100, 100);
		JButton highScoreButton = new JButton("High Scores");
		highScoreButton.setAlignmentY(200);
		highScoreButton.setAlignmentX(200);
		highScoreButton.setSize(100, 100);
		JLabel title = new JLabel("Pong");
		title.setBounds(0, 0, GAME_WIDTH, 200);
		
		// When this button is clicked we will call a method in PongGame
		// which holds the instance of our FrameControlller
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PongGame.transitionFromTitleToStart();
			}
		});
		
		
		
		this.add(title, BorderLayout.PAGE_START);
		this.add(startButton, BorderLayout.CENTER);
		this.add(highScoreButton, BorderLayout.EAST);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
