package CH1_ArraysAndStrings;

/**
 * Created by Thomas on 8/14/2017.
 *
 * Problem Description:
 * There are three types of edits that can be performed on strings: insert a char,
 * remove a char or replace a char. Given 2 strings, write a function to check
 * if they are one edit (or 0 edits) away.
 *
 * EXAMPLE
 * pale, ple -> True
 * pales, pale -> True
 * pale, bake -> False
 */
import java.util.Arrays;

public class OneAway {

    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "bake";
        oneAway(str1, str2);
        oneEditAway(str1, str2);
    }

    private static boolean oneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            System.out.println("False");
            return false;
        }
        char[] one = s1.toCharArray();
        char[] two = s2.toCharArray();
        int differenceCount = 0; //counter to track # of differences

        //ERROR: ORDER OF THE STRINGS MATTER SO YOU CAN'T SORT:
        Arrays.sort(two); //sort the shorter array to save time
        for (int i = 0; i < one.length; i++) {
            int index = Arrays.binarySearch(two, one[i]);
            if (index == -1) {
                differenceCount++;
                if (differenceCount > 1) {
                    System.out.println("False");
                    return false;
                }
            }
        }
        System.out.println("True");
        return true;
    }

    //Solution
    static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length())
            return oneEditReplace(first, second);
        else if (first.length() + 1 == second.length() + 1)
            return oneEditInsert(first, second);
        else if (first.length() - 1 == second.length())
            return oneEditInsert(second, first);

        return false;
    }

    static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    System.out.println("False");
                    return false;
                }
                foundDifference = true; //keeps track if 1 difference has been found yet?
            }
        }
        System.out.println("True");
        return true; //if it makes it to this point w/o returning false,
    }

    //check if you can insert a char into s1 to make s2
    static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    System.out.println("False");
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        System.out.println("True");
        return true;

    }
}
