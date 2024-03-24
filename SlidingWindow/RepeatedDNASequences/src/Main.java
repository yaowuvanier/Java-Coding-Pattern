/**
 * @author Yao Wu~
 * @version 1.0
 */

import java.util.*;

/**
 * The DNA sequence is composed of a series of nucleotides abbreviated as
 * A, C, G, and. For example, AGACCTAGAC is a DNA sequence.
 * finding A substring whose length is three consecutive occurrences
 * in this case, they are AGA and GAC
 * mapping  {A:1, C:2, G:3, T:4}
 * AGA --> 131 ;   AGACCTAGAC --> 1312241312
 * 131 312 122 224 241 413 131 312
 * 131 and 312 recurring, so AGA ANS GAC is the repeated sub string, that is sub DNA
 * */
public class Main {
    public static void main(String[] args) {

        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) + "\n");
            System.out.println(getRepeatedSubDNA(inputsString.get(i), inputsK.get(i)));
            System.out.println(repeat("-", 100));
        }

    }
    public static String repeat(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    public static int getMappingValue( Character c) {
        Map<Character, Integer> mapping = new HashMap<>();
        // Add mappings
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        // Example usage:
        char nucleotide = c;
        int value = mapping.get(nucleotide);
        return value;
    }

    public static int[] convStrToInt (String  DNA){
        int[] numbers = new int[DNA.length()];

        char nucleotide;
        for (int i = 0; i < DNA.length(); i++) {
            nucleotide = DNA.charAt(i);
            numbers[i] = getMappingValue(nucleotide);
        }
        return numbers;
    }

    public static int[] arrSubStrMapValue (int[] arr, int k){
        int[] arrSubStr = new int[arr.length-k+1];
        arrSubStr[0] = 0;
        for (int i = k-1; i >=0 ; i--) {
            arrSubStr[0] += arr[i]*Math.pow(10,k-1-i);
        }

        for (int i = 0; i < arr.length-k; i++) {
            arrSubStr[i+1] = (int) ((arrSubStr[i]-arr[i]*Math.pow(10, k-1))*10 + arr[i+k]);
        }
        return arrSubStr;
    }

    public static LinkedList<Integer> getIndex (int[] arr){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if ( arr[i] == arr[j]){
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }

    public static Set<String> getRepeatedSubDNA(String DNA, int k){
        int[] numbers = convStrToInt(DNA);
        System.out.println(Arrays.toString(numbers));
        int[] subStrMapValue = arrSubStrMapValue(numbers, k);
        System.out.println(Arrays.toString(subStrMapValue));
        LinkedList<Integer> list = getIndex(subStrMapValue);
        System.out.println(list);
        Set<String> setStr = new HashSet<>();

        for (Integer i: list) {
            setStr.add(DNA.substring(i, i+k));
        }
        return setStr;
    }
}