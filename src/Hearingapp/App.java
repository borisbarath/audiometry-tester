package Hearingapp;

import static Hearingapp.Utils.readData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {

	//Main frame and panel which contains the result
	private JFrame frame = new JFrame();
	private JPanel centerPanel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();

	//User-input lists for Fowler's algorithm
	private Double[] loss500;
	private Double[] loss1k;
	private Double[] loss2k;
	private Double[] loss4k;

	//Combo boxes for the left ear
	private JComboBox<Double> left500;
	private JComboBox<Double> left1k;
	private JComboBox<Double> left2k;
	private JComboBox<Double> left4k;

	//Combo boxes for the right ear
	private JComboBox<Double> right500;
	private JComboBox<Double> right1k;
	private JComboBox<Double> right2k;
	private JComboBox<Double> right4k;

	public void run() {
		//Sets up and populates the application window
		frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		frame.setTitle("Fowler Hearing Loss");

		loss500 = readData("500.txt");
		loss1k = readData("1000.txt");
		loss2k = readData("2000.txt");
		loss4k = readData("4000.txt");

		setupInterface();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}

	private void setupInterface() {

		//Lists for easier generation of items
		JComboBox[] boxes = {left500, left1k, left2k, left4k, right500, right1k, right2k, right4k};
		int[] yCoords = {1, 2, 3, 4};
		Double[][] lists = {loss500, loss1k, loss2k, loss4k};
		String[] labels = {" 500", "1000", "2000", "4000"};

		//Combo box setup
		for(int i = 0; i < 8; i++){
			boxes[i] = new JComboBox<>(lists[i%4]);
			if(i < 4){
				c.gridx = 1;
			} else {
				c.gridx = 3;
			}
			c.gridy = yCoords[i%4];
			centerPanel.add(boxes[i], c);
		}

		//Labels for ears
		JLabel left = new JLabel("Left Ear");
		c.gridx = 1;
		c.gridy = 0;
		centerPanel.add(left, c);
		JLabel right = new JLabel("Right Ear");
		c.gridx = 3;
		c.gridy = 0;
		centerPanel.add(right, c);

		//Set up labels
		for(int i = 0; i < 8; i++){
			JLabel label = new JLabel(labels[i%4]);
			if(i < 4){
				c.gridx = 0;
			} else {
				c.gridx = 4;
			}
			c.gridy = yCoords[i%4];
			centerPanel.add(label, c);
		}

		//Setup spacer between left and right combo boxes
		for(int i = 0; i < 4; i++){
			JLabel spacer = new JLabel("      ");
			c.gridx = 2;
			c.gridy = yCoords[i];
			centerPanel.add(spacer, c);
		}

		//OK button to submit values
		JButton ok = new JButton("OK");
		c.gridx = 2;
		c.gridy = 5;
		centerPanel.add(ok, c);

		//Overall result text field
		JTextField res = new JTextField("Result");
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(res, c);
	}
}
