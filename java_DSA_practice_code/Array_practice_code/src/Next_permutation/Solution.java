package Next_permutation;

import java.util.Arrays;
/**
 * 要求得到下一个字典序的数组
 * 输入：[1,2,3]
 * 输出：[1,3,2]
 * 当整个数组降序排列时，返回升序排列的数组
 * 思路：
 * 一开始从右往左遍历数组，找到第一个临界处i,i以前，即从0到i是升序，从i+1到n-1是降序
 * 再从右往左找第一个比nums[i]大的数，把两者交换位置，然后i以后后的数组升序排列
 * 如果一开始的i找不到，证明整个数组是降序的，只需要把数组升序排列即可
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean bl = true;
        int i = n-2;
        while(i>=0){
            if(nums[i]>=nums[i+1]){
                i--;
                continue;
            }
            int j = n-1;
            while(j>=0){
                if(nums[j]<=nums[i]){
                    j--;
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                bl = false;
                reverse(nums,i+1,n-1);  //因为交换后已经是字典序大于原先的数组了
                //但是题目要求是下一个排列，即大于原先数组的字典序最小的数组，即刚好大一点
                //所以就需要把i后的数组尽可能小，即升序排列，因为i已经交换了，保证了字典序更大
                break;
            }
            break;
        }
        if(bl){
            Arrays.sort(nums);
        }
    }
    private void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,1,3};
        s.nextPermutation(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
}
