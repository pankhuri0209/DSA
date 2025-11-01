package stripe;

public class buildtrie {
    class Trie {
        private TrieNode root;

        public class TrieNode {
            boolean isEnd;
            TrieNode[] children;
            public TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode node = root;
            for(char c: word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index]= new TrieNode();
                }
                node = node.children[index];
            }
        }
        public boolean search(String word) {
            TrieNode node = root;
            for(char c: word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.isEnd;
        }
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(char c: prefix.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }
    }
}
