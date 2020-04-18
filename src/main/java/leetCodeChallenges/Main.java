package leetCodeChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Single Number
		// Solves the single number in a given Array
//		int [] singleNumberArray = new int [] {4,1,2,1,2};
//		System.out.println(SingleNumber.singleNumber(singleNumberArray));
//		
//		//Happy Number
//		int n = 19;
//		System.out.println("result: "+HappyNumber.isHappy(n));
//		
//		//Maximum Subarray
//		int [] nums = new int [] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//		System.out.println(MaximumSubarray.maxSubArray(nums));
//		
//		//Move Zeroes
//		int [] moveZeroes = new int [] {0,1,0,3,12};
//		MoveZeroes.moveZeroes(moveZeroes);
//		
//		//Best time to buy and sell stock II
//		int [] prices = new int[] {6,1,3,2,4,7};
//		BestTimeToBuyAndSellStockII.maxProfit(prices);
		
		//Group of Anagrams
//		String [] arrStrings = new String[] {"tea", "", "eat", "", "tea", ""};
//		GroupAnagrams.groupAnagrams(arrStrings);

		//Counting Elements
//		int [] arr = new int[] {1,1,2,2};
//		System.out.println(CountingElements.countElements(arr));
		
		//Backspace String Compare
//		String str1="ab#c";
//		String str2="ad#c";
//		System.out.println(BackspaceStringCompare.backspaceCompare(str1, str2));
		
//		int [] stones = new int [] {2,7,4,1,8,1};
//		System.out.println(LastStoneWeight.lastStoneWeight(stones));

//		int [] contiguousArray = new int [] {0,1,0,1};
//		ContiguousArray.findMaxLength(contiguousArray);
		
//		String s = "yisxjwry";
//		int [][] shift = {{1,8}, {1,4}, {1,3}, {1,6}, {0,6}, {1,4}, {0,2}, {0,1}};
//		System.out.println(PerformStringShifts.stringShift(s, shift));
		
//		int [] nums = new int [] {4,5,1,8,2};
//		ProductOfArrayExceptSelf.productExceptSelf(nums);
		
		//String s ="*()(())*()(()()((()(()()*)(*(())((((((((()*)(()(*)";
//		String s = "(((******))";
//		System.out.println(ValidParenthesisString.checkValidString(s));
		
//		char [][] grid = new char [3][3];
//		grid[0][0]='1';
//		grid[0][1]='1';
//		grid[0][2]='0';
//		grid[1][0]='0';
//		grid[1][1]='0';
//		grid[1][2]='1';
//		grid[2][0]='1';
//		grid[2][1]='0';
//		grid[2][2]='0';		
//		System.out.println(NumberOfIslands.numIslands(grid));

		int [][] grid = new int [2][3];
		grid[0][0]=1;
		grid[0][1]=2;
		grid[0][2]=5;
		grid[1][0]=3;
		grid[1][1]=2;
		grid[1][2]=1;
//		grid[2][0]=4;
//		grid[2][1]=2;
//		grid[2][2]=1;
		
		System.out.println(MinimumPathSum.minPathSum(grid));
		

	}

}
