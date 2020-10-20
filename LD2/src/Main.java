import java.util.Scanner;
import java.util.*;
public class Main {

    static boolean palindrome(String s){
        if (s.length()==0 || s.length()==1)
            return true;
        if (s.charAt(0)==s.charAt(s.length()-1))
            return palindrome(s.substring(1,s.length()-1));
        return false;
    }
    static void Check(boolean bool){
        if (bool){
            System.out.println("Palindrome");
        }else{
            System.out.println("NotaPalindrome");
        }
    }

    public static void main(String[] args) {
        // write your code here
        Scanner scan =new Scanner(System.in);
        System.out.println("Ievadiet vāru:");
        String strg=scan.nextLine();
        boolean check =palindrome(strg);
        Check(check);
    }
}
