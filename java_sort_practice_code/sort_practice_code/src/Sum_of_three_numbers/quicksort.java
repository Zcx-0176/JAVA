package Sum_of_three_numbers;
/**
 * 快速排序
 * 虽然在Solution类用的是直接集合List自带的sort方法
 * 但是为了练习快排还是写了这个
 */
public class quicksort {
    public static void quick(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int pivot = divide(arr,left,right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }
    public static int divide(int[] arr,int left,int right){
        int pivot = arr[right];
        int i = left-1;
        for(int j = left; j < right; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }
    private static void swap(int[] arr, int i, int j){
        if(i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
