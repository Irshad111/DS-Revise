package stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamQ {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] ={1,7,4,5,1,2,8,2,3};

        Arrays.stream(arr).filter(a-> a%2==0).forEach(a-> System.out.print(a));
        System.out.println("------sorted array-----");
        Arrays.stream(arr).sorted().forEach(a -> System.out.print(a));
        System.out.println("-----even num sum");
        int evenNumberSum=Arrays.stream(arr).filter(a-> a%2==0).reduce(0,(sum,i)->i+sum);
        System.out.println(evenNumberSum);
        Arrays.stream(arr).distinct().forEach(a-> System.out.print(a));
        System.out.println("---max-----");
        int max=Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
        int a=1;
        long count=Arrays.stream(arr).filter(i->i==a).count();
        System.out.println(count);
        List<String> list =Arrays.asList("a","b");// resturn fixed size list we can not remove and add but we can change element
       // list.add("c"); gives UnsupportedOperationException at run time
        //list.remove(); gives UnsupportedOperationException
        list.set(0,"c"); //it,s possible
        System.out.println(list);

        List<String> list1=List.of("a","b"); // return unmodifiable list
        // list1.add("c"); gives UnsupportedOperationException at run time
        //list1.remove(); gives UnsupportedOperationException
        //list1.set(0,"c"); gives UnsupportedOperationException
        System.out.println(list1);
        String s = "  abc  def\t";

        s = s.strip();

        System.out.println(s);





    }
}
