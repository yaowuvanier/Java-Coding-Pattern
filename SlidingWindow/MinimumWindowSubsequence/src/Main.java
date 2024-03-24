
/**
 * @author Yao Wu~
 * @version 1.0
 */

/**
 *Given two strings, str1 and str2,
 * find the shortest substring in str1 such that str2 is a subsequence of that substring.
 * str1 = “abbcb“，  str2 = ”ac“
 * In this example, “abbc” is a substring of str1,
 * and also is the shortest among all the substrings, so function should return “abbc”.
 * */
public class Main {
    public static void main(String[] args) {
        String str1 = "azssstaszaztf";
        String str2 = "saz";

//        String s1, s2;
//        s1="abkjnkf";
//        s2="bz";
//        boolean isTrue = isIncluding(str1, str2);
//        System.out.println(isIncluding(s1,s2));
        minWindow(str1, str2 );
        System.out.println(minWindow(str1, str2 ));
    }

    public static String minWindow (String str1, String str2){
        if (str2 == null)
            return str1;


        int length = 0;
        int tempLength = -1;
        String minWindows = "";

        int str2Length = str2.length();
        for (int i = 0; i < str1.length()-1; i++) {
            if (str1.charAt(i) != str2.charAt(0))
                continue;
            for (int j = i+1; j < str1.length(); j++) {
                if (str1.charAt(j)!=str2.charAt(str2Length-1))
                    continue;
                tempLength = j -i;
                if (isIncluding(str1.substring(i,j+1), str2) == true){
                    if(length ==0 || (tempLength < length)){
                        length = tempLength;
                        minWindows = str1.substring(i,j+1);
                    }
                }
            }

        }
        return minWindows;
    }

    // szaz, saz
    public static boolean isIncluding (String str1, String str2){
        if (str2.length() > str1.length())
            return false;
        if (str2 == null)
            return true;
        if (str2.length()==1)
            return str1.contains(str2);
        int start2 = 0;
        int end2 = str2.length()-1;
        int start1Pointer = 0;
        int end1Pointer = str1.length()-1;

        while (start1Pointer < end1Pointer){
            if (str1.charAt(end1Pointer) != str2.charAt(end2))
                end1Pointer--;
            if (str1.charAt(start1Pointer) != str2.charAt(start2))
                start1Pointer++;
            if ( (str1.charAt(end1Pointer) == str2.charAt(end2)) && (str1.charAt(start1Pointer) == str2.charAt(start2)))
                return isIncluding(str1.substring(start1Pointer+1, end1Pointer),str2.substring(1,end2));
        }
        return false;
    }
}