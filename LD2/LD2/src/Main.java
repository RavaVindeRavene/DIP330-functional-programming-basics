import java.util.*;

public class Main {

        static boolean palindrome(String s){
            if (s.length()==0 or s.length()==1)
                return true;
            if (s.charAt(0)==s.charAt(s.length()-1))
                return palindrome(s.substring(1,s.length()-1));
            return true;
        }
        public enum STATE(boolean bool){
            Palindrome, NotaPalindrome;
        }

    public static void main(String[] args) {
	// write your code here
        Scanner scan =new Scanner(System.in);
        System.out.println('Ievadiet vāru:');
        String strg=scanner.nextLine();
        boolean check =palindrome(strg);
        if (check){
            System.out.println(STATE.Palindrome);
        }else{
            System.out.println(STATE.NotaPalindrome);
        }
    }
}
