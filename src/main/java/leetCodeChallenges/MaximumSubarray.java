package leetCodeChallenges;

/**
 * @author Juan Grajales
 * 
 *         Given an integer array nums, find the contiguous subarray (containing
 *         at least one number) which has the largest sum and return its sum.
 * 
 *         Example:
 * 
 *         Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has
 *         the largest sum = 6.
 *
 */
public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {

		int maxEndingHere = 0;
		int maxSoFar = Integer.MIN_VALUE;

		for (int i=0; i<nums.length;i++) {
			
			maxEndingHere = maxEndingHere + nums[i];
			
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
		}
		return maxSoFar;
	}

}
/* Another approach */
//public int maxSubArray(int[] nums) {
//    int left = 0;
//    int right = 1;
//    int max = nums[left];
//    int sum = nums[left];
//    
//    if(nums.length == 1)
//        return nums[0];
//    
//    while(right < nums.length && left < nums.length){
//        if((sum + nums[right]) < nums[right]) {
//            left = right;
//            sum = nums[right];
//            if(nums[right] > max){
//                max = nums[right];
//            }
//        }else{
//            sum += nums[right];
//            if(sum > max){
//                max = sum;
//            }
//        }
//        right ++;
//    }
//    
//        return max;
//
//}