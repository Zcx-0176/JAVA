package code198;
/*
    打家劫舍
    经典的动态规划问题
    用一个dp数组，经过一定的规则判断，最后dp[n-1]的值就是最大的结果

    首先dp[0]就是nums[0]
    dp[1]就需要跟dp[0]比较。赋值为更大的那个
    必须dp[1]就开始和dp[0]比较，比如第二个例子
    不是说必须奇数个获取，也可以隔了几个获取

    然后dp[2]往后，每次比较dp[i-2]+dp[i}  和 dp[i-1]的大小
    把dp[i]赋值为更大的那个
    这样dp[n-1]就是最大的结果

    比如 2 7 9 3 1
    dp[0] = 2
    dp[1] = max(7 , 2) = 7
    dp[2] = max(2+9 , 7) = 11
    dp[3] = max(7+3 , 11) = 11
    dp[4] = max(11+1 , 11) = 12

    比如 2 1 1 2
    dp[0] = 2
    dp[1] = max(2,1) = 2
    dp[2] = max(2+1 , 2) = 3
    dp[3] = max(2+2 , 3) = 4
 */
import java.util.*;
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n==1){
            return nums[0];
        }else if(n==2){
            return Math.max(nums[0],nums[1]);
        }else{
            dp[0] = nums[0];
            dp[1] = Math.max(dp[0],nums[1]);

            for(int i=2;i<n;i++){
                dp[i] = nums[i];
                int a = dp[i-2]+dp[i];
                int b = dp[i-1];
                dp[i] = Math.max(a,b);

            }
        }
        return dp[n-1];
    }
}
