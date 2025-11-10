package Neetcode.greedy;

public class mergeTriplets {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x= target[0];
        int y=target[1];
        int z=target[2];
        boolean matchA= false;
        boolean matchB= false;
        boolean matchC= false;
        for(int[] trip: triplets){
            if(trip[0]>x && trip[1]>y && trip[2]>z){
                continue;
            }
            //check matches
            if(trip[0]==x){matchA=true;}
            if(trip[1]==y){matchB=true;}
            if(trip[2]==z){matchC=true;}
            // Early exit if all found
            if (matchA && matchB && matchC) return true;
        }

        return matchA && matchB && matchC;
    }
}
