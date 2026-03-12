package Quick_sort;

import java.util.Arrays;

public class quick {
    public static void quicksort(int[] arr){
        sort(arr,0,arr.length-1);
    }
    private static void sort(int[] arr,int left,int right){
        if(left<right){
            int pivot = partition(arr,left,right);
            sort(arr,left,pivot-1);
            sort(arr,pivot,right);
        }
    }
    private static int partition(int[] arr,int left,int right){
        int pivot = arr[(left+right)/2];
        int i=left;
        int j=right;
        while(i<j){
            while(arr[i]<pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,10,8,9,7};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
