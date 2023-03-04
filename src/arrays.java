import java.util.*;

public class arrays {
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
        Map<Integer,Integer> map = new LinkedHashMap<>();
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
        }
        //Create an ArrayList to hold sorted elements
        ArrayList<Integer> sortedElements = new ArrayList<>();
        //Java 8 code to sort elementCountMap by values in reverse order
        //and put keys into sortedElements list

        map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    for(int i = 1; i <= entry.getValue(); i++)
                        sortedElements.add(entry.getKey());
                });
//        for(int i=0;i<sortedElements.toArray().length;i++)
//        {
//            System.out.println("62>>"+sortedElements.toArray()[i]);
//        }
//        Integer[] arr1 = new Integer[sortedElements.size()];
//        arr1 = sortedElements.toArray(arr1);
        int[] arr2 = sortedElements.stream().mapToInt(i -> i).toArray();
        return arr2;
    }
}
