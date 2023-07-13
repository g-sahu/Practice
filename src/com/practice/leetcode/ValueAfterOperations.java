package com.practice.leetcode;

/*
2011. Final Value of Variable After Performing Operations
 */
public class ValueAfterOperations {
    public static void main(String[] args) {
        ValueAfterOperations vao = new ValueAfterOperations();
        String[] ops = {"--X","X++","X++"};
        System.out.println(vao.finalValueAfterOperations(ops));
    }

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for (String op: operations) {
            switch (op) {
                case "++X":
                    ++x;
                    break;
                case "X++":
                    x++;
                    break;
                case "--X":
                    --x;
                    break;
                case "X--":
                    x--;
                    break;
            }
        }

        return x;
    }
}
