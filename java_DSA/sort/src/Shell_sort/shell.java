package Shell_sort;

import java.util.Arrays;

public class shell {
    public static void shellsort(int[] arr){
        int n = arr.length;   // 获取数组长度
        int h = n/2;   // 初始增量设为数组长度的一半
        while(h>=1){
            // 内层循环：增量h，分了好几个组
            for(int i=h;i<n;i++){
                int key = arr[i];   // 保存每个组当前要插入的元素
                int j =i-h;  // j 指向同一组中前一个元素的位置
                // 每个组内有多个元素，需要吧key插入到组内合适的位置
                while(j>=0 && arr[j]>key){  //在组内循环，寻找插入位置
                    arr[j+h] = arr[j]; // 将arr[j]后移一个h的位置
                    j -= h;
                }
                arr[j+h] = key;  // 将key插入到正确位置
                //组内循环结束因为arr[j]小于key，并且arr[j+h]在之前的组内循环后移到arr[j+h+h]了
                //所以就把中间的arr[j+h]赋值为key，即插入的位置即可
            }
            h/=2;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,9,7,6,8,5};
        shellsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
