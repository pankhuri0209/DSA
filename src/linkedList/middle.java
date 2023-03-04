package linkedList;

class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
public class middle {


    int getMiddle(Node head)
    {
        // Your code here.
        int count=0;
        Node curr= head;
        while(curr!=null)
        {
            count++;
            curr= curr.next;
        }
        int mid=0;
        if(count%2==0)
        {
            mid= count/2 +1;
        }
        else
        {
            mid= count/2;
        }
        Node midd=head;
        for(int i=0;i<mid;i++)
        {
            midd=midd.next;
        }
        return midd.data;
    }
}
