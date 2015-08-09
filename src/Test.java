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

    float[] ans;
    float[] ans1;

    public long ParallelTest(float[] array, int filterSize) {
        Main medianP = new Main(array);

        long startTime2 = System.currentTimeMillis();
        ans = medianP.median(array, filterSize);
        long endTime2 = System.currentTimeMillis();

        long totalTime2 = endTime2 - startTime2;
        return totalTime2;
    }

    public long SequentialTest(int filterSize, float[] array) {

        long startTime1 = System.currentTimeMillis();
        SequentialFiltering medianS = new SequentialFiltering(filterSize, array);
        long endTime1 = System.currentTimeMillis();

        ans1 = medianS.getMedianList();
        long totalTime1 = endTime1 - startTime1;
        return totalTime1;
    }

    //compares if the median lists produced by the sequencial and parallel filtering are the same.
    public boolean compare() {
        if (ans1.length != ans.length) {
            return false;
        } else {
            for (int i = 0; i < ans1.length; i++) {
                if (ans1[i] != ans[i]) {
                    System.out.println(i);

                    return false;
                }
            }
            return true;
        }
    }
    
    float[] getSequential(){
        return ans1;
    }
    
    float[] getParallel(){
        return ans;
    }
}
