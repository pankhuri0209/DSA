package striver;


public class rotatell {
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null || k==0)
        {
            return head;
        }

        ListNode curr= head;
        int total=1;

        while(curr.next!=null)
        {
            ++total;
            curr= curr.next;
        }
        curr.next= head;
        k= k % total;
        System.out.println();
        k= total-k;
        while(k-- >0)
        {
            curr= curr.next;

        }
        head= curr.next;
        curr.next= null;
        return head;


    }
}
