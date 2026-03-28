package Merge_K_sorted_lists;
/**
 * 采用分治思想
 * 就是递归把一堆链表分到只有两个链表
 * 再依次从下往上合并
 * 总而言之三个函数
 *       主函数调用递归函数
 *       递归函数内设置递归返回的条件，即left> right left == right left< right各自怎么做
 *       合并函数，纯合并两个链表
 * 难点是递归函数的实现
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int left = 0;
        int right = n-1;
        return recursive(lists,left,right);

    }
    private ListNode recursive(ListNode[] lists,int left,int right){
        if(left == right){       //当left==right时，说明只有一个链表，直接返回lists[left]，由上一级递归函数接收，比如说listnodeleft
            return lists[left];
        }
        if(left > right){
            return null;     //当left>right时，说明已经没有链表了，返回null
        }
        int mid = (left+right)/2;
        ListNode listnodeleft = recursive(lists, left, mid);     //接收左半部分链表，也就是说整体有两个，这个listnodeleft接收左边那个链表
        ListNode listnoderight = recursive(lists, mid+1, right);  //listnoderight 接收右半部分那个链表
        return merge(listnodeleft,listnoderight);  //把两个链表合并为一个新链表，这个新链表也会返回上一级递归函数，被上一级的listnodeleft或者listnoderight接收
    }
    private ListNode merge(ListNode l1,ListNode l2){   //合并两个链表的函数
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        while(l1 != null){
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }
        while(l2 != null){
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        //给我合并K个链表的实例
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = null;
        ListNode head1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head1.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode head2 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        head2.next = node5;
        node5.next = null;
        ListNode[] lists = new ListNode[]{head,head1,head2};
        Solution s = new Solution();
        ListNode result = s.mergeKLists(lists);
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
