package striver;

import java.util.LinkedList;
import java.util.Queue;

public class stackusinqueues {
    class MyStack {

        private Queue<Integer> a= new LinkedList();
        private Queue<Integer> b= new LinkedList();

        public MyStack() {

        }

        public void push(int x) {
            if(a.isEmpty())
            {
                b.add(x);
            }
            else
            {
                a.add(x);
            }
        }

        public int pop()
        {
            if(a.isEmpty())
            {
                int n= b.size();
                for(int i=0;i<n-1;i++)
                {
                    a.add(b.remove());
                }
                return b.remove();
            }
            else
            {
                int n= a.size();
                for(int i=0;i<n-1;i++)
                {
                    b.add(a.remove());
                }
                return a.remove();
            }
        }



        public int top() {

            if(a.isEmpty())
            {
                int n= b.size();
                for(int i=0;i<n-1;i++)
                {
                    a.add(b.remove());
                }
                int ans= b.peek();
                a.add(b.remove());
                return ans;
            }
            else
            {
                int n= a.size();
                for(int i=0;i<n-1;i++)
                {
                    b.add(a.remove());
                }
                int ans= a.peek();
                b.add(a.remove());
                return ans;
            }
        }

        public boolean empty() {
            if(a.isEmpty() && b.isEmpty())
            {
                return true;
            }
            else
                return false;
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
