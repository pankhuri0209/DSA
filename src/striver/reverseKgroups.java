package striver;

public class reverseKgroups {

//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {

            ListNode temp =head;
            ListNode prevLast= null;

            while(temp!=null)
            {
                ListNode KthNode= getKthNode(temp, k);
                if(KthNode==null)
                {
                    if(prevLast!=null)
                    {
                        prevLast.next= temp;
                    }
                    break;
                }
                ListNode nextNode= KthNode.next;
                KthNode.next= null;

                reverseList(temp);
                if(temp== head)
                {
                    head= KthNode;
                }
                else
                {
                    prevLast.next= KthNode;
                }
                prevLast= temp;
                temp= nextNode;


            }

            return head;
        }
        public ListNode reverseList(ListNode head)
        {
            ListNode temp= head;
            ListNode prev= null;
            while(temp!=null)
            {
                ListNode next= temp.next;
                temp.next= prev;
                prev= temp;
                temp= next;

            }
            return prev;
        }

        public ListNode getKthNode(ListNode temp, int k)
        {
            k-=1;
            while( temp!=null && k>0)
            {
                k--;
                temp= temp.next;
            }
            return temp;
        }


    }
}
