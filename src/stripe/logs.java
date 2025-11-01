package stripe;

import java.util.Arrays;

public class logs {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b)->
        {
           int i= a.indexOf(' ');
           int j= b.indexOf(' ');
           String idA= a.substring(0,i);
           String idB= b.substring(0,j);
           String contA= a.substring(i+1);
           String contB= b.substring(j+1);

           boolean digitA= Character.isDigit(contA.charAt(0));
           boolean digitB= Character.isDigit(contB.charAt(0));

           if (!digitA && !digitB) // both letters logs
           {
               int cmp= contA.compareTo(contB);
               if (cmp!=0)
               {
                   return cmp;
               }
               return idA.compareTo(idB);
           }
           if (!digitA){return -1;}
           if (!digitB){return 1;}
           return 0;
        });
        return logs;
    }
    public String[] reorderLogFiles1(String[] logs) {
        Arrays.sort(logs, (a,b)->
        {
           int i= a.indexOf(' ');
           int j= b.indexOf(' ');
           String idA= a.substring(0,i);
           String idB= b.substring(0,j);
           String contA= a.substring(i+1);
           String contB= b.substring(j+1);
           boolean digitA= Character.isDigit(contA.charAt(0));
           boolean digitB= Character.isDigit(contB.charAt(0));
           if(!digitA && !digitB)
           {
               int cmp= contA.compareTo(contB);
               if(cmp!=0)
               {
                   return cmp;
               }
               return idA.compareTo(idB);
           }
           if(!digitA){return -1;}
           if(!digitB){return 1;}
           return 0;
        });
        return  logs;
    }
}
