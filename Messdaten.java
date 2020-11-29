/**
 *@author ygye2s
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Messdaten {
    public static void main (String[] args)	{

        Scanner scan = new Scanner(System.in);
        System.out.println(temperaturInDurchschnitt(scan));

    }


    public static double temperaturInDurchschnitt(Scanner sc) {
            String[] array;
            String line;
            String tester = "";

            int i = 0;

            double high_tem = -273.15; //min temperatur
            double sum_tem = 0; // variable for saving temperatures
            int tem_count = 0; // counter to devide aver_tem

            System.out.println("!! scanner is working....");

            String message = "No Temperatur Information"; // default message for no temperature input

            while (sc.hasNextLine()) {
                line = sc.nextLine();
                line = line.trim();
                array = line.split(" ");

                double tem = Double.valueOf(array[4]);

                if (array[3].equals("Temperatur")) {
                    if(tem > high_tem){
                        high_tem = tem;
                        sum_tem =+ tem;
                        tem_count ++;

                        String day = array[2];
                        String month = array[1];
                        String year = array[0];

                        message = "hoechste Temperatur ("+ high_tem + ") am " + day + "." + month +"."+ year;


                    } else {
                        sum_tem = sum_tem + tem;
                        tem_count++;
                    }

                } else{ }


                if (!sc.hasNext()) {
                    break;
                }

            }

            System.out.println(message);
            return sum_tem / tem_count;
        }

    }
