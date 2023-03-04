package tim.arraylist;

import java.util.Random;

public class enumd {
    public static void main(String[] args)
    {
        DaysOfTheWeek weekDay= DaysOfTheWeek.TUES;
        System.out.println(weekDay);

        for(int i=0;i<10;i++)
        {
            weekDay= getRandomDay();

        if(weekDay ==DaysOfTheWeek.FRI)
        {
            System.out.println("Found a Friday!!!");
        }
        System.out.printf("Name is %s, Ordinal Value= %d%n", weekDay.name(), weekDay.ordinal());
        }
        for(Topping topping: Topping.values())
        {
            System.out.println(topping.name()+" : "+ topping.getPrice()  );
        }

    }

    public static DaysOfTheWeek getRandomDay(){
        int randomInteger = new Random().nextInt(7);
        var allDays = DaysOfTheWeek.values();
        return allDays[randomInteger];
    }
}
