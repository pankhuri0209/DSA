package striver;

public class atoi {
    public static int myAtoi(String s) {
        StringBuilder result = new StringBuilder();
        s= s.replaceAll("\\s","");
        Character check = null;
        int n=s.length();
        if(n>0){
            check= s.charAt(0);
        }
        if(n>1 && s.charAt(0)=='-' && s.charAt(1)=='+')
        {
            return 0;
        }
        boolean flag= false;
        if(check!=null )
        {
            if( check== '-')
                 flag= true;
            else if(check=='+')
                flag=false;
        }
        s= s.replaceFirst("^-","");
        for(int i=0;i<s.length();i++)
        {
            if(flag==true)
            {
                result.append("-");
                flag= false;
                i=-1;
                continue;
            }
            if(n>1 && s.charAt(1)=='0' )
            {
                continue;
            }
            Character c= s.charAt(i);
            if(Character.isDigit(c))
            {
                result.append(c);
            }
            else if(Character.isAlphabetic(c) || c=='-')
            {
                break;
            }
        }
        if(result.toString().equals(""))
        {
            return 0;
        }
        long parsedLong = 0l;
        parsedLong = Long.parseLong(result.toString());
        // Check for overflow/underflow
        if (parsedLong > Integer.MAX_VALUE ) {
            return Integer.MAX_VALUE;
        }
        if ( parsedLong < Integer.MIN_VALUE) {
            return  Integer.MIN_VALUE ;
        }
        // try {
        //     parsedInt = Integer.parseInt(result.toString());
        // } catch (NumberFormatException e) {
        //     if (result.charAt(0) == '-') {
        //         return Integer.MIN_VALUE;
        //     } else {
        //         return Integer.MAX_VALUE;
        //     }
        // }
        return (int)parsedLong;
    }
    public static void main(String[] args)
    {
        String input="-1";
        int res= myAtoi(input);
        System.out.println(res);
        // System.out.println(frequencyCount(L,N,P ));
    }
}
