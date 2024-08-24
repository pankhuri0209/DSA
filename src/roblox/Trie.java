package roblox;

public class Trie {
    private class TrieNode{
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord= false;
        }
    }
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    // insert a word into the trie

    public void insert(String word)
    {
        TrieNode node = root;
        for (char c: word.toCharArray())
        {
            int index= c-'a';
            if (node.children[index] ==null)
            {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];

        }
        node.isEndOfWord = true;
    }

    // search for a complete word in the trie

    public boolean search(String word)
    {
        TrieNode node= root;
        for (char c: word.toCharArray())
        {
            int index= c-'a';
            if (node.children[index] ==null)
            {
                return false;
            }
            node= node.children[index];
        }
        return node.isEndOfWord;
    }
    //
    public boolean strartWith(String prefix)
    {
        TrieNode node = root;
        for (char c: prefix.toCharArray())
        {
            int index= c-'a';
            if (node.children[index] ==null)
            {
                return false;

            }
            node= node.children[index];
        }
        return  true;
    }
}
