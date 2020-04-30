package leetCodeChallenges;

import java.util.Stack;

/**
 *         Given a string containing only three types of characters: '(', ')'
 *         and '*', write a function to check whether this string is valid. We
 *         define the validity of a string by these rules: Any left parenthesis
 *         '(' must have a corresponding right parenthesis ')'. Any right
 *         parenthesis ')' must have a corresponding left parenthesis '('. Left
 *         parenthesis '(' must go before the corresponding right parenthesis
 *         ')'. '*' could be treated as a single right parenthesis ')' or a
 *         single left parenthesis '(' or an empty string. An empty string is
 *         also valid.
 * 
 *         Example 1: Input: "()" Output: True
 * 
 *         Example 2: Input: "(*)" Output: True
 * 
 *         Example 3: Input: "(*))" Output: True
 */
public class ValidParenthesisString {

	public static boolean checkValidString(String s) {

		Stack<Integer> openParenthesis = new Stack<Integer>();
		Stack<Integer> asterisk = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				openParenthesis.push(i);
			} else if (s.charAt(i) == '*') {
				asterisk.push(i);
			} else if (s.charAt(i) == ')') {
				if (!openParenthesis.isEmpty()) {
					openParenthesis.pop();
				} else if (!asterisk.isEmpty()) {
					asterisk.pop();
				} else {
					return false;
				}
			}
		}
		while (!openParenthesis.isEmpty()) {
			if (asterisk.isEmpty()) {
				return false;
			} else if (openParenthesis.peek() < asterisk.peek()) {
				openParenthesis.pop();
				asterisk.pop();
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * Approach #1 Brute Force [Time Limit Exceeded] for each asterisks lets try
	 * both possibilities
	 */
	boolean ans = false;

	public boolean checkValidStringApproachOne(String s) {
		solve(new StringBuilder(s), 0);
		return ans;
	}

	public void solve(StringBuilder sb, int i) {
		if (i == sb.length()) {
			ans |= valid(sb);
		} else if (sb.charAt(i) == '*') {
			for (char c : "() ".toCharArray()) {
				sb.setCharAt(i, c);
				solve(sb, i + 1);
				if (ans)
					return;
			}
			sb.setCharAt(i, '*');
		} else
			solve(sb, i + 1);
	}

	public boolean valid(StringBuilder sb) {
		int bal = 0;
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c == '(')
				bal++;
			if (c == ')')
				bal--;
			if (bal < 0)
				break;
		}
		return bal == 0;
	}

	/**
	 * Complexity Analysis
	 * 
	 * Time Complexity: O(N * 3^{N})O(N∗3 N ), where NN is the length of the string.
	 * For each asterisk we try 3 different values. Thus, we could be checking the
	 * validity of up to 3^N3 N strings. Then, each check of validity is O(N)O(N).
	 * 
	 * Space Complexity: O(N)O(N), the space used by our character array.
	 */

	/**
	 * Approach #2: Dynamic Programming [Accepted] Intuition and Algorithm
	 * 
	 * Let dp[i][j] be true if and only if the interval s[i], s[i+1], ..., s[j] can
	 * be made valid. Then dp[i][j] is true only if:
	 * 
	 * s[i] is '*', and the interval s[i+1], s[i+2], ..., s[j] can be made valid;
	 * 
	 * or, s[i] can be made to be '(', and there is some k in [i+1, j] such that
	 * s[k] can be made to be ')', plus the two intervals cut by s[k] (s[i+1: k] and
	 * s[k+1: j+1]) can be made valid;
	 */

	public boolean checkValidStringApproachTwo(String s) {
		int n = s.length();
		if (n == 0)
			return true;
		boolean[][] dp = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '*')
				dp[i][i] = true;
			if (i < n - 1 && (s.charAt(i) == '(' || s.charAt(i) == '*')
					&& (s.charAt(i + 1) == ')' || s.charAt(i + 1) == '*')) {
				dp[i][i + 1] = true;
			}
		}

		for (int size = 2; size < n; size++) {
			for (int i = 0; i + size < n; i++) {
				if (s.charAt(i) == '*' && dp[i + 1][i + size] == true) {
					dp[i][i + size] = true;
				} else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
					for (int k = i + 1; k <= i + size; k++) {
						if ((s.charAt(k) == ')' || s.charAt(k) == '*') && (k == i + 1 || dp[i + 1][k - 1])
								&& (k == i + size || dp[k + 1][i + size])) {
							dp[i][i + size] = true;
						}
					}
				}
			}
		}
		return dp[0][n - 1];
	}

	/**
	 * Complexity Analysis
	 * 
	 * Time Complexity: O(N^3)O(N 3 ), where NN is the length of the string. There
	 * are O(N^2)O(N 2 ) states corresponding to entries of dp, and we do an average
	 * of O(N)O(N) work on each state.
	 * 
	 * Space Complexity: O(N^2)O(N 2 ), the space used to store intermediate results
	 * in dp.
	 * 
	 */

	/**
	 * Approach #3: Greedy [Accepted] Intuition
	 * 
	 * When checking whether the string is valid, we only cared about the "balance":
	 * the number of extra, open left brackets as we parsed through the string. For
	 * example, when checking whether '(()())' is valid, we had a balance of 1, 2,
	 * 1, 2, 1, 0 as we parse through the string: '(' has 1 left bracket, '((' has
	 * 2, '(()' has 1, and so on. This means that after parsing the first i symbols,
	 * (which may include asterisks,) we only need to keep track of what the balance
	 * could be.
	 * 
	 * For example, if we have string '(***)', then as we parse each symbol, the set
	 * of possible values for the balance is [1] for '('; [0, 1, 2] for '(*'; [0, 1,
	 * 2, 3] for '(**'; [0, 1, 2, 3, 4] for '(***', and [0, 1, 2, 3] for '(***)'.
	 * 
	 * Furthermore, we can prove these states always form a contiguous interval.
	 * Thus, we only need to know the left and right bounds of this interval. That
	 * is, we would keep those intermediate states described above as [lo, hi] = [1,
	 * 1], [0, 2], [0, 3], [0, 4], [0, 3].
	 * 
	 * Algorithm
	 * 
	 * Let lo, hi respectively be the smallest and largest possible number of open
	 * left brackets after processing the current character in the string.
	 * 
	 * If we encounter a left bracket (c == '('), then lo++, otherwise we could
	 * write a right bracket, so lo--. If we encounter what can be a left bracket (c
	 * != ')'), then hi++, otherwise we must write a right bracket, so hi--. If hi <
	 * 0, then the current prefix can't be made valid no matter what our choices
	 * are. Also, we can never have less than 0 open left brackets. At the end, we
	 * should check that we can have exactly 0 open left brackets.
	 */

	public boolean checkValidStringApproachThree(String s) {
		int lo = 0, hi = 0;
		for (char c : s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0)
				break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;
	}
	/**
	 * Complexity Analysis
	 * 
	 * Time Complexity: O(N)O(N), where NN is the length of the string. We iterate
	 * through the string once.
	 * 
	 * Space Complexity: O(1)O(1), the space used by our lo and hi pointers.
	 * However, creating a new character array will take O(N)O(N) space.
	 */
}
