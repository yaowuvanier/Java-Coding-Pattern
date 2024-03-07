/**
 * @author Yao Wu~
 * @version 1.0
 */

/**
 * Write an algorithm to determine if a number n is a happy number.
 * We use the following process to check if a given number is a happy number:
 *    1. Starting with the given number n, replace the number with the sum of the squares of its digits.
 *    2. Repeat the process until：
 *    	The number equals 1, which will depict that the given number n is a happy number.
 *    	It enters a cycle, which will depict that the given number n is not a happy number.
 *
 *  Return TRUE if n is a happy number, and FALSE if not.
 *
 * eg: numberis 19, 1+81=82, 64+4=68, 36+64=100, 1+0+0=1, so 19 is a happy number
 * */
public class Main {
    public static void main(String[] args) {
        int number = 2147483646;

        System.out.println("is 2147483646 a happy number?: " + isHappyNumber(number) );
    }

    public static boolean isHappyNumber (int number){
        int slow = number;
        int fast = sumOfSquaredDigits(number) ;

        while (true){
            if (fast == 1)
                return true;
            else if (fast == slow)
                return false;
            else{
                slow = sumOfSquaredDigits(slow);// Update slow with the sum of squared digits of slow
                // Update fast with the sum of squared digits of the sum of squared digits of fast
                fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
            }
        }
    }
    /*  //another way to write, concise, when fast !=1 && fast != slow, to be continued...
      public static boolean isHappyNumber(int n) {
      int slowPointer = n;
      int fastPointer = sumOfSquaredDigits(n);

      while (fastPointer != 1 && slowPointer != fastPointer) {
          slowPointer = sumOfSquaredDigits(slowPointer);
          fastPointer =  sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
      }
      return fastPointer == 1;
  }
    * */
    public static int sumOfSquaredDigits (int number){
        int sum = 0;
        while(number > 0){
            sum += Math.pow(number % 10, 2);
            number = number/10;
        }
        return sum;
    }
}