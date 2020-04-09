package leetCodeChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Juan Grajales /* Given an array of strings, group anagrams together.
 * 
 *         Example:
 * 
 *         Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 *         ["ate","eat","tea"], ["nat","tan"], ["bat"] ] Note:
 * 
 *         All inputs will be in lowercase. The order of your output does not
 *         matter.
 */

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
//		List<List<String>> listOfList = new ArrayList<List<String>>();
//

//		for (int i = 0; i < strs.length; i++) {
//			if (strs[i] == "*") {
//				continue;
//			}
//			char[] str1 = strs[i].toCharArray();
//			List<String> listOfString = new ArrayList<String>();
//			listOfString.add(strs[i]);
//			Arrays.sort(str1);
//			for (int j = i+1; j < strs.length; j++) {
//				char[] str2 = strs[j].toCharArray();
//				Arrays.sort(str2);
//
//				if (Arrays.equals(str1, str2)) {
//					listOfString.add(strs[j]);
//					strs[j] = "*";
//				}
//
//			}
//			listOfList.add(listOfString);
//		}
//
//		return listOfList;
		
		List<List<String>> result = new ArrayList<List<String>>();
		 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        String ns = new String(arr);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}

}
