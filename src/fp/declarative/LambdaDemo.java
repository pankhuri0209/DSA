package fp.declarative;

import javax.swing.plaf.TableHeaderUI;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class LambdaDemo {

    @FunctionalInterface
    public interface GreatDivide{
        int divide(int t1,int t2);
        //int ss();

    }
    public static void simpleLambda(){

        GreatDivide intDivide = (int x, int y) ->(x/y);
        System.out.println(intDivide.divide(21,7));
    }

    public static  void main(String[] args)
    {
        LambdaDemo.simpleLambda();
        runnableAnonymous();
        runnableAnonymous2();
        runnableLambda();
        runnableLambda2();
        simpleStream();
        simplePredicate();
        getTotal();
    }

    static void runnableAnonymous(){
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                System.out.println("Run rAnonymouns, run!");
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }
    static void runnableAnonymous2()
    {
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside RunnableAnonymous2 method");
            }
        });
        thread.start();
    }
    static  void runnableLambda(){
        Runnable runnable= ()->System.out.println("run thread in bg...");
        Thread thread= new Thread(runnable);
        thread.start();
    }
    static void runnableLambda2(){
        Thread thread= new Thread(()->System.out.println("Inside runnablelambda2"));
        thread.start();
    }
    public static  void simpleStream(){
        List<Integer> list= Arrays.asList(5,2,4,1,3);
        list.forEach(n->System.out.println(n+" "));
        System.out.println("reduce to sorted odd subset");
        list.stream().filter(i-> i%2==1)
                .sorted()
                .map(n-> 100*n)
                .forEach(n-> System.out.print(n+ ","));
        System.out.println();

    }

    public static void simplePredicate(){
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Predicate<Integer> predicate = n-> {return n>5;};
        for(Integer n: ints)
        {
            if(predicate.test(n)){
                System.out.print(n+ "<**");
            }
            else {
                System.out.print(n+ " ");
            }
        }
    }
    public static final void getTotal(){

        final List<Double> prices= Arrays.asList(5.0,10.0,15.0,20.0);
        final Double total = prices.stream().mapToDouble((Double price)->price*0.9).sum();
        System.out.println();
        System.out.println("Total: $"+total);
    }

}
