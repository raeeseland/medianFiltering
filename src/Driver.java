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
        Scanner input = new Scanner(System.in);
        File file = new File("inp3.txt");
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
        File out1 = new File("200output1.txt");
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

        Test time = new Test();
        System.out.print("Enter filter size(odd between 3-21):\n");
        int filterSize=input.nextInt();
        long parallelTime1 = 0;
        long sequentialTime1 = 0;
        //long parallelTime = 0;
        //long sequentialTime = 0;
        
        for (int j = 0; j < 11; j++) {
                parallelTime1 += time.ParallelTest(array, filterSize);
                sequentialTime1 += time.SequentialTest(filterSize, array);
                
                if (j == 0) {
                    parallelTime1 = 0;
                    sequentialTime1 = 0;
                }		
        }
        long parallelTime=parallelTime1/10;
        long sequentialTime=sequentialTime1/10;
        
        /*
        for (int i = 3; i < 22; i += 2) {
            T1.println("filterSize" + " " + i);
            T2.println("filterSize" + " " + i);
            parallelTime = 0;
            sequentialTime = 0;
            for (int j = 0; j < 11; j++) {

                parallelTime += time.ParallelTest(array, i);
                sequentialTime += time.SequentialTest(i, array);
                if (j == 0) {
                    parallelTime = 0;
                    sequentialTime = 0;
                }		
            }
            T1.println(sequentialTime / 10);
            T2.println(parallelTime / 10);
            T1.println();
            T2.println();
        }
                
        */
        
         long faster = ((sequentialTime-parallelTime)/parallelTime)*100;
         //System.out.println(((sequentialTime-parallelTime)/parallelTime)*100);
         System.out.println("It takes sequential filtering "+sequentialTime+"ms "+"and parallel filtering "
         +parallelTime+"ms "+"to filter an array of size "+array.length+" given filter size "+
         filterSize+".");
         if(parallelTime -sequentialTime <= 0)
         System.out.println("Parallel filtering is "+faster+"% faster "+"than sequential");
         else
         System.out.println("Sequential filtering is "+faster+"% faster "+"than parallel");
         
    }
}
