package striver.graphs;

import java.util.*;

public class wordsladder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String > wordList)
    {
        List<List<String>> res= new ArrayList<>();
        Set<String> wordSet= new HashSet<>();

        if(!wordSet.contains(endWord))
        {
            return  res;
        }

        // bfs to find the shortest path length and build the graph

        Map<String,List<String>> graph= new HashMap();
        Map<String, Integer> distance= new HashMap<>();

        wordSet.add(beginWord);

        for(String word: wordSet)
        {
            graph.put(word, new ArrayList<>());
        }
        bfs(beginWord, endWord, wordSet, graph, distance);

        //dfs to find all paths with the shortest length
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, graph, distance, path, res);
        return res;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> graph, Map<String,Integer> distance)
    {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord,0);

        while (!queue.isEmpty())
        {
            String currentWord= queue.poll();
            int currentDistance = distance.get(currentWord);
            List<String> neighbors= getNeighbors(currentWord, wordSet);

            for (String neibor: neighbors)
            {
                graph.get(currentWord).add(neibor);
                if(!distance.containsKey(neibor))
                {
                    distance.put(neibor, currentDistance+1);
                    if (neibor.equals(endWord))
                        break;
                    else
                        queue.offer(neibor);
                }
            }

        }

    }
    private void dfs(String currentWord, String endWord, Map<String, List<String>> graph, Map<String, Integer> distance, List<String> path, List<List<String>> res)
    {
        if(currentWord.equals(endWord))
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String neibor: graph.get(currentWord))
        {
            if (distance.get(neibor) == distance.get(currentWord)+1)
            {
                path.add(neibor);
                dfs(neibor, endWord, graph, distance, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    private  List<String> getNeighbors(String word, Set<String> wordSet)
    {
        List<String> neighbors= new ArrayList<>();
        char[] charArray= word.toCharArray();
        for(int i=0;i<charArray.length;i++)
        {
            char origionalChar= charArray[i];
            for(char c='a';c<='z';c++)
            {
              if (c==origionalChar) {continue;}
              charArray[i] = c;
              String newWord= new String(charArray);
              if(wordSet.contains(newWord))
              {
                  neighbors.add(newWord);
              }
            }
            charArray[i] =origionalChar;
        }
        return neighbors;
    }
}
