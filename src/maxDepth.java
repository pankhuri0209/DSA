public class maxDepth {
    public static void main(String[] args)
    {
     String S=" (43+4++3)((3)(9))+1)";
     int ans= maxDepth(S);
     System.out.printf(String.valueOf(ans));
    }

    public static int maxDepth(String S)
    {
        int current_max=0; //current count
        int max=0; // overall max count

        //traverse the input string
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i) == '(')
            {
                current_max++;

                //update max if required
                max= Math.max(current_max,max);
            }
            else if(S.charAt(i) == ')')
            {
                if(current_max >0)
                {
                    current_max--;
                }
                else
                {
                    return -1;
                }

            }
        }
        if(current_max !=0)
        {
            return -1;
        }

        return  max;
    }

}
