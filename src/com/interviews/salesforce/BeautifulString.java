package com.interviews.salesforce;

/*
A string is beautiful if no two adjacent characters are
• either the same, for example 'aa'
• adjacent in the alphabet, for example 'ef'.

The following operations can be performed on a string, s.
• Choose any index i (0 ≤ i < |s|) and change s[i] to any lowercase English letter.

Find the minimum number of operations required to make the string beautiful.

Example -
s = "abdde"
String s is not beautiful because:
• 'dd' violates constraint 1, no two adjacent characters are the same.
• 'ab' and 'de' violate constraint 2, no two adjacent characters are adjacent in the alphabet.

The string can be converted into a beautiful string after 2 operations. One solution is below.
• Choose i=1 and change s[i] to 'z'. s becomes "azdde".
• Choose i=3 and change s[i] to 'k'. s becomes "azdke" which is beautiful.

Note: There are many other solutions such as "ardze", "axdke", etc.
It can be shown that 2 is the minimum number of operations required so return 2.
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
