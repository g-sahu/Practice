package com.practice.leetcode;

/**
 * 2469. Convert the Temperature
 */
public class ConvertTheTemperature {

    public double[] convertTemperature(double c) {
        double k = c + 273.15;
        double f = (c * 1.80) + 32.00;
        return new double[]{k, f};
    }
}
