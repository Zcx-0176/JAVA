package code124;
/*
    二叉树中的最大路径和

    这不是常规的数组dp
    而是递归的树形dp
    用递归返回值存储dp状态

    使用dfs递归的树形dp
    以当前节点为起点，向下的最大单侧路径和
    用left 和 right接收左侧递归返回值和右侧递归返回值
    这个单侧路径和不能是负数，如果是负数，证明这一侧的路径和加上去就肯定小
    所以需要把left  right 分别跟0取最大

    然后要自私的试试
    左侧路径和+当前节点值+右侧路径和   看看是不是最大的，用max去更大的值

    之后往上返回的时候，只能返回一侧路径，返回路径和更大的那一侧
    因为是一条路径，在求最大路劲和的时候是通过当前节点作为最高点，把左右路径串起来
    但是递归返回的话，如果左右都返回直接就多条路径了，直接就错了
    所以递归返回max(left,right)
    当然了，这得加上当前节点的值
    因为往上递归返回肯定得包含了当前节点，当前节点的值也得加上返回
 */
import java.util.*;
public class Solution {
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        left = Math.max(left,0);
        right = Math.max(right,0);

        max = Math.max(root.val+left+right,max);

        return root.val+Math.max(left,right);
    }
}
