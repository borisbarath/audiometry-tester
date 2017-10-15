package Hearingapp;

import static Hearingapp.Utils.readData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {

//Main frame and panel which contains the result
private JFrame frame = new JFrame();
private JPanel centerPanel = new JPanel();

//User-input lists for Fowler's algorithm
private Double[] loss500;
private Double[] loss1k;
private Double[] loss2k;
private Double[] loss4k;

private JLabel space = new JLabel("     ");

private JLabel ll500 = new JLabel("Left 500Hz:");
private JLabel ll1k = new JLabel("Left 1000Hz:");
private JLabel ll2k = new JLabel("Left 2000Hz:");
private JLabel ll4k = new JLabel("Left 4000Hz:");
private JLabel rl500 = new JLabel("Left 500Hz:");
private JLabel rl1k = new JLabel("Left 1000Hz:");
private JLabel rl2k = new JLabel("Left 2000Hz:");
private JLabel rl4k = new JLabel("Left 4000Hz:");

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

	GridLayout grid = new GridLayout(4,5, 0,80);
	centerPanel.setLayout(grid);

	loss500 = readData("500.txt");
	loss1k = readData("1000.txt");
	loss2k = readData("2000.txt");
	loss4k = readData("4000.txt");

	setupButtons();
	setupInterface();

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(600, 300);
	frame.setVisible(true);
}

private void setupButtons() {

	left500 = new JComboBox<>(loss500);
	left1k = new JComboBox<>(loss1k);
	left2k = new JComboBox<>(loss2k);
	left4k = new JComboBox<>(loss4k);

	right500 = new JComboBox<>(loss500);
	right1k = new JComboBox<>(loss1k);
	right2k = new JComboBox<>(loss2k);
	right4k = new JComboBox<>(loss4k);

}

private void setupInterface() {

	centerPanel.add(ll500);
	centerPanel.add(left500);
	centerPanel.add(rl500);
	centerPanel.add(right500);
	centerPanel.add(ll1k);
	centerPanel.add(left1k);
	centerPanel.add(rl1k);
	centerPanel.add(right1k);
	centerPanel.add(ll2k);
	centerPanel.add(left2k);
	centerPanel.add(rl2k);
	centerPanel.add(right2k);
	centerPanel.add(ll4k);
	centerPanel.add(left4k);
	centerPanel.add(rl4k);
	centerPanel.add(right4k);

}
}
