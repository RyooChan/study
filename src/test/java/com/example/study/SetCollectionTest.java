package com.example.study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Integer.*;
import static org.apache.logging.log4j.util.Strings.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("BeforeEach를 통해 세팅된 set의 크기가 size를 통해 반환되도록 구현한다.")
    void isSize_ShouldReturnSetSize() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("BeforeEach를 통해 세팅된 set이 elements를 가지는지 확인하도록 구현한다.")
    @ValueSource(ints = {1, 2, 3})
    void isContains_ShouldReturnSetElements(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }


    @ParameterizedTest
    @DisplayName("BeforeEach를 통해 세팅된 set이 세팅된 값만들 가지는지 확인하도록 구현한다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void isContains_ShouldReturnOnlyExceptedSetElements(String input, boolean expected) {
        boolean contains = numbers.contains(parseInt(input));
        assertEquals(expected, contains);
    }
}
