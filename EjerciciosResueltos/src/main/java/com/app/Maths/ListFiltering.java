package com.app.Maths;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.stream.Collectors;

//In this kata you will create a function that takes a list of non-negative integers and strings and returns a new list with the strings filtered out.
//
//Example
//Kata.filterList(List.of(1, 2, "a", "b")) => List.of(1,2)
//Kata.filterList(List.of(1, "a", "b", 0, 15)) => List.of(1,0,15)
//Kata.filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123)) => List.of(1, 2, 123)
public class ListFiltering {

    public static void main(String[] args) {

        List<Object> filterList = List.of(1, 2, "a", "b");

        List<Object> finalList = filterList.stream()
                .filter(e -> e instanceof Integer)
                .collect(Collectors.toList());

        System.out.println(finalList);
    }
}
