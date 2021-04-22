package ru.geekbrains.lessons.lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class lesson14Test {

    lesson14 lesson14;
    int[] arr1   = {1,2 ,4 ,4 ,2 ,3 ,4 ,1,7};
    int[] result1 = {1,7};
    int[] arr2   = {1,2 ,4 ,4};
    int[] result2 = new int[0];
    int[] arr3   = {1,2 ,5 ,5 ,2 ,3 ,5 ,1,7};
    int[] result3 = {1,7};

    @BeforeEach
    void init() {lesson14 = new lesson14();}



    @Test
    void afterFour1() {
        Assertions.assertArrayEquals(result1,lesson14.afterFour(arr1));
    }
    @Test
    void afterFour2() {
        Assertions.assertArrayEquals(result2,lesson14.afterFour(arr2));
    }
    @Test
    void afterFour3() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            lesson14.afterFour(arr3);
        });

    }


    @ParameterizedTest
    @MethodSource("generateAddData")
    void oneAndFourMassTest(boolean result, int [] arr) {
        Assertions.assertEquals(result, lesson14.oneAndFour(arr));
    }

    private static Stream<Arguments> generateAddData() {
        List<Arguments> list = new ArrayList<>();
            int[] arr1 = {1,1,1,4,4,1,4,4};
            boolean result1 = true;
            int[] arr2 = {1,1,1,1,1,1};
            boolean result2 = false;
            int[] arr3 = {4,4,4,4};
            boolean result3 = false;
            int[] arr4 = {4,4,1,1,4,3};
            boolean result4 = false;
            list.add(Arguments.arguments(result1, arr1));
            list.add(Arguments.arguments(result2, arr2));
            list.add(Arguments.arguments(result3, arr3));
            list.add(Arguments.arguments(result4, arr4));

        return list.stream();
    }
}
