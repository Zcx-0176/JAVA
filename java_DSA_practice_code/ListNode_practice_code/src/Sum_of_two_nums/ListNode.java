package Sum_of_two_nums;

public class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){   //有参构造器
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
