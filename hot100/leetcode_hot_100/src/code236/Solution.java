package code236;
/*
    二叉树最近公共祖先
    使用递归进行查找
    如果当前传入的root节点为空或者为p或者为q
    则直接返回root节点，因为为空证明root=null，返回的是null
    如果root=p证明已查找到p，直接返回p，即root
    如果root=q证明以查找到q，直接返回q，即root

    然后开始递归root的左右子树
    使用left  和  right 接收
    如果left==null  证明当前root的左子树一直查找到null都没有p或q
    证明p和q都在右子树，所以返回right

    如果right==null，同理p和q都在左子树，返回left

    剩下的就是左右子树都不为null，证明左右子树各有一个q或p
    所以当前的root就是最近的公共祖先节点

    然后假如说上面还有节点可以递归回去，那么又变成了一个子树为null一个子树不为null的情况，
    所以最终的返回结果不会变，依旧是查找的那个最近公共祖先节点
 */
import java.util.*;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
}
