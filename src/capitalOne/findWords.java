package capitalOne;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode{

    HashMap<Character, TrieNode> children= new HashMap<>();
    String word= null;
    public TrieNode(){}

}

public class findWords {
    char[][] _board= null;
    ArrayList<String> _result= new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words)
    {
        TrieNode root= new TrieNode();
        for (String word: words)
        {
            TrieNode node= root;
            for(Character letter: word.toCharArray())
            {
                if (node.children.containsKey(letter))
                {
                    node = node.children.get(letter);
                }
                else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node= newNode;
                }
            }
            node.word= word;
        }
        this._board = board;

        //backtracking
        for (int row=0;row<board.length;++row)
        {
            for (int col=0;col<board[row].length;++col)
            {

                if (root.children.containsKey(board[row][col]))
                {
                    backtracking(row,col, root);
                }
            }
        }
        return this._result;
    }
    private  void backtracking(int row, int col, TrieNode parent)
    {
        Character letter= this._board[row][col];
        TrieNode currNode = parent.children.get(letter);

        //check if there is any match
        if(currNode.word !=null)
        {
            this._result.add(currNode.word);
            currNode.word= null;
        }
        // mark the current letter before the exploration
        this._board[row][col]= '#';

        //explore neighor clock wsise : up, right, down left
        int[] rowOffset= {-1,0,1,0};
        int[] colOffset={0,1,0,-1};
        for (int i=0;i<4;i++)
        {
            int newRow= row+ rowOffset[i];
            int newCol= col+ colOffset[i];

            if (newRow<0 || newRow >= this._board.length || newCol<0 || newCol>=this._board[0].length)
            {
                continue;
            }
            if (currNode.children.containsKey(this._board[newRow][newCol]))
            {
                backtracking(newRow, newCol, currNode);
            }

        }
        //end of exploration
        this._board[row][col] =letter;

        //incrementally remove the leaf nodes
        if (currNode.children.isEmpty())
        {
            parent.children.remove(letter);
        }
    }

}
