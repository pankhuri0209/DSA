package roblox;

public class minNumberOfFrogs {

    public int minNUmberOfFrogs(String croakOFFrogs)
    {
        if(croakOFFrogs.length() %5!=0)
        {
            return -1;
        }
        int[] count= new int[5];
        int frogs=0;
        int maxFrogs=0;
        for (char c: croakOFFrogs.toCharArray())
        {
            switch (c)
            {
                case 'c':
                    count[0]++;
                    frogs++;
                    if (frogs > maxFrogs){maxFrogs = frogs;}
                    break;
                case 'r':
                    if (count[0] > count[1]){ count[1]++;}
                    else{ return -1;}
                    break;
                case 'o':
                    if(count[1] > count[2]){count[2]++;}
                    else {return -1;}
                    break;
                case 'a':
                    if(count[2]> count[3]){count[3]++;}
                    else {return -1;}
                    break;
                case 'k':
                    if(count[3]> count[4]){count[4]++;}
                    else{return -1;}
                    break;
            //    elsedefault:


            }
        }
        if(frogs ==0 && count[0] == count[1] && count[1]== count[2] && count[2]== count[3] && count[3]== count[4])
        {
            return maxFrogs;
        }
        return -1;
    }
}
