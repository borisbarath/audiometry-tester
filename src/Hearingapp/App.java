package Hearingapp;

import static Hearingapp.Utils.readData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App {

  //Main frame and panel which contains the result
  private JFrame frame = new JFrame();
  private JPanel centerPanel = new JPanel(new GridBagLayout());
  private GridBagConstraints c = new GridBagConstraints();

  //User-input lists for Fowler's algorithm
  protected Double[] loss500, loss1k, loss2k, loss4k;

  //list of values for dropdown boxes
  private Integer[] decibel = {10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95};

  //combo boxes for the left ear
  private JComboBox<Integer> left500, left1k, left2k, left4k;

  //combo boxes for the right ear
  private JComboBox<Integer> right500, right1k, right2k, right4k;

  //submit button
  private JButton ok;

  //result text field
  private JTextField res;

  public void run() {
    //sets up and populates the application window
    frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
    frame.setTitle("Fowler Hearing Loss");

    //read specified values
    loss500 = readData("500.txt");
    loss1k = readData("1000.txt");
    loss2k = readData("2000.txt");
    loss4k = readData("4000.txt");

    //self-explanatory
    setupInterface();
    setupFunctionality();

    //make window visible, set its size
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
  }

  private void setupFunctionality() {
    ok.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Values Submitted");
        res.setText("VALUE HERE");
        Ear left = new Ear((int) left500.getSelectedItem(),
            (int) left1k.getSelectedItem(),
            (int) left2k.getSelectedItem());

        Ear right = new Ear((int) right500.getSelectedItem(),
            (int) right1k.getSelectedItem(),
            (int) right2k.getSelectedItem());
        right.getLossThisEar() < left.getLossThisEar() ?

      }
    });
  }

  private void setupInterface() {

    //lists for easier generation of items
    JComboBox[] boxes = {left500, left1k, left2k, left4k, right500, right1k, right2k, right4k};
    int[] yCoords = {1, 2, 3, 4};
    Double[][] lists = {loss500, loss1k, loss2k, loss4k};
    String[] labels = {" 500", "1000", "2000", "4000"};

    //Combo box setup
    for (int i = 0; i < 8; i++) {
      boxes[i] = new JComboBox<>(decibel);
      if (i < 4) {
        c.gridx = 1;
      } else {
        c.gridx = 3;
      }
      c.gridy = yCoords[i % 4];
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
    for (int i = 0; i < 8; i++) {
      JLabel label = new JLabel(labels[i % 4]);
      if (i < 4) {
        c.gridx = 0;
      } else {
        c.gridx = 4;
      }
      c.gridy = yCoords[i % 4];
      centerPanel.add(label, c);
    }

    //Setup spacer between left and right combo boxes
    for (int i = 0; i < 4; i++) {
      JLabel spacer = new JLabel("      ");
      c.gridx = 2;
      c.gridy = yCoords[i];
      centerPanel.add(spacer, c);
    }

    //OK button to submit values
    ok = new JButton("OK");
    c.gridx = 2;
    c.gridy = 5;
    centerPanel.add(ok, c);

    //Overall result text field
    res = new JTextField("Result");
    res.setEditable(false);
    c.gridx = 1;
    c.gridy = 6;
    c.gridwidth = 3;
    c.fill = GridBagConstraints.HORIZONTAL;
    centerPanel.add(res, c);
  }
}
