package striver.bst;

import java.util.*;

public class topViw {
        static ArrayList<Integer> topView(Node1 root)
        {
            ArrayList<Integer> result =new ArrayList<>();
            HashMap<Integer,Node1> hm= new HashMap<>();

            Queue<Pair> q= new LinkedList<>();
            q.add(new Pair(root ,0));
            q.add(null);
            int min=0;
            int max=0;
            while (!q.isEmpty())
            {
                Pair curr= q.remove();
                if(curr==null)
                {
                    if(q.isEmpty())
                    {
                        break;
                    }
                    else {
                        q.add(null);
                    }
                }
                else {
                    if(!hm.containsKey(curr.line)){
                        hm.put(curr.line, curr.node);
                    }
                    if(curr.node.left!=null)
                    {
                        q.add(new Pair(curr.node.left,curr.line-1));
                        min= Math.min(min, curr.line-1);
                    }
                    if (curr.node.right!=null)
                    {
                        q.add(new Pair(curr.node.right,curr.line+1));
                        max=Math.max(max,curr.line+1);
                    }

                }
            }
            for (int i=min;i<=max;i++)
            {
                result.add(hm.get(i).data);
            }
            return result;

        }
}
