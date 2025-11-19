package Neetcode.greedy;

public class checkValidString {
    public boolean checkValidString(String s) {
        int low=0, high=0;
        for(char c:s.toCharArray()){
            if(c=='(')
            {
                low++;
                high++;
            }
            if(c==')')
            {
                if(low>0) low--;
                high--;
            }
            else if (c=='*')
            {
                if(low>0) low--; //')'
                high++; //'('
            }
            if (high<0) high--;
        }
        return low==0;
    }
}
