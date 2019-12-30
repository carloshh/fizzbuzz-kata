package com.github.carloshh.fizzbuzz.encoder;

import com.github.carloshh.fizzbuzz.domain.NumberClassified;
import com.github.carloshh.fizzbuzz.domain.NumberUnclassified;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public final class FizzBuzzEncoder {
    private static final String FIZZ_BUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public List<String> encode(int from, int to) {
        var numbers = IntStream.rangeClosed(from, to).mapToObj(NumberUnclassified::new).collect(toList());

        var classifiedFizzBuzz = classifyNumber(numbers.parallelStream().filter(NumberUnclassified::isFizzBuzz), FIZZ_BUZZ);

        var numbersNotFizzBuzz =  numbers.parallelStream().filter(not(NumberUnclassified::isFizzBuzz)).collect(toSet());
        var classifiedFizz = classifyNumber(numbersNotFizzBuzz.parallelStream().filter(NumberUnclassified::isFizz), FIZZ);
        var classifiedBuzz = classifyNumber(numbersNotFizzBuzz.parallelStream().filter(NumberUnclassified::isBuzz), BUZZ);
        var classifiedJustNumbers = retrieveJustNumbers(numbers);

        return Stream.of(classifiedFizzBuzz, classifiedFizz, classifiedBuzz, classifiedJustNumbers)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList())
                            .stream()
                            .sorted(Comparator.comparingInt(NumberClassified::getNumber))
                            .map(NumberClassified::getValue)
                            .collect(toList());
    }

    private List<NumberClassified> classifyNumber(Stream<NumberUnclassified> numberUnclassifiedStream, String classification) {
        return numberUnclassifiedStream
                .map(e -> new NumberClassified(e.getNumber(), classification))
                .collect(toList());
    }

    private List<NumberClassified> retrieveJustNumbers(List<NumberUnclassified> unclassifiedNumbers) {
        return unclassifiedNumbers.parallelStream()
                    .filter(not(NumberUnclassified::isFizzBuzz))
                    .filter(not(NumberUnclassified::isFizz))
                    .filter(not(NumberUnclassified::isBuzz))
                    .map(e -> new NumberClassified(e.getNumber(), String.valueOf(e.getNumber())))
                    .collect(toList());
    }

}
