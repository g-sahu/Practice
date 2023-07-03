package com.practice.codesignal;

public class CenturyFromYear {

    public static void main(String[] args) {
        int[] years = new int[]{1, 10, 20, 30, 99, 100, 101, 1000, 1001, 1010, 1999, 2000, 2001};
        CenturyFromYear centuryFromYear = new CenturyFromYear();

        for (int year: years) {
            System.out.println("Year: " + year + ", Century: " + centuryFromYear.solution(year));
        }
    }

    int solution(int year) {
        int century = year / 100;

        if (year % 100 == 0) {
            return century == 0 ? 1 : century;
        } else {
            return century + 1;
        }
    }
}
