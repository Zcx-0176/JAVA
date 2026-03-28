package Remove_nth_node_from_end_of_List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current1 = head;   //首先声明current1，遍历链表，获取链表长度count1
        int count1 = 0;
        while(current1!=null){
            current1=current1.next;
            count1++;
        }
        if(count1==1 && n==1){   //如果链表长度为1且n为1，则返回null
            head = null;
            return head;
        }else if(count1==1 && n!=1){  //如果count1为1但n不为1，则不用删，返回head即可
            return head;
        }
        ListNode current2 = head;     //别的情况，需要遍历找到要被删除的节点
        int count2 = 1;    //另count2=1，这是从正向查找的节点索引
        while(count2!=(count1-n+1)){   //如果count2 = count1-n+1，则找到了要被删除的节点
            current2 = current2.next;
            count2++;
        }              //比如要删除5个节点的倒数第2个节点，这样count1=5，n=2，count2=5-2+1=4,也就是正数第四个节点
        if(count2==1){   //如果count2=1，说明要删除的是头结点，需要head = head.next;
            head = head.next;
            return head;
        }
        ListNode current3 = head;      //count2！=1的情况，用count3找到count2前面一个节点
        int count3 = 1;
        while(count3!=count2-1){
            current3=current3.next;
            count3++;
        }
        ListNode ntemp = current3.next.next;   //利用count2前面一个节点，保存count2后面一个节点
        current3.next = ntemp;   //把count2前面的节点与count2后面的节点连接起来，这样就删除了count2那个节点
        return head;  //返回头节点
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);

        head.next = node1;

        Solution s = new Solution();
        ListNode result = s.removeNthFromEnd(head,1);
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
