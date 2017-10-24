package Hearingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {

  //Main frame and panel which contains the result
  private JFrame frame = new JFrame();
  private JPanel centerPanel = new JPanel(new GridBagLayout());
  private GridBagConstraints c = new GridBagConstraints();
  private Utils u = new Utils();

  //list of values for dropdown boxes
  private Integer[] decibel = {10, 15, 20, 25, 30, 35, 40, 45, 50,
                               55, 60, 65, 70, 75, 80, 85, 90, 95};

  //loss percentage values
  private Double l5, l1, l2, l4, r5, r1, r2, r4;

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

        Ear left = new Ear(l5, l1, l2, l4);
        Ear right = new Ear(r5, r1, r2, r4);

        System.out.print("Left : ");
        System.out.print(left.getLossThisEar());
        System.out.println("%");

        System.out.print("Right: ");
        System.out.print(right.getLossThisEar());
        System.out.println("%");

        res.setText(new String(left.getTotalLoss(right) + "%"));
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
    Double[][] lists = {u.loss500, u.loss1k, u.loss2k, u.loss4k};
    String[] labels = {" 500", "1000", "2000", "4000"};

    //Combo box setup with names, listener and positions
    for (int i = 0; i < 8; i++) {
      boxes[i] = new JComboBox<>(decibel);
      boxes[i].setName(boxnames[i]);
      boxes[i].addActionListener(this);
      boxes[i].setSelectedIndex(0);
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
        l5 = u.loss500[index];
        break;
      case "left1k":
        l1 = u.loss1k[index];
        break;
      case "left2k":
        l2 = u.loss2k[index];
        break;
      case "left4k":
        l4 = u.loss4k[index];
        break;
      case "right500":
        r5 = u.loss500[index];
        break;
      case "right1k":
        r1 = u.loss1k[index];
        break;
      case "right2k":
        r2 = u.loss2k[index];
        break;
      case "right4k":
        r4 = u.loss4k[index];
        break;
    }
  }
}
