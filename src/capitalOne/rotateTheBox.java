package capitalOne;

public class rotateTheBox {

    public char[][] rotateTheBox(char[][] box)
    {
        box= rotate(box);
        freeFall(box);
        return box;
    }

    public void freeFall(char[][] box)
    {
        int n= box.length;
        int m= box[0].length;

        for (int c=0;c<m;c++)
        {
            int lastEmpty= n-1;
            for (int r= n-1; r>=0; r--)
            {
                char v= box[r][c];
                if (v=='.')
                {

                } else if (v=='*') {
                    lastEmpty =r-1;
                } else if (v=='#') {
                    box[r][c]='.';
                    box[lastEmpty][c]='#';
                    lastEmpty--;
                }
            }
        }
    }
    public char[][] rotate(char[][] box)
    {
        int n= box.length, m=box[0].length;
        char[][] res = new char[m][n];

        for (int i=0, c=n-1;i<n ; c--, i++)
        {
            for (int j=0, r=0;j<m; r++, j++)
            {
                res[r][c] = box[i][j];

            }
        }
        return res;
    }



}
