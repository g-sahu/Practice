package com.practice.leetcode;

/**
 * 278. First Bad Version
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int beg = 1, end = n;
        int bad = 1;

        while(beg <= end) {
            int mid = beg + (end - beg)/2;
            if(isBadVersion(mid)) {
                bad = mid;
                end = mid-1;
            } else {
                beg = mid+1;
            }
        }

        return bad;
    }

    private static boolean isBadVersion(int n) {
        //Returns if n is bad version or not
        return true;
    }
}
