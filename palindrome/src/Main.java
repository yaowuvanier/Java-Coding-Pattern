import java.util.Scanner;

/**
 * @author Yao Wu~
 * @version 1.0
 *
 * problem description
 * Write a function that takes a string, s,
 * as an input and determines whether or not it is a palindrome.
 * Note: A palindrome is a word, phrase, or sequence of characters that reads the same backward as forward.
 *
 * Constrain:
 * 1 <= s.length <=2×10^5
 * The string s will contain English uppercase and lowercase letters, digits, and spaces.
 */


public class Main {
    public static void main(String[] args) {
        String s;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");

        String input = scanner.nextLine();
        scanner.close();
        String ISPalindrome = isPalindrome(input) ?  "a palindrome" : "not a palindrome";

        System.out.println("The string you enter is " + input + ", and it is "+ ISPalindrome);

    }

    static boolean isPalindrome(String s){
        if (s.length() == 0){
            System.out.println("String length must be greater than or equal to 1");
        }
        if (s.length() == 1)
            return true;

        int startIndex = 0;
        int endIndex = s.length()-1;

        while (startIndex <= endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex))
                return false;
            startIndex++;
            endIndex--;
        }
        return true; // If all characters match, it's a palindrome
    }
}