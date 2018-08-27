package leetcode.medium;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int firstMinusIndex = -1;
        int productTillMinus = 1;
        int product = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(product < 0) { // Negative
                if(nums[i] < 0) { // Negative
                    product = product * nums[i];
                    max = Integer.max(max, product);
                } else if(nums[i] > 0) { // Positive
                    product = product * nums[i];
                    max = Integer.max(max, product / productTillMinus);
                } else { // Zero
                    max = Integer.max(max, 0);
                    product = 1;
                    productTillMinus = 1;
                    firstMinusIndex = -1;
                }
            } else { // Positive
                if(nums[i] < 0) { // Negative
                    product = product * nums[i];
                    max = Integer.max(max, product);
                    if(firstMinusIndex == - 1) {
                        productTillMinus = product;
                        firstMinusIndex = i;
                    } else {
                        max = Integer.max(max, product / productTillMinus);
                    }
                } else if(nums[i] > 0) { // Positive
                    product = product * nums[i];
                    max = Integer.max(max, product);
                } else { // Zero
                    max = Integer.max(max, 0);
                    product = 1;
                    productTillMinus = 1;
                    firstMinusIndex = -1;
                }
            }
        }
        return max;
    }
}
