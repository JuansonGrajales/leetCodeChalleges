package leetCodeChallenges;

import java.util.HashMap;
import java.util.Map;

public class DeletionDistance {

	public static int deletionCount(String str1, String str2) {
		String s = str1 + str2;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		int deletion = 0;

		for (Map.Entry mapElement : map.entrySet()) {
			if ((Integer) mapElement.getValue() % 2 == 1) {
				deletion += 1;
			}
		}
		
		return deletion;
	}

}
