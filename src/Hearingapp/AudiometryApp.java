package Hearingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudiometryApp implements ActionListener {

  //Main frame and panel which contains the result
  private JFrame frame = new JFrame();
  private JPanel centerPanel = new JPanel(new GridBagLayout());
  private GridBagConstraints c = new GridBagConstraints();
  private AppData appData = new AppData();



  //combo boxes for the left ear
  private JComboBox<Integer> left500, left1k, left2k, left4k;

  //combo boxes for the right ear
  private JComboBox<Integer> right500, right1k, right2k, right4k;


  JComboBox[] boxes = {left500, left1k, left2k, left4k,
      right500, right1k, right2k, right4k};


  //submit button
  private JButton ok;

  //result text field
  private JTextField res;
  private JLabel rightEarLabel;
  private JLabel leftEarLabel;

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
    ok.addActionListener(e -> {
      System.out.println("Values Submitted");

      EarCalculator calc = new FowlerLossCalculator();

      EarModel left = new EarModel(appData.getL5(), appData.getL1(), appData.getL2(), appData.getL4(), calc);

      EarModel right = new EarModel(appData.getR5(), appData.getR1(), appData.getR2(), appData.getR4(), calc);

      System.out.print("Left : ");
      System.out.print(left.getValueThisEar());
      System.out.println("%");

      System.out.print("Right: ");
      System.out.print(right.getValueThisEar());
      System.out.println("%");

      res.setText(left.getTotalValue(right) + "%");
    });
  }

  private void setupInterface() {

    int[] yCoords = {1, 2, 3, 4};

    //Combo box setup with names, listener and positions
    for (int i = 0; i < 8; i++) {
      boxes[i] = new JComboBox<>(appData.getDecibel());
      boxes[i].setName(appData.getBoxnames()[i]);
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
    leftEarLabel = new JLabel("Left EarModel");
    c.gridx = 1;
    c.gridy = 0;
    centerPanel.add(leftEarLabel, c);

    rightEarLabel = new JLabel("Right EarModel");
    c.gridx = 3;
    c.gridy = 0;
    centerPanel.add(rightEarLabel, c);

    //Set up labels for comboboxes
    for (int i = 0; i < 8; i++) {
      JLabel label = new JLabel(appData.getLabels()[i % 4]);
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
        appData.setL5(appData.loss500[index]);
        break;
      case "left1k":
        appData.setL1(appData.loss1k[index]);
      case "left2k":
        appData.setL2(appData.loss2k[index]);
        break;
      case "left4k":
        appData.setL4(appData.loss4k[index]);
        break;
      case "right500":
        appData.setR5(appData.loss500[index]);
        break;
      case "right1k":
        appData.setR1(appData.loss1k[index]);
        break;
      case "right2k":
        appData.setR2(appData.loss2k[index]);
        break;
      case "right4k":
        appData.setR4(appData.loss4k[index]);
        break;
    }
  }
}
