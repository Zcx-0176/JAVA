package Merge_intervals;

import Sum_of_three_numbers.Sum_3numbers;

import java.util.*;
/*

 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = intervals[i][0];
        }
        quick(arr,intervals);
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(result.isEmpty()||result.get(result.size()-1)[1]<intervals[i][0]){
                result.add(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void quick(int[] arr,int[][] intervals){

        quickSort(arr,0,arr.length-1,intervals);
    }
    public static void quickSort(int[] arr,int left,int right,int[][] intervals){
        if(left<right){
            int pivot = divide(arr,left,right,intervals);
            quickSort(arr,left,pivot-1,intervals);
            quickSort(arr,pivot+1,right,intervals);
        }
    }
    public static int divide(int[] arr,int left,int right,int[][] intervals){
        int pivot = arr[right];
        int i = left-1;
        for(int j = left; j < right; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j,intervals);
            }
        }
        swap(arr, i + 1, right,intervals);
        return i + 1;
    }
    private static void swap(int[] arr, int i, int j,int[][] intervals){
        if(i != j){
            int temp1 = arr[i];
            int temp2 = intervals[i][0];
            int temp3 = intervals[i][1];
            arr[i] = arr[j];
            intervals[i][0] = intervals[j][0];
            intervals[i][1] = intervals[j][1];
            arr[j] = temp1;
            intervals[j][0] = temp2;
            intervals[j][1] = temp3;

        }
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Solution s = new Solution();
        int[][] result = s.merge(intervals);
        System.out.println( Arrays.deepToString(result));
    }
}
