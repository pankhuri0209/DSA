package striver;

public class removenthfromend {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy= new ListNode(-1);
        dummy.next = head;
        ListNode slow= dummy;
        ListNode fast= dummy;

        while(fast!=null)

        {
            fast = fast.next;
            if(n-- <0)
            {
                System.out.println("line 25-->"+n);
                slow= slow.next;


            }
        }
        slow.next= slow.next.next;
        return dummy.next;

    }
    public static void main(String[] args)
    {

    }
}
