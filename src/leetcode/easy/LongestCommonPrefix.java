package leetcode.easy;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int k = 0;
        int min = 0;
        for (int i = 1; i < strs.length; i++) {
            if(strs[min].length() > strs[i].length()) min = i;
        }

        while (k < strs[min].length()) {
            boolean matchAll = true;
            for (String str : strs) {
                if (str.length() <= k || strs[min].charAt(k) != str.charAt(k)) {
                    matchAll = false;
                    break;
                }
            }
            if(!matchAll) break;
            k++;
        }
        return strs[min].substring(0, k);
    }
}
