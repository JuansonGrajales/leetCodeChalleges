package leetCodeChallenges;

/**
 * Suppose an array sorted in ascending order is rotated 
 * at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the 
 * array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SortedRotatedArray {

	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length-1;

		while (left < right) {
			int midpoint = left + (right - left) / 2;
			if (nums[midpoint] > nums[right]) {
				left = midpoint + 1;
			} else {
				right = midpoint;
			}
		}

		int start = left;
		left = 0;
		right = nums.length - 1;

		if (target >= nums[start] && target <= nums[right]) {
			left = start;
		} else {
			right = start;
		}

		while (left <= right) {
			int midpoint = left + (right - left) / 2;
			if (nums[midpoint] == target) {
				return midpoint;
			} else if (nums[midpoint] < target) {
				left = midpoint + 1;
			} else {
				right = midpoint - 1;
			}
		}

		return -1;

	}

}
