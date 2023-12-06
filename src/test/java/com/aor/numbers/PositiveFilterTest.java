package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {

    @Test
    void accept() {
        PositiveFilter filter = new PositiveFilter();
        List<Integer> positives = Arrays.asList(1,2,3,100,1000, Integer.MAX_VALUE);
        List<Integer> nonPositives = Arrays.asList(0,-1,-2,-3,-10,-100,Integer.MIN_VALUE);

        for (int i : positives){
            Assertions.assertTrue(filter.accept(i));
        }

        for (int i : nonPositives){
            Assertions.assertTrue(filter.accept(i));
        }
    }
}
