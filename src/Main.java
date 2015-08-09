/* Raees Eland
 * Assignment 1
 * Main Class
 * */

import java.util.concurrent.ForkJoinPool;

public class Main {

    static final ForkJoinPool fjPool = new ForkJoinPool();
    float[] ans;
    //float SEQ_CUTT;
    
    Main(float[] array/*, float SEQ_CUTT*/){
        ans = new float[array.length];
    }

    float[] median(float[] arr1, int filterSize) {
        fjPool.invoke(new ParallelFiltering(arr1, ans, 0, arr1.length, filterSize/*, SEQ_CUTT*/));
        return ans;
    }

    
}
