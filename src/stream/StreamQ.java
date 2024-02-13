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



    }
}