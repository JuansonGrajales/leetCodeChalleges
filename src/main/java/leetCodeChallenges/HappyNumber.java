package leetCodeChallenges;

/**
 * @author Juan Grajales
 * 
 *         Write an algorithm to determine if a number is "happy".
 * 
 *         A happy number is a number defined by the following process: Starting
 *         with any positive integer, replace the number by the sum of the
 *         squares of its digits, and repeat the process until the number equals
 *         1 (where it will stay), or it loops endlessly in a cycle which does
 *         not include 1. Those numbers for which this process ends in 1 are
 *         happy numbers.
 *
 */
public class HappyNumber {

	public static boolean isHappy(int n) {
		
		//It helps to know that for single digit numbers, ONLY 1 and 7 are true
		// the rest are false
		while (true) {
			if (n == 1 || n == 7) {
				return true;
			}
			if (n < 10) {
				return false;
			}
			n = sumOfSquares(n);
		}
	}

	private static int sumOfSquares(int n) {
		int sumOfSquares = 0;
		while (n != 0) {
			// seperate the last digit
			int singleDigit = n % 10;
			// square the last digit
			sumOfSquares += singleDigit * singleDigit;
			// truncate the new value to eliminate the last image
			n = n / 10;
		}
		return sumOfSquares;
	}

}

/*
Another possible solution
Not knowing the fact that 1 or 7 are true
*/
//class Solution {
//    public boolean isHappy(int n) {
//        int slow = n;
//        int fast = n;
//        
//        do {
//            slow = HappySq(slow);
//            fast = HappySq(HappySq(fast));
//        } while (slow!=fast);
//        return slow == 1? true: false;
//    }
//    
//    private int HappySq(int n) {
//        int num = 0;
//        while(n != 0) {
//            num = num + (n%10) * (n%10);
//            n= n/10;
//        }
//        return num;
//    }
//}