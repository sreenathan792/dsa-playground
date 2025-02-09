package com.dsa4.dp;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {

    class Item {
        int weight;
        int value;

        Item(int value, int weight) {
            this.weight = weight;
            this.value = value;
        }
    }

    public int solve(int[] A, int[] B, int C) {

        int n = A.length;
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Item it = new Item(A[i], B[i]);
            items.add(it);
        }

        Collections.sort(items, (o1, o2) -> Double.compare(o2.value / (double) o2.weight, o1.value / (double) o1.weight));

        double totalValue = 0;
        for (Item item : items) {
            if (item.weight <= C) {
                totalValue += item.value;
                C -= item.weight;
            } else {
                double fraction = (double) C / item.weight;
                totalValue += item.value * fraction;
                break;
            }
        }

        totalValue *= 100;

        return (int) totalValue;
    }

    public static void main(String[] args) {

        int[] A = {3};
                //{16, 3, 3, 6, 7, 8, 17, 13, 7};
        int[] B = {20};
                //{3, 10, 9, 18, 17, 17, 6, 16, 13};
        FractionalKnapsack fr = new FractionalKnapsack();

        System.out.println("Result->" + fr.solve(A, B, 17));
    }
}
