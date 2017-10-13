package Hearingapp;

import static Hearingapp.Utils.readData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {

  private JFrame frame = new JFrame();
  private JPanel centerPanel = new JPanel();
  private List<Double> loss500 = new ArrayList<>();
  private List<Double> loss1k  = new ArrayList<>();
  private List<Double> loss2k  = new ArrayList<>();
  private List<Double> loss4k  = new ArrayList<>();

  public void run() {
    frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
    frame.setTitle("Fowler Hearing Loss");

    GridLayout grid = new GridLayout(4,2, 4,4);
    centerPanel.setLayout(grid);

    readData(loss500, "500.txt");
    readData(loss1k, "1000.txt");
    readData(loss2k, "2000.txt");
    readData(loss4k, "4000.txt");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 500);
    frame.setVisible(true);
  }
}
