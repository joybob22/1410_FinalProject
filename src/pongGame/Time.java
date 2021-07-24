package pongGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class Time extends Rectangle {
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int seconds = 60;
	
	Time(int GAME_WIDTH, int GAME_HEIGHT) {
		Time.GAME_WIDTH = GAME_WIDTH;
		Time.GAME_HEIGHT = GAME_HEIGHT;
		updateSeconds();
	}
	
	private void updateSeconds() {
		new Timer().schedule(
				new TimerTask() {
					@Override
					public void run() {
						seconds--;
						if(seconds > 0) {							
							updateSeconds();
						}
					};
				},
				1000
		);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Consolas",Font.PLAIN,60));
		if(seconds == 0) {
			g.drawString("0:00", GAME_WIDTH/2 - 47, GAME_HEIGHT - 20);
		} else {			
			g.drawString(String.valueOf(seconds / 60) + ":" +
					(seconds % 60 < 10 ? "0" + String.valueOf(seconds % 60) : String.valueOf(seconds % 60)), 
					GAME_WIDTH/2 - 47, GAME_HEIGHT - 20);
		}
	}
}
