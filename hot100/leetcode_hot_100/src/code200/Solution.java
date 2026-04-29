package code200;
/*
    岛屿数量
    先用number记录总的1的数量
    实际上就用dfs进行搜索相邻的1
    每次搜索到1就count++
    每次dfs返回到主函数，也就是某一轮次的一堆1搜索完毕后
    就把count的值和number的值作比较
    如果小于等于证明本次成功搜索到了一个岛屿

    主函数如何判断是否进行dfs
    grid数组对应位置为1，并且visited数组对应位置为0

    dfs内部如何进行深度优先搜索
    首先将遍历到的位置的visited置为1
    然后进行while循环
    循环终止条件是两个索引触摸到grid数组边界
    然后进行四个if判断
    分别找当前索引i,j的上下左右，看其grid为1且visited为0
    就dfs
    如果这四个都没有，证明周围要么已经是遍历过的1，要么是0，直接退出循环
    然后执行循环外的代码，即把visited置为2，表明遍历完成
    然后函数自动返回了
 */
import java.util.*;
public class Solution {
    int count = 0;
    int number = 0;
    int result = 0;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    number++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    dfs(grid,visited,i,j);
                    if(count<=number){
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public void dfs(char[][] grid,int[][]visited,int i,int j){
        visited[i][j] = 1;
        count++;
        int m = grid.length;
        int n = grid[0].length;
        while(i-1>=0 || i+1<m || j-1>=0 || j+1<n){
            if(i-1>=0 && grid[i-1][j]=='1' && visited[i-1][j]==0){
                dfs(grid,visited,i-1,j);
            }
            if(i+1<m && grid[i+1][j]=='1' && visited[i+1][j]==0){
                dfs(grid,visited,i+1,j);
            }
            if(j-1>=0 && grid[i][j-1]=='1' && visited[i][j-1]==0){
                dfs(grid,visited,i,j-1);
            }
            if(j+1<n && grid[i][j+1]=='1' && visited[i][j+1]==0){
                dfs(grid,visited,i,j+1);
            }
            break;
        }
        visited[i][j] = 2;
    }
}
