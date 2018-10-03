package leetcode;


import leetcode.medium.ContiguousArray;

public class Test {
    public static void main(String[] args) {

        assert new ContiguousArray().findMaxLength(new int[]{1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0}) == 70;
        assert new ContiguousArray().findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}) == 4;
        assert new ContiguousArray().findMaxLength(new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1}) == 68;
        assert new ContiguousArray().findMaxLength(new int[]{0, 1, 1}) == 2;
        assert new ContiguousArray().findMaxLength(new int[]{0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1}) == 16;
        assert new ContiguousArray().findMaxLength(new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1}) == 94;
        assert new ContiguousArray().findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}) == 6;
        assert new ContiguousArray().findMaxLength(new int[]{1}) == 0;
        assert new ContiguousArray().findMaxLength(new int[]{}) == 0;
        assert new ContiguousArray().findMaxLength(new int[]{0}) == 0;
        assert new ContiguousArray().findMaxLength(new int[]{0, 1, 0}) == 2;
        assert new ContiguousArray().findMaxLength(new int[]{0, 1, 0, 1}) == 4;
        assert new ContiguousArray().findMaxLength(new int[]{1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1}) == 10;
    }
}
