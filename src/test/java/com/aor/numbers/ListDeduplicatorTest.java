package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    @Test
    public void deduplicate() {

        class FakeSorter implements GenericListSorter {
            @Override
            public List<Integer> sort(List<java.lang.Integer> list) {return Arrays.asList(1, 2, 4, 5);}
        }
        List<Integer> list = Arrays.asList(1,2,4,2,5);
        List<Integer> expected = Arrays.asList(1,2,4,5);

        GenericListSorter listSorted = new FakeSorter();
        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, listSorted);

        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void deduplicate_1242(){
        class FakeSorter implements GenericListSorter {
            @Override
            public List<Integer> sort(List<java.lang.Integer> list) {return Arrays.asList(1, 2, 2, 4);}
        }
        List<Integer> list = Arrays.asList(1,2,4,2);
        List<Integer> expected = Arrays.asList(1,2,4);

        GenericListSorter listSorted = new FakeSorter();
        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, listSorted);

        Assertions.assertEquals(expected, distinct);

    }
}
