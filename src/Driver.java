/* Raees Eland
 * Assignment 1
 * Driver Class
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Driver {

    public static void main(String args[]) {
        //long startTime = System.currentTimeMillis();
        List<Float> list = new ArrayList<Float>();
        File file = new File("inp1-1.txt");
        try {
            Scanner line = new Scanner(file);
            line.nextLine();
            while (line.hasNextLine()) {

                String line1 = line.nextLine();
                int space = line1.indexOf(" ");
                String line2 = line1.substring(space);
                Scanner number = new Scanner(line2);

                while (number.hasNextFloat()) {
                    list.add(number.nextFloat());
                }
            }
        } catch (FileNotFoundException e) {
        };

        File out = new File("output.txt");
        File out1 = new File("output1.txt");
        PrintStream T1 = null;
        PrintStream T2 = null;

        try {
            T1 = new PrintStream(out);
            T2 = new PrintStream(out1);
        } catch (FileNotFoundException e) {
        };

        float[] array = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
		//long endTime   = System.currentTimeMillis();
        //long totalTime = endTime - startTime;
        //System.out.println(totalTime);

        

        


    }
}
