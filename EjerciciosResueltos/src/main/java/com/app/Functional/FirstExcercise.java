package com.app.Functional;


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstExcercise {
    public static void main(String[] args) {

        FunctionInterface hello = name -> {
            System.out.println("Hello " + name);
        };

        hello.SayHello("Leandro");

        ISum total = ((value1, value2) -> value1 + value2);

        int res = total.sum(10, 22);
        System.out.println(res);

        List<Integer> numbers = Arrays.asList(1, 5, 7, 10, 20, 32);


        //Create an anonymous function that allows us to calculate the average of an array of integers.
        double totalAvg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        System.out.println(totalAvg);


        //Create an anonymous function that calculates the factorial given an integer.


        IFactorial factorial = n -> {
            int count = 1;
            for (int i = 1; i <= n; i++) {
                count *= i;
            }
            System.out.println(count);
            return count;
        };
        factorial.factorial(5);


        //Create an anonymous function that allows you to know if a number is even.

        EvenOrOdd functionEx3 = n -> {
            if (n % 2 == 0) {
                return "EVEN";
            } else {
                return "ODD";
            }
        };
        System.out.println(functionEx3.evenOrOdd(5));


        //Given an array of integers, create an anonymous function that returns the largest number.

        LargestNumber largest = n -> Arrays.stream(n).max(Integer::compare).orElse(Integer.MIN_VALUE);
        Integer [] arrNums = {1,2,3,4,5,6};
        System.out.println(largest.Largest(arrNums));

        //Given an array of integers, create an anonymous function that returns the smallest number.

        SmallestNumber smallest = n -> Arrays.stream(n).min(Integer::compare).orElse(Integer.MIN_VALUE);
        Integer [] numsSmallest = {55,96,55,84};
        System.out.println(smallest.smallest(numsSmallest));

        //Given an array of integers, create an anonymous function that returns the number that is repeated the most.

        MostRepeatedNumber most =(int[] nums) -> {
            Map<Integer, Long> frequencyMap = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            return frequencyMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(-1);
        };
        int [] numsss = {1,2,3,3,4,4,5,5,5,1,1,1};
        int numRepeated = most.mostRepeated(numsss);
        System.out.println(numRepeated);

        //Create an anonymous function that receives 3 integers as parameters. The function returns the largest number.

        ThreeIntLargest threeIntLargest = (v1,v2,v3) -> Math.max(v1,Math.max(v2,v3));

        System.out.println(threeIntLargest.ThreeLargest(10,5,20));

        //Create an anonymous function that receives two parameters, a string and an integer. The function returns a string which will be the result of multiplying both parameters.

        StringInt stringInt = (v1,v2) -> {
            String value = "";
            for(int i = 0; i<v2;i++){
                value = value.concat(v1);
            }
            return value;
        };
        System.out.println(stringInt.StringInt("Perro",5));
    }

}
