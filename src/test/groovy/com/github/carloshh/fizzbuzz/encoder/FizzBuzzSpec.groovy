package com.github.carloshh.fizzbuzz.encoder

import com.github.carloshh.fizzbuzz.encoder.FizzBuzzEncoder
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class FizzBuzzSpec extends Specification {
    def fizzBuzzEncoder = new FizzBuzzEncoder()

    def "#number is #result"() {
        expect:
        fizzBuzzEncoder.encode(number, number).get(0) == result

        where:
        number || result
        1      || "1"
        2      || "2"
        3      || "Fizz"
        4      || "4"
        5      || "Buzz"
        6      || "Fizz"
        7      || "7"
        8      || "8"
        9      || "Fizz"
        10     || "Buzz"
        11     || "11"
        12     || "Fizz"
        13     || "13"
        14     || "14"
        15     || "FizzBuzz"
    }

}