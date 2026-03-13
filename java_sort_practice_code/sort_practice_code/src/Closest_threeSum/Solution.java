package Closest_threeSum;

import java.util.Arrays;
/**
 * 最接近的三数之和
 * 思路：
 * 先把传入的nums数组排序
 * 然后定义int result = nums[0]+nums[1]+nums[2];即前三个数之和
 * 这样如果nums就三个数的话，直接就是这个值
 * 然后用双指针，从两边往中间移动，求sum = nums[i]+nums[left]+nums[right];
 * 可用Math.abs()求绝对值，求sum-target和result-target的绝对值
 * 如果前者更小，就需要把result更新为更接近的sum
 * 然后就是更新指针了
 * 这个指针的更新是根据sum和target的大小比较的
 * 因为是有序数组了，如果sum>target，则right--，反之left++
 * 如果sum==target，那么这就是最近的了，不必再往下找了，所以直接返回sum即可
 */
public class Solution {
    public int threeSumClosest(int[] nums,int target){
        int n = nums.length;
        int result = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                int abs1 = Math.abs(sum-target);
                int abs2 = Math.abs(result-target);
                if(abs1<abs2) {
                    result = sum;
                }
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    return sum;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,7,8,9};
        int target = 15;
        Solution solution = new Solution();
        int result = solution.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
