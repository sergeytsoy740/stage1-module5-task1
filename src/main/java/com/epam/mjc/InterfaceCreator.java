package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public static void main(String[] args) {
        InterfaceCreator interfaceCreator = new InterfaceCreator();


        List<String> names = Arrays.asList("Helli", "MJC");

        System.out.println(interfaceCreator.isValuesStartWithUpperCase().test(names));


        List<Integer> numsList = new ArrayList<>(List.of(48, 13, 100, 5, 222, 3));

        interfaceCreator.addEvenValuesAtTheEnd().accept(numsList);

        System.out.println(numsList);


        List<String> sourceList = new ArrayList<>(List.of("hello world in Java.", "MJC is a great school."));

        System.out.println(interfaceCreator.filterCollection(sourceList).get());


        Map<String, Integer> function = interfaceCreator.stringSize().apply(names);

        System.out.println(function);

    }

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> strings
                .stream()
                .allMatch(s -> Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            List<Integer> arrayList = new ArrayList<>(integers);
            arrayList.forEach(x -> {
                if (x % 2 == 0) {
                    integers.add(x);
                }
            });
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> sortedList;
            sortedList = values.stream()
                    .filter(s -> Character.isUpperCase(s.charAt(0)))
                    .filter(s -> s.charAt(s.length() - 1) == '.')
                    .filter(s -> (s.split("\\s").length) > 3)
                    .collect(Collectors.toList());
            return sortedList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> strings.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> {
            List<Integer> res = new ArrayList<>(integers);
            res.addAll(integers2);
            return res;
        };
    }
}
