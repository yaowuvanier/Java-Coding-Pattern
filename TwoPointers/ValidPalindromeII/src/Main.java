import java.util.Arrays;

/**
 * @author Yao Wu~
 * @version 1.0
 *
 * Write a function that takes a string as input and checks whether
 * it can be a valid palindrome by removing at most one character from it.
 * eg. ABCdEdBA, it's true, cause remove the letter E, it will be palindrome
 */



public class Main {
    public static void main(String[] args) {

        String str = "ABCdEdBA";
        System.out.println("if the string " + str + "is palindromeII: ");
        System.out.println(isPalindromeII(str));
    }

    public static boolean isPalindromeII(String str){
        char[] ch = str.toCharArray();
        int start = 0;
        int end = ch.length-1;

        while(start < end){
            if (ch[start] == ch[end]){
                ++start;
                --end;
            }else{
                char[] subChLeft = Arrays.copyOfRange(ch, start, end);
                char[] subChRight= Arrays.copyOfRange(ch, start+1, end+1);
                return ( isPurePalindrome(subChLeft) ||  isPurePalindrome(subChRight) );
            }
        }
        return true;
    }
    public static  boolean isPurePalindrome(char[] c){
        if(c.length == 1)
            return true;
        int start = 0;
        int end = c.length-1;
        while(start < end){
            if (c[start] == c[end]){
                ++start;
                --end;
            }else
                return false;
        }
        return true; // If the loop completes without returning false, it's a pure palindrome
    }
}