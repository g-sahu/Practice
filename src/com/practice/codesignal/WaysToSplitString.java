package com.practice.codesignal;

/**
 * You are given a string {@code s}. Your task is to count the number of ways of splitting
 * {@code s} into three non-empty parts {@code a}, {@code b}, and {@code c}
 * ({@code s = a + b + c}) in such a way that {@code a + b}, {@code b + c}, and {@code c + a}
 * are all different strings.
 *
 * <p>Note: {@code +} refers to string concatenation.</p>
 *
 * <h2>Example</h2>
 * <p>For {@code s = "xzxzx"}, the output should be {@code solution(s) = 5}.</p>
 *
 * <p>Consider all the ways to split {@code s} into three non-empty parts:</p>
 *
 * <pre>
 * If a = "x", b = "z" and c = "xzx", then all a + b = "xz", b + c = "zxzx" and c + a = "xzxx" are different.
 * If a = "x", b = "zx" and c = "zx", then all a + b = "xzx", b + c = "zxzx" and c + a = "zxx" are different.
 * If a = "x", b = "zxz" and c = "x", then all a + b = "xzxz", b + c = "zxzx" and c + a = "xx" are different.
 * If a = "xz", b = "x" and c = "zx", then a + b = b + c = "xzx". Hence, this split is not counted.
 * If a = "xz", b = "xz" and c = "x", then all a + b = "xzxz", b + c = "xzx" and c + a = "xxz" are different.
 * If a = "xzx", b = "z" and c = "x", then all a + b = "xzxz", b + c = "zx" and c + a = "xxzx" are different.
 * </pre>
 *
 * <p>Since there are five valid ways to split {@code s}, the answer is 5.</p>
 */
public class WaysToSplitString {

    public static void main(String[] args) {
        String s = "xzxzx";
        WaysToSplitString obj = new WaysToSplitString();
        System.out.println(obj.solution(s));
    }

    int solution(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 1; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, j);
                String s3 = s.substring(j, n);

                if (!(s1 + s2).equals(s2 + s3)
                        && !(s2 + s3).equals(s3 + s1)
                        && !(s3 + s1).equals(s1 + s2)) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
