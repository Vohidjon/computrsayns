package dynamicprogramming;


import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("I");
        dictionary.add("a");
        dictionary.add("am");
        dictionary.add("good");
        dictionary.add("old");
        dictionary.add("and");
        dictionary.add("ace");
        dictionary.add("man");
        System.out.println(new WordBreakProblem().breakWord(dictionary, "Iamagoodandoldman"));
    }
}
