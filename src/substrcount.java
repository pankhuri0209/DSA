import java.util.HashMap;

public class substrcount {
    public static void main(String[] args) throws Exception {
        String S="abaaca";
        long ans= substrcount(S,1);
        System.out.printf(String.valueOf(ans));
    }
    static boolean isValid(String s, int k)
    {
        if(s.length()<k)return false;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!(map.containsKey(c)))
            {
                map.put(c,i);
            }
        }
        if(map.size() ==k)
        {
            return true;
        }
        return false;
    }


static long substrcount(String s, int k)
{
    long ans=0;
    for(int i=0;i<s.length();i++)
    {
        for(int j=i+k;j<=s.length();j++)
        {
          if(isValid(s.substring(i,j),k))
          {
              ans++;
          }
        }
    }
    return ans;
}


}
