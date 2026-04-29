package code226;
/*
    翻转二叉树
    就是把每个节点的左右子节点调换顺序即可
    可以使用递归进行实现
    如果root==null 就返回root
    然后递归左右子树，用left 和 right 接收
    然后
    把root.left 赋值为接收的 right
    把root.right  赋值为接收的 left
    这样就在原先的二叉树上进行了每个左右节点的调换

    因为这是是从根节点递归，一直递归到最左子节点，然后一点点往上回溯
    这样就从叶子结点一点点调换，最终全都调换完毕

 */

import java.util.*;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left  = right;
        root.right = left;
        return root;
    }
}
