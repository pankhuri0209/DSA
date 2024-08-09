package striver.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class wordsladder1 {

    class Pair{
    String first;
    int second;
        Pair(String _first, int _second){
            this.first = _first;
            this.second = _second;
        }
    }

    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(startWord,1));
        Set<String> st= new HashSet<String>();
        int len= wordList.length;
        for (int i=0;i<len;i++)
        {
            st.add(wordList[i]);
        }
        st.remove(startWord);
        while (!q.isEmpty())
        {
            String word = q.peek().first;
            int steps= q.peek().second;
            if(word.equals(targetWord) == true){return steps;}
            for(int i=0;i<word.length();i++)
            {
                for(char ch ='a'; ch<='z';ch++)
                {
                    char reaplcedCharArray[]= word.toCharArray();
                    reaplcedCharArray[i]= ch;
                    String replacedWord= new String(reaplcedCharArray);
                    if(st.contains(replacedWord) == true)
                    {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }

}
