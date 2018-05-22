package bitwise;

public class Test {
    public static void main(String[] args) {
        int diffCount = countBitDifference(0b01011, 0b10100);
        System.out.println(diffCount);
        System.out.println(Integer.toBinaryString(-1));
        System.out.println("Set bit count for -1: " + countSetBits(-1));
        System.out.println("Next power of 2 of number 5: " + roundUpToNextPowerOfTwo(5));
        swapXor(13, 2);
        System.out.println("Abs value of -1: " + absoluteValue(-1));
    }

    public static int countBitDifference(int a, int b) {
        System.out.println(Integer.toBinaryString(0x33333333));
        int i = a ^ b;
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        System.out.println(i);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);

        return i & 0x3f;
    }

    /**
     * Based on Kernighan's algorithm
     * @param a
     * @return
     */
    public static byte countSetBits(int a) {
        byte count = 0;
        for(count = 0; a != 0; count++) {
            a &= a - 1;
        }
        return count;
    }


    public static int roundUpToNextPowerOfTwo(int a) {
        a--;
        a |= a >> 1; // handle 2 bit numbers
        a |= a >> 2; // handle 4 bit numbers
        a |= a >> 4; // handle 8 but numbers
        a |= a >> 8; // handle 16 bit numbers
        a |= a >> 16; // handle 32 bit numbers
        a++;
        return a;
    }

    public static void swapXor(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("A is now: " + a);
        System.out.println("B is now: " + b);
    }

    public static int absoluteValue(int a) {
        int bit31 = a >> 31;
        System.out.println(bit31);
        return (a ^ bit31) - bit31;
    }
}
