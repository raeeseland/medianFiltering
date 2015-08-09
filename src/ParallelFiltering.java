/* Raees Eland
 * Assignment 1
 * ParallelFiltering Class
 * */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.Arrays;

public class ParallelFiltering extends RecursiveAction {

    float SEQUENTIAL_CUTOFF = 500;
    float[] array;
    int start;
    int end;
    int filterSize;
    int startIndex;
    int endIndex;
    float[] medianList;

    ParallelFiltering(float[] array, float[] medianList, int start, int end, int filterSize/*, SEQ_CUTT*/) {
        this.array = array;
        this.medianList = medianList;
        this.start = start;
        this.end = end;
        this.filterSize = filterSize;
        //SEQUENTIAL_CUTOFF=SEQ_CUTT
        //where to start inserting the medians given a start and end value to look for.
        startIndex = start + (int) Math.floor(filterSize / 2);
        endIndex = end - (int) Math.floor(filterSize / 2);
    }

    protected void compute() {
        
        // inserts the boundry values
        if (end - start == array.length) {
            for (int i = 0; i < Math.floor(filterSize / 2); i++) {
                medianList[i] = array[i];
                medianList[array.length - 1 - i] = array[array.length - 1 - i];
            }
        }

        if (end - start <= SEQUENTIAL_CUTOFF) {

            float[] tempArray = new float[filterSize];
            for (int j = startIndex, l = start; j < endIndex; j++, l++) {
                int f = l;
                for (int k = 0; k < filterSize; k++) {
                    tempArray[k] = array[f];
                    f++;
                }
                Arrays.sort(tempArray);
                medianList[j] = tempArray[(filterSize - 1) / 2];
            }
        } else {
            
            //where to look in the array for the values that need to be filterd
            int mid = (int) Math.floor((end + start) / 2) + (int) Math.floor(filterSize / 2);
            int mid1 = (int) mid - 2 * (int) Math.floor(filterSize / 2);

            ParallelFiltering left = new ParallelFiltering(array, medianList, start, mid, filterSize);
            ParallelFiltering right = new ParallelFiltering(array, medianList, mid1, end, filterSize);
            left.fork();
            right.compute();
            //left.join();
        }

    }
    
   

}
