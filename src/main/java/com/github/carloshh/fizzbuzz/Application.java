package com.github.carloshh.fizzbuzz;

import com.github.carloshh.fizzbuzz.encoder.FizzBuzzEncoder;

public class Application {
    public static void main(String... args) {
        var fizzBuzzEncoder = new FizzBuzzEncoder();

        var fizzBuzzItems = fizzBuzzEncoder.encode(1, 100);

        System.out.println(fizzBuzzItems);
    }
}
