package code221;
/*
    最大正方形，找出只包含1的最大正方形，返回其面积
    先找到最大边长，然后用边长的平方即可得到结果
    使用动态规划
    dp[i][j]表示以i,j为右下角的正方形最大边长
    初始化。值为0的赋值dp对应点为0
    值为1的赋值dp对应点为1
    从第二行第二列开始遍历到最后，依次找左边，上边，左上边三个相邻的dp的值
    因为他们也是存储了以他们为右下角组成的最大正方形边长
    比如是2 2 2，那么当前的i,j选择三个里的最小值，加一
    这说明了，左边，上边，左上边以他们为右下角组成的最大正方形边长为2
    那么当前的i，j能跟他们组成更大的正方形，边长加1

    那如果是 2 2 1呢，上边的相邻点为1，证明在上边的2*2中有0，所以就不能组成3*3
    只能根据当前的i，j和相邻的三个点组成2*2，即当前dp为1+1=2

    这就是为什么要取最小
 */
import java.util.*;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=1;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(dp[i][j]!=0){
                    int left = dp[i][j-1];
                    int leftup = dp[i-1][j-1];
                    int up = dp[i-1][j];
                    int t1 = Math.min(left,leftup);
                    int t2 = Math.min(t1,up);
                    dp[i][j] = t2+1;
                }
            }
        }
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        int result = max*max;
        return result;
    }
}
