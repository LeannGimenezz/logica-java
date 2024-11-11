package com.app.Stream;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Juan",14));
        users.add(new User("Pedris",18));
        users.add(new User("Anuel",30));
        users.add(new User("Lean",20));
        users.add(new User("Jhon",11));
        users.add(new User("Carlos",12));

        Comparator<User> comparatorAge = Comparator.comparingInt(user -> user.getAge());
        users.stream().sorted(comparatorAge).forEach(u -> System.out.println(u.getName()));

        Comparator<User> comparatorName = Comparator.comparing(user ->user.getName());
        users.stream().sorted(comparatorName).forEach(u -> System.out.println(u.getName()));

        User otherUser = new User("Other User", 0);
        User user1 = users.stream().filter(u -> u.getAge() == 20).findFirst().orElse(otherUser);
        System.out.println(user1.getName());

        Long count = users.stream()
                .filter(user -> user.getAge() > 18)
                .filter(user -> user.getName().startsWith("J"))
                .count();
        //Filter -> Return -> New Stream
        //.count() -> Return -> Long
        System.out.println(count);

        //.collect() -> Return -> List
        users.stream().filter(user -> user.getAge() > 15).collect(Collectors.toList());

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        List<Integer> result = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());

        System.out.println(result);

        double average = numbers.stream().mapToInt( n -> n).average().orElse(0.0);
        System.out.println(average);

        int min = numbers.stream().mapToInt(n -> n).min().getAsInt();

        int max = numbers.stream().mapToInt(n -> n).max().getAsInt();

        System.out.println(min+" " +max);

        numbers.stream()
                .forEach(num -> {
                    int res = num*num;
                    System.out.println(res);
                });
        List<String> names1 = List.of("Lean 1","Lean 2");
        List<String> names2 = List.of("Lean 3","Lean 4");
        List<String> names3 = List.of("Lean 5","Lean 6");

        List<String> names = Stream.of(names1,names2,names3).flatMap(e -> e.stream())
                .collect(Collectors.toList());


        System.out.println(names);
        boolean valid = numbers.stream().anyMatch(e -> e > 8);
        System.out.println(valid);

        List<String> uniqueNames = List.of("Lean","Juan","Pedro","Lean");

        uniqueNames.stream().distinct().forEach(e -> System.out.println(e));

        List<Integer> unsortedNumbers = List.of(2,5,7,2,6,4,3,55,33,22,66,88,1);

        List<Integer> sortedNumbers = unsortedNumbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers);

        List<Integer> reverseSortedNumbers = unsortedNumbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseSortedNumbers);



    }
}

