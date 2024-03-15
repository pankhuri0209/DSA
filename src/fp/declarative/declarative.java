package fp.declarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//In declarative programming, it is high level programming style,  one of the types of functional programming

public class declarative {

    public static void main(String[] args)
    {
        Integer[] a= {3,4,5,1,2,7};
        List<Integer> list= new ArrayList<>(Arrays.asList(a));
        list.stream().filter(b->b==7).forEach(System.out::print);

    }

}
