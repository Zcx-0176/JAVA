package Remove_element;

import java.util.ArrayList;

public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,6,5,4,3};
        int val = 6;
        Solution s = new Solution();
        int result = s.removeElement(nums,val);
        System.out.println(result);
        for(int i=0;i<result;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
