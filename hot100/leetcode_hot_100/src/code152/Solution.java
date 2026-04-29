package code152;
/*
    乘积最大子数组
    明显是使用动态规划

    根据题目所给的数据范围，有负数有正数
    即有可能原先的最小数乘上后面的负数变为最大
    也有可能原先的最大数乘上后面的正数变得更大

    所以需要两个动态规划dp数组
    dp1存储每次动规的最大值
    dp2存储每次动规的最小值

    动规的方法：
    t1存储当前元素
    t2存储dp1的前一个元素
    t4存储dp2的前一个元素
    t3=t2*t1  即前一个的最大值乘上当前数据
    t5=t4*t1  即前一个的最小值乘上当前数据

    那么有3种情况，
    要么：t3比t1、t5大
    要么：t5比t1、t3大
    要么：t1比t3、t5大

    所以dp1需要每次找出t1 t3 t5 中的最大值存储
    dp2需要每次找出t1 t3 t5 中的最小值存储
    然后maxnum就是找出dp1和maxnum的最大值

    最后返回maxnum
    因为每次都是需要当前索引的前一个的值，所以一开始就把索引0存储进去了
    别忘了maxnum还需要跟第一个值比较
    万一第一个值是最大的呢
 */
import java.util.*;
public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int maxnum = -11;
        if(n==1){
            return nums[0];
        }else{
            dp1[0] = nums[0];
            dp2[0] = nums[0];
            maxnum = Math.max(maxnum,nums[0]);
            for(int i=1;i<n;i++){
                int t1 = nums[i];
                int t2 = dp1[i-1];
                int t3 = t2*t1;

                int t4 = dp2[i-1];
                int t5 = t4*t1;

                dp1[i] = Math.max(t3,t1);
                dp1[i] = Math.max(dp1[i],t5);
                dp2[i] = Math.min(t5,t1);
                dp2[i] = Math.min(dp2[i],t3);
                maxnum = Math.max(dp1[i],maxnum);
            }
        }
        return maxnum;
    }
}
