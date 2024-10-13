package Array;

public class findPeakGrid {
    public int[] findPeakGrid(int[][] mat)
    {
        int rows= mat.length;
        int cols= mat[0].length;

        // bs on cols
        int left=0, right= cols-1;

        while (left<=right)
        {
            int midCol=(left+right)/2;
            int maxRow=0;
            for (int i=0; i<rows; i++)
            {
                if (mat[i][midCol] > mat[maxRow][midCol])
                {
                    maxRow=i;
                }
            }

            boolean isLeftBigger= (midCol >0 && mat[maxRow][midCol] < mat[maxRow][midCol-1]);
            boolean isRightBigger =(midCol < cols-1 && mat[maxRow][midCol]< mat[maxRow][midCol+1]);

            if(!isLeftBigger && !isRightBigger)
            {
                return new int[]{maxRow, midCol};
            } else if (isLeftBigger) {
                right=midCol-1;
            }
            else {
                left=midCol+1;
            }
        }
        return new int[]{-1, -1};


    }
}
