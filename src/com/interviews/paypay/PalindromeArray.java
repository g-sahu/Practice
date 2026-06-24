package com.interviews.paypay;

/**
 * An array is called palindromic if it remains the same after reversing the order of its elements.
 * You have an array of strings {@code arr}. For each {@code i}, {@code arr[i]} consists of at
 * least two characters. For each pair of consecutive elements {@code arr[i]} and {@code arr[i + 1]},
 * you can:
 *
 * <ul>
 *     <li>Move the rightmost character of {@code arr[i]} to the leftmost position in
 *     {@code arr[i + 1]}. For instance, {@code "abc"} and {@code "def"} will become
 *     {@code "ab"} and {@code "cdef"}. This operation can be applied only once to any pair
 *     of consecutive elements.</li>
 *     <li>Move the leftmost character of {@code arr[i + 1]} to the rightmost position in
 *     {@code arr[i]}. For instance, {@code "abc"} and {@code "def"} will become
 *     {@code "abcd"} and {@code "ef"}. Again, this operation can be applied only once to
 *     any pair of consecutive elements.</li>
 *     <li>Do nothing to the pair of consecutive elements.</li>
 * </ul>
 *
 * <p>Is it possible to obtain a palindromic array from {@code arr} by performing these operations?</p>
 *
 * <h2>Examples</h2>
 * <ol>
 *     <li>For {@code arr = ["aa", "bab", "cde", "aba", "ab"]}, the output should be
 *     {@code solution(arr) = true}.
 *     <ul>
 *         <li>Apply the second operation to {@code "aa"} and {@code "bab"}.</li>
 *         <li>Apply the first operation to {@code "aba"} and {@code "ab"}.</li>
 *     </ul>
 *     This gives us the following array: {@code ["aab", "ab", "cde", "ab", "aab"]}, which
 *     is palindromic.</li>
 *     <li>For {@code arr = ["palindrome"]}, the output should be {@code solution(arr) = true}.
 *     The given array is already palindromic, so no operations are needed.</li>
 *     <li>For {@code arr = ["aaaaaa", "aa"]}, the output should be {@code solution(arr) = false}.
 *     If moving two characters between two consecutive array elements was allowed, the array could
 *     have been made palindromic, but this is impossible given the actual rules.</li>
 * </ol>
 *
 * <h2>Input/Output</h2>
 * <ul>
 *     <li>[execution time limit] 3 seconds (java)</li>
 *     <li>[memory limit] 1 GB</li>
 *     <li>[input] array.string {@code arr} An array of strings.</li>
 * </ul>
 *
 * <p>Guaranteed constraints:</p>
 * <ul>
 *     <li>1 &le; {@code arr.length} &le; 105</li>
 *     <li>2 &le; {@code arr[i].length} &le; 10</li>
 * </ul>
 *
 * <p>[output] boolean</p>
 *
 * <p>Return {@code true} if the given array can be turned into a palindromic array, otherwise
 * return {@code false}.</p>
 */
public class PalindromeArray {

    boolean solution(String[] arr) {
        boolean isPalindromic = false;
        return isPalindromic;
    }

}
