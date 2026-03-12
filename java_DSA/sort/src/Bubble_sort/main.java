package Bubble_sort;

import java.util.Arrays;

public class main {
    public static void main(String[] args){
        int[] arr = {6,5,3,4,2,1};
        bubble b = new bubble();
        b.bubblesort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1,2,6,5,4,3};
        b.bubblesort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
