package Remove_duplicates_from_sorted_array;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 思路：
 * 1. 创建一个结果数组result，用于存储去重后的数组
 * 2. 创建两个指针left和right，分别指向数组的开始和结束位置
 * 3. 当left小于right时，判断left和right位置的元素是否相等
 * 4. 如果相等，则left指针向右移动一位，right指针向左移动一位
 * 5. 如果不相等，则将left位置的元素添加到结果数组result中，left指针向右移动一位，right指针向左移动一位
 * 6. 结束循环后，存在一种情况无法在循环内添加：当left等于right时，将left位置的元素添加到
 * 如：[1,2,3]，结束循环发现left==right，结束循环了，但是2未添加
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = n-1;
        if(n==1){
            return 1;
        }
        while(left<right){
            if(left<n-1 && nums[left]==nums[left+1]){
                left++;
                continue;
            }else if(right>=0 && nums[right]==nums[right-1]){
                right--;
                continue;
            }
            result.add(nums[left]);
            result.add(nums[right]);
            left++;
            right--;
        }
        if(left==right){
            result.add(nums[left]);
        }
        int newsize = result.size();
        int[] newnums = new int[newsize];
        for(int i=0;i<newsize;i++){
            newnums[i] = result.get(i);
        }
        Arrays.sort(newnums);
        for(int i=0;i<newsize;i++){
            nums[i] = newnums[i];
        }
        return newsize;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution s = new Solution();
        int result = s.removeDuplicates(nums);
        System.out.println(result);
        for(int i=0;i<result;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
