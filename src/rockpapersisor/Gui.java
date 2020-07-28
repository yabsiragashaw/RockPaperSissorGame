package rockpapersisor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gui implements ActionListener {
	
	// Creating JLabels, Buttons...
	JFrame frame;
	private JButton rockB;
	private JButton paperB;
	private JButton scissorB;
	public static JLabel labelPicRock;
	public static JLabel labelPicPaper;
	public static JLabel infoGame;
	public static JLabel labelPicScissor;
	public static JPanel panelDis;
	public static JPanel panelBut;
	public String userInput;
	ImageIcon rockPic;
	ImageIcon paperPic;
	ImageIcon scissorPic;
	

	public Gui() {
		
		frame = new JFrame("Keypad");
		panelBut = new JPanel();
		labelPicPaper = new JLabel();
		labelPicRock = new JLabel();
		labelPicScissor = new JLabel();
		panelDis = new JPanel();
		
		// Layout Design 
	    frame.setLayout(new GridLayout(3, 1));
	    panelDis.setLayout(new GridLayout(1, 3));
		panelBut.setLayout(new GridLayout(1, 3));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 330);
		frame.setResizable(true);
		frame.setLocation(50, 50);

		rockB = new JButton("rock");
		paperB = new JButton("paper");
		scissorB = new JButton("scissor");
		
		infoGame = new JLabel();
		infoGame.setText("Welcome!! Ready to PLAY?! Choose ONE! ");
		
		rockB.addActionListener(this);
		paperB.addActionListener(this);
		scissorB.addActionListener(this);
		
		// pictures
		rockPic = new ImageIcon(getClass().getResource("rock.jpg"));
		paperPic = new ImageIcon(getClass().getResource("paper.jpg"));
		scissorPic = new ImageIcon(getClass().getResource("scissor.jpg"));
		
		
		labelPicRock.setIcon(rockPic);
		labelPicPaper.setIcon(paperPic);
		labelPicScissor.setIcon(scissorPic);
		
		panelBut.add(rockB);
		panelBut.add(paperB);
		panelBut.add(scissorB);
		
		panelDis.add(labelPicRock);
		panelDis.add(labelPicPaper);	
		panelDis.add(labelPicScissor);	
		
		frame.add(infoGame);
		frame.add(panelDis);
		frame.add(panelBut);			
		frame.setVisible(true);
	}
		
	public static void main(String[] args)  {
		new Gui();
	}
	
	public String random() {
		ArrayList<String> options = new ArrayList<String>();
		options.add("paper");
		options.add("rock");
		options.add("scissor");
		
		Random random = new Random();
		
		return options.get(random.nextInt(options.size()));
	}
	
	// Pop-up Messages for the user
	public void compare(String random, String userInput) {
		if(random.equals("paper")  && userInput.equals("rock")) {
			JOptionPane.showMessageDialog(frame, "Sorry, You Lose :( \n" + "I chose " + random + " & you chose " + userInput, "result", JOptionPane.INFORMATION_MESSAGE);
		}else if(random.equals("paper")  && userInput.equals("scissor")) {
			JOptionPane.showMessageDialog(frame, "Congrats You Won :) \n" + "I chose " + random + " & you chose " + userInput, "result", JOptionPane.INFORMATION_MESSAGE);
		}else if(random.equals("rock")  && userInput.equals("scissor")) {
			JOptionPane.showMessageDialog(frame, "Sorry, You Lose :( \n" + "I chose " + random + " & you chose " + userInput, "result", JOptionPane.INFORMATION_MESSAGE);
		}else if(random.equals("rock")  && userInput.equals("paper")) {
			JOptionPane.showMessageDialog(frame, "Congrats You Won :)\n" + "I chose " + random + " & you chose " + userInput, "result", JOptionPane.INFORMATION_MESSAGE);
		}else if(random.equals("scissor")  && userInput.equals("paper")) {
			JOptionPane.showMessageDialog(frame, "Sorry, You Lose :( \n" + "I chose " + random + " & you chose " + userInput, "result", JOptionPane.INFORMATION_MESSAGE);
		}else if(random.equals("scissor")  && userInput.equals("rock")) {
			JOptionPane.showMessageDialog(frame, "fine you win \n" + "I chose " + random + " & you chose " + userInput, "result", JOptionPane.INFORMATION_MESSAGE);
		}else if(random == userInput) {
			JOptionPane.showMessageDialog(frame, "It's a Tie \n" + "We both chose " + userInput, "result", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Action event
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if (action.equals("paper")) {
			userInput = "paper";
			compare(random(),userInput);
		} else if(action.equals("rock")){
			userInput = "rock";
			compare(random(),userInput);
		}else if(action.equals("scissor")) {
			userInput = "scissor";
			compare(random(),userInput);
		}
	}
	
}
