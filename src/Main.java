/* Raees Eland
 * Assignment 1
 * Main Class
 * */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Main {

    static final ForkJoinPool fjPool = new ForkJoinPool();
    float[] ans;

    float[] median(float[] arr1, int filterSize) {
        ans = new float[arr1.length];
        fjPool.invoke(new ParallelFiltering(arr1, ans, 0, arr1.length, filterSize));
        return ans;
    }

    //compares if the median lists produced by the sequencial and parallel filtering are the same.
    public boolean compare(float[] arr1) {
        if (arr1.length != ans.length) {
            return false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != ans[i]) {
                    System.out.println(i);

                    return false;
                }
            }
            return true;
        }
    }
}
