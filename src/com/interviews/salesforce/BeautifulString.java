package com.interviews.salesforce;

/**
 * A string is beautiful if no two adjacent characters are:
 *
 * <ul>
 *     <li>Either the same, for example {@code 'aa'}.</li>
 *     <li>Adjacent in the alphabet, for example {@code 'ef'}.</li>
 * </ul>
 *
 * <p>The following operation can be performed on a string {@code s}:</p>
 *
 * <ul>
 *     <li>Choose any index {@code i} ({@code 0 <= i < |s|}) and change {@code s[i]} to any
 *     lowercase English letter.</li>
 * </ul>
 *
 * <p>Find the minimum number of operations required to make the string beautiful.</p>
 *
 * <h2>Example</h2>
 * <p>{@code s = "abdde"}</p>
 *
 * <p>String {@code s} is not beautiful because:</p>
 *
 * <ul>
 *     <li>{@code 'dd'} violates constraint 1, no two adjacent characters are the same.</li>
 *     <li>{@code 'ab'} and {@code 'de'} violate constraint 2, no two adjacent characters are
 *     adjacent in the alphabet.</li>
 * </ul>
 *
 * <p>The string can be converted into a beautiful string after 2 operations. One solution is below.</p>
 *
 * <ul>
 *     <li>Choose {@code i = 1} and change {@code s[i]} to {@code 'z'}. {@code s} becomes
 *     {@code "azdde"}.</li>
 *     <li>Choose {@code i = 3} and change {@code s[i]} to {@code 'k'}. {@code s} becomes
 *     {@code "azdke"}, which is beautiful.</li>
 * </ul>
 *
 * <p>Note: There are many other solutions such as {@code "ardze"}, {@code "axdke"}, etc.
 * It can be shown that 2 is the minimum number of operations required, so return 2.</p>
 */
public class BeautifulString {

    public static void main(String[] args) {
        BeautifulString o = new BeautifulString();
        String s = "abdde";
        System.out.println(o.getMinimumOperationCount(s));
    }

    public int getMinimumOperationCount(String s) {
        //TODO
        return 0;
    }
}
