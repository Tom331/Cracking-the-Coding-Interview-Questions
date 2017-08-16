package CH1_ArraysAndStrings;

/**
 * Created by Thomas on 8/14/2017.
 *
 * There are three types of edits that can be performed on strings: insert a char,
 * remove a char or replace a char. Given 2 strings, write a function to check
 * if they are one edit (or 0 edits) away.
 * EXAMPLEl
 * pale, ple -> True
 * pales, pale -> True
 * pale, bake -> False
 */
import java.util.Arrays;

public class OneAway {

	   public static void main(String[] args) {

		    // Initialize unsorted char array
		    char arr[] = {'t', 'q', 'r', 'p','s'};

		    // Sorting array list
		    Arrays.sort(arr);

		    // Printing Sorted Array List
		    System.out.println("The Sorted Char Array is:");
		    for (char ch : arr) {
		      System.out.println("Character = " + ch);
		    }

		    // Enter character to be searched
		    char val = 's';

		    int index= Arrays.binarySearch(arr, val);

		    System.out.println("The Index of " + val + " is : " + index);
		  }
}
