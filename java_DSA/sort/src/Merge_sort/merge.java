package Merge_sort;

import java.util.Arrays;
public class merge {
    public static void mergesort(int[] arr){//归并排序主程序
        int n = arr.length;
        int[] temp = new int[n];  // 创建临时数组
        mergeSorttt(arr,0,n-1,temp);  // 对arr数组进行归并排序
    }
    //归并排序，先是一直递归左右两半部分数组，然后调用合并函数
    private static void mergeSorttt(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;  // 中间位置索引，为了把数组分为左右两半

            mergeSorttt(arr,left,mid,temp);  // 对左边数组进行递归拆分

            mergeSorttt(arr,mid+1,right,temp);  //对右边数组进行递归拆分

            merge(arr,left,mid,right,temp);   //上述递归完毕后执行，开始合并
        }
    }
    //合并函数
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;  //左数组的索引
        int j = mid+1;  //右数组的索引
        int k = 0;  //临时数组一开始的索引

        while(i<=mid && j<=right){  // 比较左右数组的元素，将较小的元素放入临时数组中
            if(arr[i]<=arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }else if(arr[i]>arr[j]){
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid){  // 将左边数组剩余的元素放入临时数组中
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j<=right){   // 将右边数组剩余的元素放入临时数组中
            temp[k] = arr[j];
            k++;
            j++;
        }

        k=0;   // 临时数组的索引重置，为了把arr重新赋值为有序
        while(left<=right){  // 将临时数组的元素赋给arr数组
            arr[left] = temp[k];
            left++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,1,3,4,5,6,2};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
/**
 * mergesort(0,9)
 * ├── mergeSorttt(0,4)  // 左半部分
 * │   ├── mergeSorttt(0,2)
 * │   │   ├── mergeSorttt(0,1)
 * │   │   │   ├── mergeSorttt(0,0)  // 单个元素，返回
 * │   │   │   ├── mergeSorttt(1,1)  // 单个元素，返回
 * │   │   │   └── merge(0,0,1)      // 合并[10]和[9] → [9,10]
 * │   │   ├── mergeSorttt(2,2)      // 单个元素[8]
 * │   │   └── merge(0,1,2)          // 合并[9,10]和[8] → [8,9,10]
 * │   ├── mergeSorttt(3,4)
 * │   │   ├── mergeSorttt(3,3)      // 单个元素[7]
 * │   │   ├── mergeSorttt(4,4)      // 单个元素[1]
 * │   │   └── merge(3,3,4)          // 合并[7]和[1] → [1,7]
 * │   └── merge(0,2,4)              // 合并[8,9,10]和[1,7] → [1,7,8,9,10]
 * ├── mergeSorttt(5,9)  // 右半部分
 * │   ├── mergeSorttt(5,7)
 * │   │   ├── mergeSorttt(5,6)
 * │   │   │   ├── mergeSorttt(5,5)  // 单个元素[3]
 * │   │   │   ├── mergeSorttt(6,6)  // 单个元素[4]
 * │   │   │   └── merge(5,5,6)      // 合并[3]和[4] → [3,4]
 * │   │   ├── mergeSorttt(7,7)      // 单个元素[5]
 * │   │   └── merge(5,6,7)          // 合并[3,4]和[5] → [3,4,5]
 * │   ├── mergeSorttt(8,9)
 * │   │   ├── mergeSorttt(8,8)      // 单个元素[6]
 * │   │   ├── mergeSorttt(9,9)      // 单个元素[2]
 * │   │   └── merge(8,8,9)          // 合并[6]和[2] → [2,6]
 * │   └── merge(5,7,9)              // 合并[3,4,5]和[2,6] → [2,3,4,5,6]
 * └── merge(0,4,9)                  // 合并[1,7,8,9,10]和[2,3,4,5,6] → [1,2,3,4,5,6,7,8,9,10]
 */
