package code234;
/*
    回文链表
    判断一个链表是否是回文链表
    方法一就是把链表每个结点的值给数组，然后用左右指针进行依次判断是否相同

    方法二就是获取链表中间节点，把后面的链表反转，然后使用快慢指针挨个比较
 */
import java.util.*;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while(current!=null){
            list.add(current.val);
            current = current.next;
        }
        int n = list.size();
        int left = 0;
        int right = n-1;
        boolean istrue = true;
        while(left<right){
            int le = list.get(left);
            int ri = list.get(right);
            if(le!=ri){
                istrue = false;
                break;
            }
            left++;
            right--;
        }
        return istrue;
    }
}
