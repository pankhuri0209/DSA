package Recursion.sudoko;

public class sudoko {

    public static boolean solveSudoku(char grid[][])
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='.')
                {
                    for(char digit=1;digit<=9;digit++)
                    {
                        if(isPossible(grid,i,j,digit))
                        {
                            grid[i][j]= digit;
                            if(solveSudoku(grid)){return true;}
                            else {grid[i][j]='0';
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean isPossible(char grid[][], int row, int col, char digit)
    {
        for(int i=0;i<9;i++) {
            if (grid[row][i] == digit) {
                return false;
            } else if (grid[i][col] == digit) {
                return false;
            } else {
                int ogrow = 3 * (row / 3), ogcol = 3 * (col / 3);
                if (grid[ogrow + i / 3][ogcol + i % 3] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}
