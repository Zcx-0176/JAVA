package Trapping_rain_water;

import java.util.Arrays;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = height[0];
        int lmax = height[0];
        for(int i=1;i<n;i++){
            if(height[i]<lmax){
                leftmax[i] = leftmax[i-1];
            }
            else{
                lmax = height[i];
                leftmax[i] = height[i];
            }
        }
        rightmax[n-1] = height[n-1];
        int rmax = height[n-1];
        for(int i=n-2;i>=0;i--){
            if(height[i] < rmax){
                rightmax[i] = rightmax[i+1];
            }else{
                rmax = height[i];
                rightmax[i] = height[i];
            }
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += Math.min(leftmax[i],rightmax[i])-height[i];
        }
        return sum;

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(height));
    }
}
