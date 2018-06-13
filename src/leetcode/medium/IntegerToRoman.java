package leetcode.medium;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        char[][] romanNums = new char[][]{
                {'I', 'V', 'X'},
                {'X', 'L', 'C'},
                {'C', 'D', 'M'},
                {'M'}
        };

        StringBuilder str = new StringBuilder();
        int i = 3;
        int divider = 1000;
        while (num > 0) {
            int digit = num / divider;
            if(digit != 0) {
                if (digit >= 1 && digit <= 3) {
                    for (int j = 1; j <= digit; j++) {
                        str.append(romanNums[i][0]);
                    }
                } else if (digit == 4) {
                    str.append(romanNums[i][0]);
                    str.append(romanNums[i][1]);
                } else if (digit <= 8) {
                    str.append(romanNums[i][1]);
                    for (int j = 6; j <= digit; j++) {
                        str.append(romanNums[i][0]);
                    }
                } else if (digit == 9) {
                    str.append(romanNums[i][0]);
                    str.append(romanNums[i][2]);
                } else if (digit == 10) {
                    str.append(romanNums[i][2]);
                }
            }
            num = num % divider;
            divider /= 10;
            i--;
        }
        return str.toString();
    }
}
