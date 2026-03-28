package Sum_of_three_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 求三数之和
 * 应用List<List<Integer>>存储结果，因为要存储多个结果
 * 事先排好序，升序
 * 应用双指针思想。即从数组left和right双边索引开始
 * 先固定一个数i，即外层循环从i=0到i<n-2，因为三个数，i处于n-3时，只能n-3,n-2,n-1三个索引的数可以加了
 * i再大就会超限
 * 然后去重，如果i>0且nums[i]==nums[i-1]，则代表i跟之前重复了，之前的i已经经历过一遍，所以跳过
 * 然后定义left=i+1，right=n-1
 * 接下来循环，保证left<right的条件下，从双端往中间靠拢，即双指针
 * 然后定义和：sum=nums[i]+nums[left]+nums[right]
 * 如果sum<0，代表负数更大一点，需要调整left++，接着往后找
 * 如果sum>0，代表正数更大一点，需要调整right--，接着往前找
 * 如果sum==0，则可以往result中添加，使用 result.add(Arrays.asList(nums[i], nums[left], nums[right]))方法
 * 最内层：Arrays.asList(...)将 3 个独立的整数转换成一个固定长度的 List
 * 参数：
 * nums[i] - 第一个数（基准数）
 * nums[left] - 第二个数（左指针指向的数）
 * nums[right] - 第三个数（右指针指向的数）
 * 返回值：
 * 一个包含这 3 个数的 List<Integer>，例如：[-1, 0, 1]
 * 中间层：result.add(...)，将内层创建的三元组列表添加到result中
 * 然后就是关键的去重环节，在sum==0后
 * 如果left<right，且nums[left]==nums[left+1]，则代表left跟之前重复了，
 * 之前的left已经经历过一遍，所以跳过，让left++
 * 如果left<right，且nums[right]==nums[right-1]，则代表right跟之前重复了，
 * 之前的right已经经历过一遍，所以跳过，让right--
 * 最后的最后返回 result即可
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left]==nums[left+1]){
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
}
