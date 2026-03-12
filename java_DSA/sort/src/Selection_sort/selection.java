package Selection_sort;

import java.util.Arrays;

public class selection {
    public static void selectionsort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void main(String[] args){
        int[] arr = {6,5,4,3,2,1};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
