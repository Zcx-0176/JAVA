package code647;
/*
    回文子串
    获取某个字符串内的所有回文子串的数量
    一是用中心扩展法

    二是用动态规划法

    下面采用动态规划法
    用二维dp表示索引i到j是否为回文子串
    状态转移方程好找
    当i和j处的字符一样，并且i+1 j-1 的dp为true（表示内部是回文）
    则当前的dp i j也是回文，赋值为true
    一个长度字符本身就是回文
    二个长度字符如果字符相等就是回文
    三个字符以上就是那个状态转移方程

    所以用len长度进行循环dp

    for循环最外侧是len
    len是回文子串长度，从1开始直到n

    然后内部for循环，从索引i=0开始到索引j=i+len-1
    开始比较这是否是回文
    然后i循环++，判断处于s内的所有子串
    当然i+len-1必须小于n，这是边界

    然后就根据len的大小不同，具体的判断逻辑不同，跟之前说的一样

 */
import java.util.*;
public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = 0;

        for(int len = 1;len<=n;len++){
            for(int i = 0; i+len-1<n ; i++){
                int j = i+len-1;
                if(len == 1){
                    dp[i][j] = true;
                    result++;
                }else if(len == 2){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                        result++;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
