package Rotated_sorted_array;
/**
 * 题目要求要O(logn)时间复杂度
 * 那么即二分查找
 * 思路：
 * 因为是旋转后的数组，需要先找到旋转点，即分界点
 * 根据分界点和nums[0]跟target相比的大小，看target在哪一边
 * 给left right赋值， 在while(left<=right)循环内用mid=(left+right)/2进行二分查找
 * 即每次将nums[mid]和target进行比较。比较有三种情况，
 * 1.nums[mid]==target 直接返回索引mid
 * 2.nums[mid]<target  把left=mid+1
 * 3.nums[mid]>target  把right=mid-1
 */
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }else if(n==1 && nums[0]==target){
            return 0;
        }else if(n==1 && nums[0]!=target){
            return -1;
        }
        int count = 0;
        while(count<n-1){
            if(nums[count]<nums[count+1]){
                count++;
            }else{
                break;
            }
        }
        int left = 0;
        int right = 0;
        if(nums[count]>target && nums[0]<target){
            left = 0;
            right = count;
        }else if(nums[count]>target && nums[0]>target){
            left = count+1;
            right = n-1;
        }else if(nums[count]== target){
            return count;
        }
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {1,3};
        System.out.println(s.search(nums,3));
    }
}
