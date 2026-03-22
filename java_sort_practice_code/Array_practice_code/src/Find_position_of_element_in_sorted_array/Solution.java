package Find_position_of_element_in_sorted_array;

import java.util.Arrays;
/**
 * 思路：
 * 初始化结果数组为-1,-1，如果没找到就直接返回结果-1,-1即可
 * 二分查找
 * 1.先找到target的索引，即mid
 * 2.然后向两边扩展，找到target的左右边界
 * 3.返回结果
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[]{-1,-1};
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid -1;
            }else if(nums[mid]==target){
                left = mid;
                right =mid;
                while(left>=1 && nums[left] == nums[left-1]){
                    left--;
                }
                while(right<n-1 && nums[right] == nums[right+1]){
                    right++;
                }
                result[0] = left;
                result[1] = right;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {};
        System.out.println(Arrays.toString(s.searchRange(nums,11)));
    }
}
