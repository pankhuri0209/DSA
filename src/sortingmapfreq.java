import java.util.*;

public class sortingmapfreq {
    public static void main (String[] args) {
        //code
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        List<int[]> list= new ArrayList<int[]>();
        for(int j=0;j<t;j++)
        {
            int n= sc.nextInt();
            int[] arr= new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]= sc.nextInt();

            }
            arr=sorting(arr,n);
            list.add(arr);
        }

        Iterator itr= list.iterator();
        while(itr.hasNext())
        {
            int[] p= new int[5];
            p= (int[])itr.next();
            System.out.println(Arrays.toString(p).replace(",","").replace("[","").replace("]",""));
        }
    }
    public static int[] sorting(int[] arr, int n)
    {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();

        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i],1);
            }
            outputArray.add(arr[i]);
        }
        // Compare the map by value
        SortComparator comp = new SortComparator(map);

        // Sort the map using Collections CLass
        Collections.sort(outputArray,comp);

        int[] arr2 = outputArray.stream().mapToInt(i -> i).toArray();
        return arr2;
    }
    static class SortComparator implements Comparator<Integer> {
        private final Map<Integer, Integer> freqMap;

        // Assign the specified map
        SortComparator(Map<Integer, Integer> tFreqMap) {
            this.freqMap = tFreqMap;
        }
// 5 5 4 6 4
// 2 5 9 9 9 >> 9 9 9 2 5

        // Compare the values
        @Override
        public int compare(Integer k1, Integer k2) {

            // Compare value by frequency
            int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

            // Compare value if frequency is equal
            int valueCompare = k1.compareTo(k2);

            // If frequency is equal, then just compare by value, otherwise -
            // compare by the frequency.
            if (freqCompare == 0)
                return valueCompare;
            else
                return freqCompare;
        }
    }
}
