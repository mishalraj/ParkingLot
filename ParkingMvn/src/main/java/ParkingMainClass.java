import ParkingFunctions.ParkingCommandResolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Entry point of the code
 * The input file will be taken with in argument with .jar file
 */

public class ParkingMainClass {

  public static void main(String[] args) throws IOException {
    ParkingCommandResolver processor = new ParkingCommandResolver();
    BufferedReader bufferReader = null;
    String input = null;
    File inputFile = new File(args[0]);
    try {
      bufferReader = new BufferedReader(new FileReader(inputFile));
      int lineNo = 1;
      while ((input = bufferReader.readLine()) != null) {
        input = input.trim();
        try {
          processor.execute(input);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        lineNo++;
      }
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }
}
