package tim.arraylist.LinkedList;

import javax.naming.LimitExceededException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class challeng1_ll {

 public static void main(String [] args)
 {
     var placesTovisit= new LinkedList<String>();
     placesTovisit.add("Sydney");
     placesTovisit.add(0,"canberra");
     System.out.println(placesTovisit);
     addMoreElements(placesTovisit);
     System.out.println(placesTovisit);

   //  removeElements(placesTovisit);
   //  System.out.println(placesTovisit);
     gettingElements(placesTovisit);
    // printItenary(placesTovisit);
    // printItenary2(placesTovisit);
   //  printItenary3(placesTovisit);

     testIterator(placesTovisit);
 }
 private static void addMoreElements(LinkedList<String> list)
 {
     list.addFirst("Darwin");
     list.offerLast("Toowoomba");
     list.addLast("Hobart");

     //queue methods

     list.offer("Melbourne");
     list.offerFirst("Brisbane");


     //stack methods

     list.push("alice springs");



 }
 private static void removeElements(LinkedList<String> list)
 {
     list.remove(4);
     list.remove("Brisbane");

     System.out.println(list);
     String s1 = list.remove();
     System.out.println("Removed element ->"+s1);

     String s2= list.removeFirst();
     System.out.println("Removed element ->"+s2);

     String s3= list.removeLast();
     System.out.println("Removed element ->"+s3);

     // queue/deque poll methods

     String p1= list.poll();
     System.out.println(p1 +" was removed");
     String p2= list.pollFirst();
     System.out.println(p2+" was removed");
     String p3= list.pollLast();
     System.out.println(p3+" was removed");

     //stack add elements methods

     list.push("Sydney");
     list.push("Brisbane");
     list.push("Canberra");
     System.out.println(list);

     String p4= list.pop();
     System.out.println(p4+" was removed");

 }

 private static void gettingElements(LinkedList<String> list)
 {
     System.out.println("Retrieved Element = "+ list.get(4));
     System.out.println("First element= "+list.getFirst());
     System.out.println("Last Element === "+ list.getLast());
     System.out.println("Darwin is at position: "+list.indexOf("Darwin"));
     System.out.println("Melbourne is at position: "+ list.indexOf("Melbourne"));

     //queue retrieval method
     System.out.println("Element from element() = "+list.element());

     //stack retrieval method
     System.out.println("Element from peek() ="+list.peek());
     System.out.println("Element from peekFirst()="+list.peekFirst());
     System.out.println("Element from peekLast() = "+list.peekLast());
 }
 public static void printItenary(LinkedList<String> list)
 {
     System.out.println("Trip starts at >"+list.getFirst());
     for(int i=1;i<list.size();i++)
     {
         System.out.println("-->From: "+list.get(i-1)+" to "+ list.get(i));
     }
     System.out.println("Trip ends at >"+list.getLast());
 }
 public static void printItenary2(LinkedList<String> list)
 {
     System.out.println("Trip starts at "+list.getFirst());
     String previousTown= list.getFirst();
     for(String town: list)
     {
         System.out.println("--> From: "+previousTown +" to "+town);
         previousTown = town;
     }
     System.out.println("Trip end at "+list.getLast());
 }
    public static void printItenary3(LinkedList<String> list)
    {
        System.out.println("Trip starts at "+list.getFirst());
        String previousTown= list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);

        while(iterator.hasNext())
        {
            var town= iterator.next();
            System.out.println("--> From: "+previousTown +" to "+town);
            previousTown = town;
        }
        System.out.println("Trip end at "+list.getLast());
    }
    public static void testIterator(LinkedList<String> list)
    {
        var iterator = list.listIterator();
        while (iterator.hasNext())
        {
          //  System.out.println(iterator.next());
        if(iterator.next().equals("Brisbane"))
        {
            iterator.add("Lake Wivenhoe");
            //iterator.remove();
        }

        }
        while (iterator.hasPrevious())
        {
            System.out.println(iterator.previous());
        }
        System.out.println(list);
    }
}
