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

        long startTime1 = System.currentTimeMillis();
        SequentialFiltering medianS = new SequentialFiltering(21, array);
        float[] ans1 = medianS.getMedianList();
        long endTime1 = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;
        System.out.println(totalTime1 + "ms");

        long startTime2 = System.currentTimeMillis();
        Main medianP = new Main();
        float[] ans = medianP.median(array, 21);
        long endTime2 = System.currentTimeMillis();
        long totalTime2 = endTime2 - startTime2;
        System.out.println(totalTime2 + "ms");

        System.out.println(medianP.compare(medianS.getMedianList()));

        for (int j = 0; j < ans.length; j++) {
            T1.print(j + " " + ans[j] + "\n");
            T2.print(j + " " + ans1[j] + "\n");
        }
    }
}
