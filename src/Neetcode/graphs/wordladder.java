package Neetcode.graphs;
import  java.util.*;

public class wordladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> dict = new HashMap<>();
        int len= beginWord.length();

        for(String w: wordList)
        {
            for(int j=0; j<len; j++)
            {
                String pat= w.substring(0,j) +'*' + w.substring(j+1);
                dict.computeIfAbsent(pat, k->new ArrayList<>()).add(w);
            }
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level= 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                String word = q.remove();
                if(word.equals(endWord)) return level;

                for (int j=0; j<len; j++)
                {
                    String pat= word.substring(0,j) +'*' + word.substring(j+1);
                    for(String adj : dict.getOrDefault(pat, Collections.emptyList()))
                    {
                        if (!visited.contains(adj))
                        {
                            visited.add(adj);
                            q.offer(adj);
                        }
                    }
                }

            }
        }

        return 0;
    }
}