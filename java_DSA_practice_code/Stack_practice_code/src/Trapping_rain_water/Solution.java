package Trapping_rain_water;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int all_sum = 0;
        int height_sum = 0;
        int left = 0;
        int right = n-1;
        for(int i=0;i<n;i++){
            height_sum +=height[i];

        }
        while(height[left]==0){
            left++;
        }
        while(height[right]==0){
            right--;
        }
        int h = Math.min(height[left],height[right]);
        int temp = 0;
        while(left<right){
            while(height[left]<h){
                left++;
            }
            while(height[right]<h){
                right--;
            }
            all_sum += (right-left+1)*(h-temp);
            temp = h;
            while(height[left]<=h){
                left++;
            }
            while(height[right]<=h){
                right--;
            }
            h=Math.min(height[left],height[right]);
        }
        while(height[left]==h){
            left--;
        }
        while(height[right]==h){
            right++;
        }
        all_sum += (right-left+1)*(h-temp);
        int result = 0;
        if(all_sum==0){
            result = 0;
        }else{
            result = all_sum-height_sum;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(height));
    }
}
