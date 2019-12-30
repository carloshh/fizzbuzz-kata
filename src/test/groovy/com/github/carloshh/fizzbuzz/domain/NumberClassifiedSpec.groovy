package com.github.carloshh.fizzbuzz.domain

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class NumberClassifiedSpec extends Specification {

    def "Is #number a Fizz? #result"() {
        expect:
        def numberUnclassified = new NumberUnclassified(number)
        result == numberUnclassified.isFizz()

        where:
        number || result
        1      || false
        2      || false
        3      || true
        4      || false
        5      || false
        6      || true
        7      || false
        8      || false
        9      || true
        10     || false
    }

    def "Is #number a Buzz? #result"() {
        expect:
        def numberUnclassified = new NumberUnclassified(number)
        result == numberUnclassified.isBuzz()

        where:
        number || result
        1      || false
        2      || false
        3      || false
        4      || false
        5      || true
        6      || false
        7      || false
        8      || false
        9      || false
        10     || true
    }

    def "Is #number a FizzBuzz? #result"() {
        expect:
        def numberUnclassified = new NumberUnclassified(number)
        result == numberUnclassified.isFizzBuzz()

        where:
        number || result
        1      || false
        2      || false
        3      || false
        4      || false
        5      || false
        6      || false
        7      || false
        8      || false
        9      || false
        10     || false
        11     || false
        12     || false
        13     || false
        14     || false
        15     || true
    }

}
