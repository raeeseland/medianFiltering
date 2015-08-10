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
      
        List<Float> list = new ArrayList<Float>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file to be filterd(inp1.txt, inp1B.txt, inp2.txt, inp2B.txt, inp3.txt, inp3B.txt, inp4.txt):");
        String name = input.next();
        File file = new File(name);
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

        float[] array = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        
        ///*
        //use to compare parallel and seqential given an input file and filter size
        Test time = new Test();
        System.out.print("Enter filter size(odd between 3-21):\n");
        int filterSize = input.nextInt();
        long parallelTime1 = 0;
        long sequentialTime1 = 0;

        for (int j = 0; j < 11; j++) {
            parallelTime1 += time.ParallelTest(array, filterSize);
            sequentialTime1 += time.SequentialTest(filterSize, array);

            if (j == 0) {
                parallelTime1 = 0;
                sequentialTime1 = 0;
            }
        }
        
        long parallelTime = parallelTime1 / 10;
        long sequentialTime = sequentialTime1 / 10;
        
        int faster = (int)(((sequentialTime - parallelTime) / parallelTime) * 100);
       
        System.out.println("It takes sequential filtering " + sequentialTime + "ms " + "and parallel filtering "
                + parallelTime + "ms " + "to filter an array of size " + array.length + " given filter size "
                + filterSize + ".");
        
        if (parallelTime - sequentialTime <= 0) {
            System.out.println("Parallel filtering is approxiamatly " + faster + "% faster " + "than sequential");
        } 
        else if ((parallelTime - sequentialTime > 0)) {
            System.out.println("Sequential filtering is Approxiamatly " + faster + "% faster " + "than parallel");
        }
       // */
        
        
        /*
        //Use to test filter sizes
        Test time = new Test();
        File out = new File("outputS"+"("+name+")"+".txt");
        File out1 = new File("outputP"+"("+name+")"+".txt");
        PrintStream T1 = null;
        PrintStream T2 = null;

        try {
            T1 = new PrintStream(out);
            T2 = new PrintStream(out1);
        } catch (FileNotFoundException e) {
        };
   
        long parallelTime = 0;
        long sequentialTime = 0;
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
        
       
        
        /*
        //use to test sequential limits(given a filter size)
        
        Test time = new Test();
        System.out.print("Enter filter size(odd between 3-21):\n");
        int filterSize = input.nextInt();
        
        File out = new File("outputP"+"("+name+")"+"("+filterSize+")"+".txt");
        PrintStream T2 = null;
        try {
            T2 = new PrintStream(out);
           
        } catch (FileNotFoundException e) {
        };
        
        long parallelTime = 0;
        T2.println("filter size"+" "+filterSize);
        
        for (float j = 500; j < 20000; j+=500) {
            for(int i=0; i<11; i++){
                parallelTime += time.ParallelTest(array,filterSize,j);
                if (i == 0) {
                    parallelTime = 0;                  
                }
                
            }
            T2.println(j+" "+parallelTime / 10);
            T2.println();
        }
        
        */
        
       // /*
        //Use to print list to a file 
        String outFileS="outputSequential"+"("+name+")"+".txt";
        String outFileP="outputParallel"+"("+name+")"+".txt";
        File out = new File(outFileS);
        File out1 = new File(outFileP);
        PrintStream T1 = null;
        PrintStream T2 = null;

        try {
            T1 = new PrintStream(out);
            T2 = new PrintStream(out1);
        } catch (FileNotFoundException e) {
        };

        float[] ans = time.getParallel();
        float[] ans1 = time.getSequential();

        if (time.compare()) {
            System.out.println("Sequential and Parallel lists are equal");
        } else {
            System.out.println("Sequential and Parallel lists are equal");
        }

        for (int i = 0; i < array.length; i++) {
            T1.print(i + 1 + " " + ans1[i]);
            T2.print(i + 1 + " " + ans[i]);
        }
        System.out.println("Median lists have been written to files "+outFileS+" and "+outFileP);
        //*/

    }
}
