package leetCodeChallenges;

import java.util.Arrays;

/**
 * @author Juan Grajales
 * 
 *         Given an array nums, write a function to move all 0's to the end of
 *         it while maintaining the relative order of the non-zero elements.
 * 
 *         Example:
 * 
 *         Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * 
 *         You must do this in-place without making a copy of the array.
 *         Minimize the total number of operations.
 *
 */
public class MoveZeroes {

	public static void moveZeroes(int[] nums) {
		int lastIndexOfArray = nums.length - 1;
		int i = 0;
		int counter = 0;

		for (int var : nums) {
			if (var != 0) {
				nums[i] = var;
				i++;
			}
			 else {
				counter++;
			}
		}
		for (i = 0; i < counter; i++) {
			nums[lastIndexOfArray] = 0;
			lastIndexOfArray--;
		}

	}

}
