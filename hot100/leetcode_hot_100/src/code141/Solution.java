package code141;

import java.util.*;
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> hashset = new HashSet<>();
        ListNode current = head;
        while(current != null){
            if(hashset.contains(current)){
                return true;
            }else{
                hashset.add(current);
            }
            current = current.next;
        }
        return false;
    }
}
