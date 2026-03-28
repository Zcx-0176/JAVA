package Remove_element;

import java.util.ArrayList;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        int i=0;
        while(i<n){
            if(nums[i]!=val){
                result.add(nums[i]);
                i++;
            }else{
                i++;
            }
        }
        int size = result.size();
        for(int j=0;j<size;j++){
            nums[j] = result.get(j);
        }
        return size;
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
