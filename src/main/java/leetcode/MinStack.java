package leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by stan on 15/04/2021.
 */
public class MinStack {
    /** initialize your data structure here. */
    //["MinStack","push","push","push","getMin","pop","top","getMin"]
    //[[],[-2],[0],[-3],[],[],[],[]]

    LinkedList<Integer> stack;
    TreeMap<Integer, Integer> ordered;
    public MinStack() {
        stack = new LinkedList<>();
        ordered = new TreeMap<>();
    }

    public void push(int val) {
        stack.add(val);
        ordered.merge(val, 1, (k,v) -> k + v);
    }

    public void pop() {
        int val = stack.removeLast();
        ordered.merge(val, 1, (k,v) -> k - v);
    }

    public int top() {
        String s = " s";
        return stack.getLast();

    }

    public int getMin() {
        return ordered.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse(0);
    }
}
