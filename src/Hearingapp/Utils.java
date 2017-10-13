package Hearingapp;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

  public static void readData(List<Double> array, String path) {
    //TODO: Find a way to read .txt of space-separated doubles to List
    File file = new File(path);
    try {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextDouble())
        array.add(scanner.nextDouble());

    } catch(FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void printvals(List<Double> l){
    for(int i = 0; i < 19; i++){
      System.out.println(l.get(i));
    }
  }
}
