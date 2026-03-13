package Sum_of_four_nums.README;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 四数之和
 * 思路：
 * 先对数组进行排序
 * 然后定义一个List<List<Integer>> result = new ArrayList<>();
 * 然后定义一个for循环，从第一个数开始，到倒数第三个数结束
 * 然后去重一次
 * 然后再固定一个数，for循环，从i+1开始，到n-2结束
 * 然后再去重一次
 * 然后就是left，right双指针，跟以前一样
 * 只不过sum需要用long类型，四个数相加第一个数nums[i]需要强转为long，这样Java 在进行混合类型运算时，会自动进行类型提升：
 * (long)nums[i] - 第一个数被强制转换为 long
 * long + int → 结果是 long（int 自动提升为 long）
 * long + int → 结果还是 long
 * long + int → 结果仍然是 long
 * 因为LeetCode测试样例中有[1000000000,1000000000,1000000000,1000000000]，target为-294967296
 * 预期结果为[]，这就证明sum是long类型
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = n-1;
                while(left<right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum>target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(nums, target);
        System.out.println(result);
    }
}
