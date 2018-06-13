package leetcode.easy;

public class RomanToInteger {
    public static int romanToInt(String s) {
        char[][] romanNums = new char[][]{
                {'I', 'V', 'X'},
                {'X', 'L', 'C'},
                {'C', 'D', 'M'},
                {'M', '*', '*'}
        };
        int num = 0;
        int i = 0;
        int multiplier = 1;
        while (s.length() != 0) {
            char one = romanNums[i][0],
                    five = romanNums[i][1],
                    ten = romanNums[i][2];
            if (s.length() >= 4 && s.endsWith(String.valueOf(new char[]{five, one, one, one}))) { // 8
                num += 8 * multiplier;
                s = s.substring(0, s.length() - 4);
            } else if (s.length() >= 3 && s.endsWith(String.valueOf(new char[]{one, one, one}))) { // 3
                num += 3 * multiplier;
                s = s.substring(0, s.length() - 3);
            } else if (s.length() >= 3 && s.endsWith(String.valueOf(new char[]{five, one, one}))) { // 7
                num += 7 * multiplier;
                s = s.substring(0, s.length() - 3);
            } else if (s.length() >= 2 && s.endsWith(String.valueOf(new char[]{one, one}))) { // 2
                num += 2 * multiplier;
                s = s.substring(0, s.length() - 2);
            } else if (s.length() >= 2 && s.endsWith(String.valueOf(new char[]{five, one}))) { // 6
                num += 6 * multiplier;
                s = s.substring(0, s.length() - 2);
            } else if (s.length() >= 2 && s.endsWith(String.valueOf(new char[]{one, five}))) { // 4
                num += 4 * multiplier;
                s = s.substring(0, s.length() - 2);
            } else if (s.length() >= 2 && s.endsWith(String.valueOf(new char[]{one, ten}))) { // 9
                num += 9 * multiplier;
                s = s.substring(0, s.length() - 2);
            } else if (s.length() >= 1 && s.endsWith(String.valueOf(new char[]{one}))) { // 1
                num += 1 * multiplier;
                s = s.substring(0, s.length() - 1);
            } else if (s.length() >= 1 && s.endsWith(String.valueOf(new char[]{five}))) { // 1
                num += 5 * multiplier;
                s = s.substring(0, s.length() - 1);
            }
            multiplier *= 10;
            i++;
        }
        return num;
    }
}
