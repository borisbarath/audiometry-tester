package Hearingapp;
import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

  protected static Double[] readData(String path) {
    Double[] array = new Double[18];

    File file = new File(path);
    try {
      Scanner scanner = new Scanner(file);

      String line = scanner.nextLine();
      String[] words = line.split(" ");

      for(int i = 0; i < 18; i++){
        array[i] = Double.parseDouble(words[i]);
      }

    } catch(FileNotFoundException e) {
      e.printStackTrace();
    }
    return array;
  }

  protected static Double calculateEar(Integer e500, Integer e1k, Integer e2k, Integer e4k){
    return 0.0;
  }

  protected static Double getCorrespondingValue(){
    return 0.0;
  }
}
