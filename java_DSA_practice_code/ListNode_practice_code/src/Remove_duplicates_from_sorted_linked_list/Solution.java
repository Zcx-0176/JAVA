package Remove_duplicates_from_sorted_linked_list;
/**
 * 定义一个哑结点dummy，dummy的next指向head
 * 这样就保证对于head头结点的处理跟链表中的节点是一样的
 * 并且保存了更新后的链表头dummy，使其能够在函数的最后返回
 * 处理删除重复元素节点的逻辑
 *    使用current指向dummy
 *    如果current.next和current.next.next不为空，循环就一直进行
 *    如果current.next.val == current.next.next.val，则说明有重复元素
 *          声明一个变量val存储这个重复元素的值，进行后续比较
 *          开启循环，删除节点
 *          while(current.next!=null && current.next.val == val)
 *          如果满足条件则  current.next = current.next.next;
 *          即把current.next的值指向current.next.next
 *          即current保持不动，current.next指向current.next.next
 *          相当于把后面的链表往前移动，这样就相当于删除了原先的current.next节点
 *          现在的新的current.next节点是原先的current.next.next节点
 *          以此类推能把重复的节点全删了
 *
 *    如果current.next.val ！= current.next.next.val
 *    证明不是重复元素
 *    就需要把current往后移动
 *    即：current = current.next;
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode current = dummy;
        while(current.next!=null && current.next.next!=null){
            if(current.next.val == current.next.next.val){
                int val = current.next.val;
                while(current.next!=null&& current.next.val == val){
                    current.next = current.next.next;
                }
            }else{
                current = current.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        Solution sol = new Solution();
        ListNode ans = sol.deleteDuplicates(head);
        while(ans!=null){
            System.out.print(ans.val+" ");
            ans = ans.next;
        }
    }
}
