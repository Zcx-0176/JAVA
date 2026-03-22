package Midnum;

import java.util.Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = n1+n2;
        int[] num3 = new int[n3];
        for(int i=0;i<n3;i++){
            if(i<n1){
                num3[i] = nums1[i];
            }else{
                num3[i] = nums2[i-n1];
            }
        }
        Arrays.sort(num3);
        if(n3%2==0){
            return 1.0*(num3[n3/2-1]+num3[n3/2])/2;
        }else{
            return num3[n3/2];
        }
    }
}
