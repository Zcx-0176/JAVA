package code160;
/*
    注意，链表头A和B不是完全平行的两条链表的头
    看包下的图片
    链表A和B就是图片相交的那样，这就是一个链表，只不过有两个链表头罢了
    所以说题目不是判断两个平行的链表值相同的节点
    而是判断地址是否一致
    看图，相交之前A节点有A的地址 ，B节点有B的地址，相交之后A和B节点的地址一致

    使用哈希表hashset存储链表节点
    这样比较的就是节点地址，一致表明当前节点就是相交节点

 */
import java.util.*;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        Set<ListNode> hashset = new HashSet<>();
        ListNode current = headA;
        while(current != null){
            hashset.add(current);
            current = current.next;
        }
        current = headB;
        while(current!=null){
            if(hashset.contains(current)){
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
