package Sum_of_three_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试类
 * 本类只是对Solution类的复现
 * 旨在让自己进一步加深印象
 */
public class test1 {
    public List<List<Integer>> threeSum (int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        //quicksort.quick(nums);
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left =i+1;
            int right =n-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left]==nums[left+1]) {
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        test1 t = new test1();
        t.threeSum(nums);
        System.out.println(t.threeSum(nums));
    }

}
