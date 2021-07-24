package pongGame;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestartFrameWinBuild extends JFrame implements Runnable {
	private JPanel contentPane;
	private JTextField nameField;
	private String nameInput = "";
	private int counter;

	/**
	 * Create the frame.
	 */
	public RestartFrameWinBuild(int p1Score, int p2Score) {
		setMinimumSize(new Dimension(500, 500));
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setVisible(true);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		counter = 0;

		JLabel lblNewLabel = new JLabel("Game Over");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 62));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel_1 = new JLabel("                              ");
		contentPane.add(lblNewLabel_1, BorderLayout.WEST);

		JLabel lblNewLabel_2 = new JLabel("                         ");
		contentPane.add(lblNewLabel_2, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblWinner = new JLabel(winMsg(p1Score, p2Score));
		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinner.setForeground(Color.WHITE);
		lblWinner.setFont(new Font("Dialog", Font.PLAIN, 45));
		panel_1.add(lblWinner, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setForeground(new Color(0, 0, 0));
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_4 = new JLabel("Player Name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_4);

		nameField = new JTextField();
		panel_2.add(nameField);
		nameField.setColumns(10);

		JTextArea areaMsg = new JTextArea();
		areaMsg.setPreferredSize(new Dimension(5, 5));
		areaMsg.setMinimumSize(new Dimension(5, 5));
		areaMsg.setEditable(false);
		areaMsg.setLineWrap(true);
		areaMsg.setWrapStyleWord(true);
		areaMsg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		areaMsg.setText("Type in your name below and hit the Enter button to record your high Score!");
		areaMsg.setBackground(Color.BLACK);
		areaMsg.setForeground(Color.WHITE);
		panel_1.add(areaMsg, BorderLayout.CENTER);

		JButton btnNewButton_2 = new JButton("Enter");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// String testString = nameField.getText();
				if(counter==0) { //Makes sure only 1 entry is permitted per win, can change for testing
					nameInput = nameField.getText();
					addHighScore(nameField.getText(), Math.abs(p1Score - p2Score));
					areaMsg.setText("Score Recorded!");
					counter++;
				}
				else {areaMsg.setText("Play again to record a new Score!");}
				
			}
		});
		panel_2.add(btnNewButton_2);

		JButton btnNewButton = new JButton("High Scores");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String outPut = String.format("HighScores Expand the page to see them all: %n%n");
				areaMsg.setText(outPut + listHighScores());
				//listHighScores();
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Restart");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PongGame.transitionFromRestartToStart();
			}
		});
		panel.add(btnNewButton_1);

	}

	// For some reason this method has to be called destroy.
	// Literally everything breaks if you name it anything else.
	public void destroy() {
		this.setVisible(false);
		this.dispose();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	private String winMsg(int s1, int s2) {
		String outMsg;
		if (s1 > s2) {
			outMsg = "p1Win";
		} else if (s1 < s2) {
			outMsg = "p2Win";
		} else if (s1 == s2) {
			outMsg = "Tie";
		} else {
			outMsg = "Uh-Oh That's not supposed to happen!";
		}
		return outMsg;
	}

	/**
	 * Update the highScores file
	 * 
	 * @param pName
	 * @param pScore
	 */
	public void addHighScore(String pName, int pScore) {
		// String outString = "Player: " + pName + " High Score:" + pScore;
		String outString = String.format("%nPlayer: %s %nWon By: %d Points %n", pName, pScore);
		outString+=" -------------------- ";
		
		try {
			Files.write(Paths.get("highScores.txt"), outString.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		/**
		 * try { FileWriter fileWriter = new FileWriter("highScores.txt"); PrintWriter
		 * printWriter = new PrintWriter(fileWriter); printWriter.printf("Player: %s Won
		 * By: %d Points %n", pName, pScore); printWriter.printf("-----------------");
		 * printWriter.close(); } catch (IOException e) { System.out.println("An error
		 * occurred."); e.printStackTrace(); }
		 */

		/*
		 * try { FileWriter myWriter = new FileWriter("highScores.txt");
		 * myWriter.write(outString); myWriter.close();
		 * System.out.println("Successfully wrote to the file."); } catch (IOException
		 * e) { System.out.println("An error occurred."); e.printStackTrace(); }
		 */
	}

	public String listHighScores() {
		String outPut = "";
		List<String> scoreList = new ArrayList<String>();
		try {
			File myObj = new File("highScores.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				scoreList.add(String.format("%s%n",data));
				
				//System.out.println(data); //Print the file to cmd line for testing
				//outPut+=data; Method not using Generic Collection
				//outPut+= String.format("%n");
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		for(String i : scoreList) {outPut+=i;}
		
		return outPut;
	}
}
