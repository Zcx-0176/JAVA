package code322;
/*
    零钱找零

    递归记忆化dp太难懂了
    我这里用的是正向dp

    我的dp大小是总金额加1
    目的是索引i，表示要实现i大小金额最小要多少硬币
    显而易见dp[0]为0
    其他的先初始化为amount+1
    因为就算只有硬币面值为1的货币，需要的最小硬币数也不过是amount
    这里取更大是为了后期取最小

    然后从i=1开始循环
    在循环内部有一个对coins的每个硬币的循环
    如果当前金额i>=当前的硬币大小
    那么就对dp[i] = Math.min(dp[i],dp[i-coin]+1);
    即能凑成当前金额i的最小硬币数 = 取最小（当前金额i的硬币数 ， i-当前硬币面值的金额 所需的最小硬币数 +1 ）

    这其实就构成了动态规划转移方程
    从金额1到金额amount
    每一个金额都遍历一遍所有的硬币面值
    每次都取最小：当前dp[i]的值和dp[i-coin]+1的值
    切记dp的每个值都是取到金额i的最小硬币数
    那么dp[i-coin]就是之前的取到i-coin金额的需要的最小硬币数
    本次因为取了一次coin面值的硬币
    就需要dp[i-coin]+1  与 dp[i]取最小

    为什么要与dp[i]取最小
    因为当前金额i 循环遍历了所有硬币，有很多种不同的情况，且dp[i]初始化为amount+1
    所以就需要找出所有情况中的最小
 */
import java.util.*;
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        int max = amount+1;
        for(int i=1;i<=amount;i++){
            dp[i] = max;
        }
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(i>=coin){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        if(dp[amount]==max){
            return -1;
        }
        return dp[amount];
    }
}
