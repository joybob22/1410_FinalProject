package pongGame;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class TitleFrame1WinBuild extends JFrame implements Runnable{

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TitleFrame1WinBuild() {
		setMinimumSize(new Dimension(300, 300));
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
		
		JLabel lblNewLabel = new JLabel("Pong");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 62));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnNewButton_1 = new JButton("Start");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PongGame.transitionFromTitleToStart();
			}
		});
		panel.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("                              ");
		contentPane.add(lblNewLabel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_2 = new JLabel("                         ");
		contentPane.add(lblNewLabel_2, BorderLayout.EAST);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextArea highScoreTxtArea = new JTextArea();
		panel_1.add(highScoreTxtArea);
		highScoreTxtArea.setEditable(false);
		highScoreTxtArea.setLineWrap(true);
		highScoreTxtArea.setForeground(Color.WHITE);
		highScoreTxtArea.setBackground(Color.BLACK);
		highScoreTxtArea.setWrapStyleWord(true);
		
		//Button to list Highscores. Needs Formatting Work in design tab.
		JButton btnNewButton = new JButton("High Scores");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String outPut = String.format("HighScores Expand the page to see them all: %n%n");
				highScoreTxtArea.setText(outPut + listHighScores());
			}
		});
		panel.add(btnNewButton);
		
		
		
	}
	
	//For some reason this method has to be called destroy.
	//Literally everything breaks if you name it anything else.
	
	public void destroy() {
		this.setVisible(false);
		this.dispose();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	//Duplicate function from RestartFrame for now used for ease.
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
