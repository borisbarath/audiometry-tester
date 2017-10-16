package Hearingapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

  protected static Double[] readData(String path) {
    Double[] array = new Double[18];
    //Read txt file into array
    File file = new File(path);
    try {
      Scanner scanner = new Scanner(file);
      String line = scanner.nextLine();
      String[] words = line.split(" ");

      for (int i = 0; i < 18; i++) {
        array[i] = Double.parseDouble(words[i]);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return array;
  }

  protected static Double calculateEar(Integer e500, Integer e1k, Integer e2k, Integer e4k) {
    return 0.0;
  }

  protected static Double getCorrespondingValue(Frequency freq, int decibel) {

    int index = (decibel - 10) / 5;
    //get corresponding loss percentage from the input-lists
    switch (freq) {
      case F500:
        return App.loss500[index];
      case F1000:
        return App.loss1k[index];
      case F2000:
        return App.loss2k[index];
      default:
        return App.loss4k[index];
    }
  }
}
