package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

    private List<Integer> prices;
    private List<Integer> spans;

    public StockSpanner() {
        prices = new ArrayList<>();
        spans = new ArrayList<>();
    }
    public int next(int price) {
        int span = 1;
        int i = prices.size() - 1;
        while (i >= 0) {
            if(price >= prices.get(i)) {
                span += spans.get(i);
                i -= spans.get(i);
                continue;
            }
            break;
        }
        prices.add(price);
        spans.add(span);
        return span;
    }
}