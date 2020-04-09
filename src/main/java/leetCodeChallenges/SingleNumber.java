package leetCodeChallenges;

import java.util.Arrays;
import java.util.List;

/**
 * @author Juan Grajales
 * 
 *         Given a non-empty array of integers, every element appears twice
 *         except for one. Find that single one.
 * 
 *         Note:
 * 
 *         Your algorithm should have a linear runtime complexity. Could you
 *         implement it without using extra memory?
 * 
 *         Example 1: Input: [2,2,1] Output: 1
 * 
 *         Example 2: Input: [4,1,2,1,2] Output: 4
 *
 */

public class SingleNumber {
	/**
	 * 1. Sort the array to pair the elements in ascending order 
	 * 
	 * 2. Iterate over the elements 
	 * 
	 * 3. If the pairs do not match or we've reached the end of the array,
	 * return the value
	 * 
	 * Time Complexity: O(n) 
	 * 
	 * Space Complexity: O(1)
	 * 
	 */
//	public static int singleNumber(int[] nums) {
//		Arrays.sort(nums);
//		for (int i = 0; i < nums.length; i += 2) {
//			if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
//				return nums[i];
//			}
//		}
//		return 0;
//	}
	
	public static int singleNumber(int[] nums) {
		int a = 0;
		for (int i : nums) {
			a ^= i;
		}
		return a;
	}

}

/**
 * Approach 1: List Operation
 */

//	public int singleNumber(int[] nums) {
//		List<Integer> no_duplicate_list = new ArrayList<>();
//
//		for (int i : nums) {
//			if (!no_duplicate_list.contains(i)) {
//				no_duplicate_list.add(i);
//			} else {
//				no_duplicate_list.remove(new Integer(i));
//			}
//		}
//		return no_duplicate_list.get(0);
//	}

/**
 * Complexity Analysis
 * 
 * Time complexity : O(n^2)O(n 2 ). We iterate through \text{nums}nums, taking
 * O(n)O(n) time. We search the whole list to find whether there is duplicate
 * number, taking O(n)O(n) time. Because search is in the for loop, so we have
 * to multiply both time complexities which is O(n^2)O(n 2 ).
 * 
 * Space complexity : O(n)O(n). We need a list of size nn to contain elements in
 * \text{nums}nums.
 *
 */

/**
 * Approach 2: HashTable
 */

//	public int singleNumber(int[] nums) {
//		HashMap<Integer, Integer> hash_table = new HashMap<>();
//
//		for (int i : nums) {
//			hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
//		}
//		for (int i : nums) {
//			if (hash_table.get(i) == 1) {
//				return i;
//			}
//		}
//		return 0;
//	}

/**
 * 
 * Time complexity : O(n \cdot 1) = O(n)O(n⋅1)=O(n). Time complexity of for loop
 * is O(n)O(n). Time complexity of hash table(dictionary in python) operation
 * pop is O(1)O(1).
 * 
 * Space complexity : O(n)O(n). The space required by hash\_tablehash_table is
 * equal to the number of elements in \text{nums}nums.
 *
 */

/**
 * Approach 3: Math
 */

//	public int singleNumber(int[] nums) {
//		int sumOfSet = 0, sumOfNums = 0;
//		Set<Integer> set = new HashSet();
//
//		for (int num : nums) {
//			if (!set.contains(num)) {
//				set.add(num);
//				sumOfSet += num;
//			}
//			sumOfNums += num;
//		}
//		return 2 * sumOfSet - sumOfNums;
//	}

/**
 * Time complexity : O(n + n) = O(n)O(n+n)=O(n). sum will call next to iterate
 * through \text{nums}nums. We can see it as sum(list(i, for i in nums)) which
 * means the time complexity is O(n)O(n) because of the number of elements(nn)
 * in \text{nums}nums.
 * 
 * Space complexity : O(n + n) = O(n)O(n+n)=O(n). set needs space for the
 * elements in nums
 */

/**
 * Approach 4: Manipulation
 */

//	public int singleNumber(int[] nums) {
//		int a = 0;
//		for (int i : nums) {
//			a ^= i;
//		}
//		return a;
//	}

/**
 * Time complexity : O(n)O(n). We only iterate through \text{nums}nums, so the
 * time complexity is the number of elements in \text{nums}nums.
 * 
 * Space complexity : O(1)O(1).
 */
