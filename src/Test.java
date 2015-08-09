/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raees
 */
public class Test {
    
    public long ParallelTest(float[] array, int filterSize){
        long startTime2 = System.currentTimeMillis();
        Main medianP = new Main();
        long endTime2 = System.currentTimeMillis();
        float[] ans = medianP.median(array, 21);
        long totalTime2 = endTime2 - startTime2;
        return totalTime2;
    }
    
    public long SequentialTest(int filterSize, float[] array){
        long startTime1 = System.currentTimeMillis();
        SequentialFiltering medianS = new SequentialFiltering(21, array);
        long endTime1 = System.currentTimeMillis();
        float[] ans1 = medianS.getMedianList();
        long totalTime1 = endTime1 - startTime1;
        return totalTime1;
    }
}
