package leetcode.easy;

public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            int count = 0;
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < str.length(); j++) {
                count++;
                if(j + 1 == str.length() || str.charAt(j) != str.charAt(j + 1)) {
                    stringBuffer.append(count).append(str.charAt(j));
                    count = 0;
                }
            }
            str = stringBuffer.toString();
        }
        return str;
    }
}
