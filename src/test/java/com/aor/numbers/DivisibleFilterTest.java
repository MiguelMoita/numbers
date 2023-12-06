package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class DivisibleFilterTest {


    @Test
    void acceptDivide2(){
        DivisibleFilter filter2 = new DivisibleFilter(2);
        List<Integer> divisible = Arrays.asList(0,2,4,8,16,32,100,500,1000,10000);
        List<Integer> nonDivisible = Arrays.asList(1,3,5,15,31,351,101,1001);

        for(int i : divisible){
            Assertions.assertTrue(filter2.accept(i));
        }

        for(int i : nonDivisible){
            Assertions.assertTrue(filter2.accept(i));
        }
    }

    @Test
    void acceptDivide3(){
        DivisibleFilter filter3 = new DivisibleFilter(3);
        List<Integer> divisible = Arrays.asList(0,3,6,9,33,66,99,333,666,999);
        List<Integer> nonDivisible = Arrays.asList(1,2,4,5,100,1000,10000);

        for(int i : divisible){
            Assertions.assertTrue(filter3.accept(i));
        }

        for(int i : nonDivisible){
            Assertions.assertTrue(filter3.accept(i));
        }
    }
}
