/**
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

public class TitleFrame1 extends JFrame implements Runnable{

	private JPanel contentPane;

	
	//Create the frame.
	 
	public TitleFrame1() {
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
		
		JButton btnNewButton = new JButton("High Scores");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("                              ");
		contentPane.add(lblNewLabel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_2 = new JLabel("                         ");
		contentPane.add(lblNewLabel_2, BorderLayout.EAST);
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
**/
