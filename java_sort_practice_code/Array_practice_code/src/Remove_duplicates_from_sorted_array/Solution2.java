package Remove_duplicates_from_sorted_array;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 思路：
 * 1. 快慢指针
 * 2. 快指针遍历数组，慢指针记录不重复的元素
 * 3. 快慢指针同时移动，当快指针遇到重复元素时，慢指针不变，快指针继续移动
 * 4. 快指针遇到不重复元素时，将不重复元素赋值给慢指针代表的数组元素,慢指针接着移动到下一个位置，快指针也移动到下一个元素
 * 5. 循环结束后，慢指针的位置就是不重复元素的个数
 * 因为最后的元素添加后，slow还会加一，正好就是不重复数组的长度，因为slow是索引啊
 */
public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 1;
        }
        int fast = 1;
        int slow = 1;
        while(fast<n){
            if(nums[fast]==nums[fast-1]){
                fast++;
                continue;
            }else{
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
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
