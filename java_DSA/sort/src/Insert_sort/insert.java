package Insert_sort;

import java.util.Arrays;

public class insert {
    public static void insertsort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                arr[j] = key;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
