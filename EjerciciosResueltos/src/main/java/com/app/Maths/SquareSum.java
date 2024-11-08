package com.app.Maths;

//Complete the square sum function so that it squares each number passed into it and then sums the results together.
//
//For example, for [1, 2, 2] it should return 9 because 1^2 + 2 ^ 2 + 2^2 = 9
public class SquareSum {

    public static void main(String[] args) {

        int total = 0;
        int[] numbers = {1, 2, 2};
        for(int n: numbers){
            total += n * n;
        }
        System.out.println(total);

    }
}
