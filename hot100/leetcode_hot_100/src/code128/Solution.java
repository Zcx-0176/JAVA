package code128;
/*
    最长连续序列

    nums是未排序的数组，找出数字连续的最长序列，索引可以不连续

    故比如说nums  为 0 2 1 1
    那么最长连续序列为3  即0 1 2
    那么可以先用Arrays.sort()进行数组排序
    然后进行动态规划

    动规法则为：初始第一个索引位置为1，表示当前最长连续序列长度为1
    然后往后循环
    如果当前索引的nums的值比前一个大于1
    那么这肯定是数字连续的，dp[i]就等于dp[i-1]+1
    也就是说i索引的位置，当前最长连续序列长度为dp[i]

    但是有一个问题，nums  为 0 2 1 1，如果有重复的数字，可以跳过
    所以如果nums[i] == nums[i-1]
    则dp[i] = dp[i-1]
    为了保证后续如果有第一种只相差1的情况，能够正确dp相加

    如果是其他情况，就是nums[i]比nums[i-1]相差大于1
    则直接将dp[i]置为1即可
    重新开始考虑是否从i开始有最长序列长度


    max为动规好的dp最大值
    返回max
 */
import java.util.*;
public class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        if(n == 0){
            return 0;
        }
        dp[0] = 1;
        int max = 1;
        for(int i=1;i<n;i++){
            if(nums[i]-1 == nums[i-1]){
                dp[i] = dp[i-1] + 1;
                max = Math.max(max,dp[i]);
            }else if(nums[i] == nums[i-1]){
                dp[i] = dp[i-1];
            }else{
                dp[i] = 1;

            }
        }
        return max;
    }
}
