package com.practice.leetcode;

/*
1248. Count Number of Nice Subarrays
 */
public class CountNiceSubarrays {

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        CountNiceSubarrays o = new CountNiceSubarrays();
        System.out.println(o.numberOfSubarrays(nums, 3));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int j = 0;
        int odds = 0;
        int l = nums.length;

        while (j < k) {
            if (isOdd(nums[j++])) {
                odds++;
            }
        }

        int i = 0;
        int ans = 0;

        while (j < l) {
            if (odds == 3) {
                ans++;

                if (isOdd(nums[j])) {
                    if (isOdd(nums[i])) {
                        odds--;
                    }
                    i++;
                }
            } else {

            }

            if (isOdd(nums[j++])) {
                odds--;
            }

            if (isOdd(nums[j+1])) {
                odds++;
            }

            if (odds == 3) {
                ans++;
            }

            j--;
        }

        return ans;
    }

    private static boolean isOdd(int nums) {
        return nums % 2 != 0;
    }
}
