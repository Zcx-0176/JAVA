package code139;
/*
    单词划分
    这是动态规划
    字符串长度为n
    dp数组长度为n+1
    dp[0]设置为true

    为什么要这么设计？
    dp[i]表示从0 到 i 能否根据字典集划分成功
    dp[0]表示空字符串，一定能划分成功
    这也是为了后续动规能成功的基础

    如何能判断 0  到  i能划分成功？
    加入一个变量j
    如果dp[j]为true 并且字符串j到i的部分能在字典集中找到
    那么dp[i]为true，即划分成功

    循环到最后dp[n]就是整个字符串能否划分成功

    实例：
    s = "leetcode", wordDict = ["leet", "code"]
    初始化boolean[] dp = new boolean[n+1];，全为false
    从0开始 dp[0]=true  默认空字符串能划分成功
    然后i=1 dp[1]要判断dp[0]和字符串索引[0,1)的部分是否在字典集，经判断后者不在，不改变dp[1[的值
    然后i=2,dp[2]要判断dp[0] [0,2)   dp[1] [1,2)
    然后i=3,dp[3]要判断dp[0] [0,3)   dp[1] [1,3)  dp[2] [2,3)
    然后i=4,dp[4]要判断dp[0] [0,4)   dp[1] [1,4)  dp[2] [2,4)  dp[3] [3,4)
    以此类推
    这其实是双重循环，枚举划分所有可能，只要有一种可能，那么当前i以前的字符串就可以被划分成功

    必须得有dp[0]设置为true
    不然动规无法实现
    因为dp[i]表示的是字符串[0,i)部分是否可以被划分成功
    那如果i=0,0之前是空的，所以dp[0]设置为true
    这是每次i为新的值时，j从0开始遍历时必有的一步

 */
import java.util.*;
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hashset = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && hashset.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
