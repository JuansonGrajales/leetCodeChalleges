package leetCodeChallenges;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1: Input:nums = [1,1,1], k = 2 Output: 2
 * 
 * Note: The length of the array is in range [1, 20,000]. The range of numbers
 * in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * 
 * Hint #1
 * 
 * Will Brute force work here? Try to optimize it.
 * 
 * Hint #2
 * 
 * Can we optimize it by using some extra space?
 * 
 * Hint #3
 * 
 * What about storing sum frequencies in a hash table? Will it be useful?
 * 
 * Hint #4
 * 
 * sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the
 * elements from index i to j-1. Can we use this property to optimize it.
 */
public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		int result = 0;
		int currSum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (map.containsKey(currSum - k)) {
				result += map.get(currSum - k);
			}
			map.put(currSum, map.getOrDefault(currSum, 0) + 1);
		}
		return result;
	}

	/**
	 * Approach 1: Brute Force Algorithm The simplest method is to consider every
	 * possible subarray of the given numsnums nums array, find the sum of the
	 * elements of each of those subarrays and check for the equality of the sum
	 * obtained with the given kk k. Whenver the sum equals kk k, we can increment
	 * the countcount count used to store the required result.
	 * 
	 * Complexity Analysis Time complexity : O(n^3). Considering every
	 * possible subarray takes O(n^2) time. For each of the subarray we
	 * calculate the sum taking O(n) time in the worst case, taking a total
	 * of O(n^3) time. Space complexity : O(1). Constant space
	 * is used.
	 */
	public int subarraySumBruteForce(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			for (int end = start + 1; end <= nums.length; end++) {
				int sum = 0;
				for (int i = start; i < end; i++)
					sum += nums[i];
				if (sum == k)
					count++;
			}
		}
		return count;
	}
}
