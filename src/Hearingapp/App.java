package Hearingapp;

import static Hearingapp.Utils.readData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

public class App implements ActionListener {

  //Results from combo boxes for building the ears
  private Double res500, res1k, res2k, res4k;

  //Main frame and panel which contains the result
  private JFrame frame = new JFrame();
  private JPanel centerPanel = new JPanel(new GridBagLayout());
  private GridBagConstraints c = new GridBagConstraints();

  //list of values for dropdown boxes
  private Integer[] decibel = {10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90,
      95};

  //loss percentage values
  private Double l5, l1, l2, l4, r5, r1, r2, r4;

  //User-input lists for Fowler's algorithm
  protected static Double[] loss500, loss1k, loss2k, loss4k;

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
        System.out.println(l5);

        Ear left = new Ear(l5, l1, l2, l4);
        Ear right = new Ear(r5, r1, r2, r4);
      }
    });
  }

  private void setupInterface() {

    //lists for easier generation of items
    String[] boxnames = {"left500", "left1k", "left2k", "left4k",
        "right500", "right1k", "right2k", "right4k"};

    JComboBox[] boxes = {left500, left1k, left2k, left4k,
        right500, right1k, right2k, right4k};

    int[] yCoords = {1, 2, 3, 4};
    Double[][] lists = {loss500, loss1k, loss2k, loss4k};
    String[] labels = {" 500", "1000", "2000", "4000"};

    //Combo box setup with names, listener and positions
    for (int i = 0; i < 8; i++) {
      boxes[i] = new JComboBox<>(decibel);
      boxes[i].setName(boxnames[i]);
      boxes[i].addActionListener(this);
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

    //Set up labels for comboboxes
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

    //Setup spacers between left and right combo boxes
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

  //Custom listener for all combo boxes
  public void actionPerformed(ActionEvent e) {
    JComboBox<Integer> cb = (JComboBox) e.getSource();
    int index = cb.getSelectedIndex();
    switch (cb.getName()) {
      case "left500":
        l5 = loss500[index];
        break;
      case "left1k":
        l1 = loss1k[index];
        break;
      case "left2k":
        l2 = loss2k[index];
        break;
      case "left4k":
        l4 = loss4k[index];
        break;
      case "right500":
        r5 = loss500[index];
        break;
      case "right1k":
        r1 = loss1k[index];
        break;
      case "right2k":
        r2 = loss2k[index];
        break;
      case "right4k":
        r4 = loss4k[index];
        break;
    }
  }
}
