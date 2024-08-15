package capitalOne;

public class candyCrush {

    public int[][] candyCrush(int[][] board)
    {
        if(board==null || board.length==0)
        {
            return board;
        }
        boolean flag=true;
        int rows = board.length, cols= board[0].length;

        for (int i=0;i<rows;i++)
        {
            for (int j=0;j<cols-2;j++)
            {
                int num1= Math.abs(board[i][j]);
                int num2= Math.abs(board[i][j+1]);
                int num3= Math.abs(board[i][j+2]);
                if(num1 ==num2 && num2==num3 && num1!=0)
                {
                    board[i][j]= -num1;
                    board[i][j+1]= -num2;
                    board[i][j+2]=-num2;
                    flag=false;
                }
            }
        }

        for(int j=0;j<cols;j++)
        {
            for (int i=0;i<rows-2;i++)
            {
                int num1= Math.abs(board[i][j]);
                int num2= Math.abs(board[i+1][j]);
                int num3= Math.abs(board[i+2][j]);
                if(num1==num2 && num2==num3 && num1!=0)
                {
                    board[i][j]=-num1;
                    board[i+1][j]= -num2;
                    board[i+2][j]= -num3;
                    flag=false;
                }
            }
        }

        if(!flag)
        {
            for (int j=0;j<cols;j++)
            {
                int idx = rows-1;
                for (int i= rows-1;i>=0 ;i--)
                {
                    if(board[i][j]>0)
                    {
                        int temp= board[idx][j];
                        board[idx][j]= board[i][j];
                        board[i][j]= temp;
                        idx--;
                    }
                    else {
                        board[i][j]=0;
                    }
                }
            }
        }
        return (flag)?board: candyCrush(board);


    }
}
