package com.test.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class SortStackUsingAnotherStack {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        Stack<Integer> inputStack = new Stack<>();
        int n = A.size();
        for (int i = 0; i < n; i++) {
            inputStack.push(A.get(i));
        }

        Stack<Integer> outputStack = new Stack<>();

        while (!inputStack.isEmpty()) {
            int temp = inputStack.pop();

            while (!outputStack.isEmpty() && outputStack.peek() > temp) {
                inputStack.push(outputStack.pop());
            }

            outputStack.push(temp);
        }

        while (!outputStack.isEmpty()) {
            inputStack.push(outputStack.pop());
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = inputStack.size() - 1; i >= 0; i--) {
            res.add(inputStack.pop());
        }

        return res;
    }

    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(17);
        input.add(100);
        input.add(11);
        SortStackUsingAnotherStack st = new SortStackUsingAnotherStack();

        System.out.println("Result-> " + st.solve(input).toString());
    }
}
