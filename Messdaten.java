/**
 *@author ygye2s
 */

import java.util.Scanner;

public class Messdaten {
  public static double temperaturInDurchschnitt(Scanner sc) {
    String[] array;
    String line;

    double highTem = -273.15; //min temperatur
    double sumTem = 0; //variable for saving temperatures
    int temCount = 0; //counter to get average temrerature

    String message = "No Temperatur Input"; //default message for no temperature input

    while (sc.hasNextLine()) {  //save scanner input by line and spaces

      line = sc.nextLine();
      line = line.replaceAll("\\s+", " ").trim();
      array = line.split(" ");

      double tem = Double.valueOf(array[4]);

      if (array[3].equals("Temperatur")) {
        if (tem >= highTem) {

          highTem = tem;
          sumTem = sumTem + tem;
          temCount++;

          String day = array[2];
          String month = array[1];
          String year = array[0];
          message = "hoechste Temperatur (" + highTem + ") am " + day + "." + month + "." + year;

        } else {
          sumTem = sumTem + tem;
          temCount++;
        }
      }

      if (!sc.hasNext()) {	//remove blank enter
        break;
      }
    }
    System.out.println(message);
    return sumTem / temCount;
  }
}
