/* Raees Eland
 * Assignment 1
 * SequentialFiltering Class
 * */

import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class SequentialFiltering {

    private int filterSize;
    private float[] medianList;

    SequentialFiltering(int filterSize, float[] array) {
        this.filterSize = filterSize;
        this.medianList = new float[array.length];
        this.median(array);
    }

    //calculates the median list
    public void median(float[] array) {
        float[] tempArray = new float[filterSize];

        //inserts the boundry values into the list
        for (int i = 0; i < Math.floor(filterSize / 2); i++) {
            medianList[i] = array[i];
            medianList[array.length - 1 - i] = array[array.length - 1 - i];
        }

        //inserts the median values
        for (int j = (int) Math.floor(filterSize / 2), l = 0; j < array.length - Math.floor(filterSize / 2); j++, l++) {
            int f = l;
            for (int k = 0; k < filterSize; k++) {
                tempArray[k] = array[f];
                f++;
            }
            Arrays.sort(tempArray);
            medianList[j] = tempArray[(filterSize - 1) / 2];
        }

    }

    public float[] getMedianList() {
        return medianList;
    }

}
