import java.util.*;
//import java.util.Scanner;
enum STATE {
    DEFICIENT,
    ABUNDANT,
    PERFECT
}

public class LD1_1 {
    public static int sum;
    public static Set<Integer> divisors(int n) {
        sum=0;
        Set<Integer> divisors = new HashSet<>();
        for (int i=1; i<n; i++) {
            if (n%i==0) {
                divisors.add(i);
                sum += i;
            }
        }
       return divisors;
    }
    public static STATE process(int n) {
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

    public static void main(String[] args){

        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer:");
        n = s.nextInt();
        //divisors(n);
        System.out.println(divisors(n));
        //process(n);
        System.out.println(process(n));
    }
}
