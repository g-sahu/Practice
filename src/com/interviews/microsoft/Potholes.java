package com.interviews.microsoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * You are given a task to fix potholes in a road. The road is described by a string {@code S}
 * consisting of {@code N} characters. Each character represents a single fragment of the road.
 * Character {@code '.'} denotes a smooth surface and {@code 'x'} denotes a pothole.
 *
 * <p>For example, {@code S = "...xxx..x"} means that the road starts with three smooth fragments,
 * followed by three potholes, followed by two smooth fragments, and ending with one pothole.</p>
 *
 * <p>You can choose any number of consecutive potholes and fix all of them. Fixing a segment
 * consisting of {@code K} consecutive potholes costs {@code K + 1}. In the example above, fixing
 * the first two consecutive potholes costs {@code 2 + 1 = 3} and fixing the last pothole costs
 * {@code 1 + 1 = 2}. After these fixes, the road would look like this: {@code ".....x..."}.</p>
 *
 * <p>You are given a budget {@code B}. You can fix multiple segments containing potholes as long as
 * you fit in the budget. What is the maximum number of potholes you can fix?</p>
 *
 * <p>Write a function:</p>
 *
 * <pre>
 * class Solution {
 *     public int solution(String S, int B);
 * }
 * </pre>
 *
 * <p>Given the string {@code S} of length {@code N} and the integer {@code B}, the function returns
 * the maximum number of potholes that can be fixed.</p>
 *
 * <h2>Examples</h2>
 * <ol>
 *     <li>Given {@code S = "...XXX..x....xxx."} and {@code B = 7}, the function should return 5.
 *     You can start by fixing the first three consecutive potholes for a cost of 4, obtaining the
 *     road: {@code ".. .........xxx."}. Then, you can fix the last two potholes for a cost of 3,
 *     obtaining the road: {@code ". .x....x..."}. The total cost is 7, which fits in the budget,
 *     and you fix 5 potholes in total.</li>
 *
 *     <li>Given {@code S = "..xxxxx"} and {@code B = 4}, the function should return 3. One way is
 *     to fix the middle three potholes, which costs the whole budget and makes the road look as
 *     follows: {@code "..x...x"}. Alternatively, you could fix the first three potholes or the last
 *     three potholes.</li>
 *
 *     <li>Given {@code S = "x.x.xxx...x"} and {@code B = 14}, the function should return 6. You
 *     can fix all the potholes, which costs {@code 2 + 2 + 4 + 2 = 10}, leaving you with the spare
 *     budget of 4. This fixes the entire road.</li>
 *
 *     <li>Given {@code S = ".."} and {@code B = 5}, the function should return 0. There are no
 *     potholes to fix.</li>
 * </ol>
 *
 * <p>Write an efficient algorithm for the following assumptions:</p>
 *
 * <ul>
 *     <li>{@code N} is an integer within the range {@code [1..100,000]}.</li>
 *     <li>{@code B} is an integer within the range {@code [0..200,000]}.</li>
 *     <li>String {@code S} consists only of characters {@code '.'} and {@code 'x'}.</li>
 * </ul>
 */
public class Potholes {
    
    public static void main(String[] args) {
        Potholes o = new Potholes();
        String s = "...xxx...xxxx";
        int b = 6;
        System.out.println(o.solution(s, b));
    }

    public int solution(String s, int b) {
        List<Integer> list = new ArrayList<>();
        int c = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'x') {
                c++;
            } else if (c != 0) {
                list.add(c);
                c = 0;
            }
        }

        if (c != 0) {
            list.add(c);
        }

        list.sort(Comparator.reverseOrder());
        int i = 0, ans = 0;

        while (b > 0 && i < list.size()) {
            int p = list.get(i);

            if (p + 1 <= b) {
                ans += p;
                b = b - p - 1;
            } else {
                ans += b - 1;
                b = 0;
            }

            i++;
        }

        return ans;
    }
}
