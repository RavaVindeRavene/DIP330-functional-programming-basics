import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

enum STATE {
    DEFICIENT,
    ABUNDANT,
    PERFECT
}
public class Main {
    public static boolean isPerfect (long n)
    {
        return LongStream.rangeClosed(2, (long)Math.sqrt(n)).reduce(1, (sum, nextdiv)->
                n%nextdiv==0? sum+nextdiv+(n/nextdiv): sum )==n;
    }
    public static Set<Integer> divisors(int n) {

        Stream<Integer> numberlist=Stream.iterate(1,possiblediv->possiblediv+1).limit(n-1);
        Set<Integer> divisors =numberlist. filter(nextdiv->n%nextdiv==0).collect(Collectors.toSet());

        return divisors;
    }

    public static STATE process(int n) {
        int sum=IntStream.range(1, n).filter(nextdiv->n%nextdiv==0).sum();
        int val=Integer.compare(sum,n);
        STATE state=STATE.DEFICIENT;
        switch (val) {
            case -1:
                state= STATE.DEFICIENT;
                break;
            case 1:
                state= STATE.ABUNDANT;
                break;
            case 0:
                state= STATE.PERFECT;
                break;
        }
        return state;
    }
    public static void main(String[] args) {
	// write your code here

        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer:");
        n = s.nextInt();
       System.out.println(divisors(n));
        System.out.println(process(n));
    }
}
