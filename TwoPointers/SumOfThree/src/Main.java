/**
 * @author Yao Wu~
 * @version 1.0
 */

import java.util.Arrays;

/**
 *  if an array exist three numbers, their sum is a target number
 *
 * */

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 6, 8, 20} ;
        int target = 31;
        System.out.println("if arr exists: " + isExist(arr, target));
        int[] arr1 = {1, 3, 4, 6, 8, 20} ;
        boolean isTrue = isExist(arr1, target);
        System.out.println("if arr1 exists: " + isTrue );
        int[] arr2 = {1, 2, 4, 7, 8, 20} ;
        System.out.println("if arr2 exists: " + isExist(arr2, target) );


        // for testing
        int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
                {-1, 2, 1, -4, 5, -3},
                {2, 3, 4, 1, 7, 9},
                {1, -1, 0},
                {2, 4, 2, 7, 6, 3, 1}};

        int[] testList = {10, 7, 20, -1, 8};


        for (int i=0; i<testList.length; i++) {
            System.out.print(i+1);
            System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));

            if (findSumOfThree(numsList[i], testList[i])) {
                System.out.println("\tSum for " + testList[i] + " exists ");
            } else {
                System.out.println("\tSum for " + testList[i] + " does not exist ");
            }

            System.out.println("---------------------------------------");
        }
    }

    // this is for O(n*n*n)
    public static  boolean isExist (int[] arr, int target){
        if (arr.length < 3)
            return false;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+2; j < arr.length; j++) {
                if (target == arr[0]+arr[i+1]+arr[j])
                    return true;
            }
        }
        return isExist(Arrays.copyOfRange(arr, 1, arr.length), target);

    }

    // a better solution, O(n*n
    public static boolean findSumOfThree(int nums[], int target) {
        Arrays.sort(nums);  //  O(n log n)
        int low, high, triples;

        for (int i = 0; i < nums.length - 2; i++) {
            low = i + 1;
            high = nums.length - 1;

            while (low < high) {
                triples = nums[i] + nums[low] + nums[high];

                if (triples == target) {
                    return true;
                }
                else if (triples < target) {
                    low++;
                }
                else {
                    high--;
                }
            }
        }

        return false;
    }
}