package Merge_two_sorted_lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while(list1!=null && list2!=null){
            if(list1.val>=list2.val){
                current.next = list2;
                list2 = list2.next;
            }else{
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        while(list1!=null){
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        }
        while(list2!=null){
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(4);
        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(3);
        ListNode list6 = new ListNode(4);
        list1.next=list2;
        list2.next=list3;
        list4.next=list5;
        list5.next=list6;
        Solution s = new Solution();
        ListNode result = s.mergeTwoLists(list1,list4);
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
