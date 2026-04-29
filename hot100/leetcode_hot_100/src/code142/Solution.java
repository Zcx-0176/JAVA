package code142;
/*
    环形链表
    判断是否有环
    有环直接返回环的头节点

    可以直接使用哈希表
    hashset存储以链表类为数据结构的每个链表节点
    不能存储节点的值
    因为值相同不一定节点地址相同
    所以存储节点地址肯定是不同的
    一旦存储的节点地址相同
    证明肯定是找到环了
    直接返回当前链表节点即可
 */
import java.util.*;
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> hashset = new HashSet<>();
        ListNode current = head;
        while(current != null){
            if(hashset.contains(current)){
                return current;
            }else{
                hashset.add(current);
            }
            current = current.next;
        }
        return null;
    }
}
