package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    private List<Integer> list;

    @BeforeEach
    public void helper(){
    list = Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator();
        ListSorter listSorted = new ListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator();

        int distinct = aggregator.distinct(list,deduplicator,listSorted);

        Assertions.assertEquals(4, distinct);
    }
    @Test
    public void max_bug_7263() {
        list = Arrays.asList(-1,-4,-5);
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.max(list);

        Assertions.assertEquals(-1, distinct);
    }
    @Test
    public void distinct_bug_8726() {
        list = Arrays.asList(1,2,4,2);
        ListAggregator aggregator = new ListAggregator();
        GenericListSorter listSorted = Mockito.mock(GenericListSorter.class);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);

        Mockito.when(listSorted.sort(list)).thenReturn(Arrays.asList(1,2,2,4));
        Mockito.when(deduplicator.deduplicate(list,listSorted)).thenReturn(Arrays.asList(1,2,4));

        int distinct = aggregator.distinct(list,deduplicator,listSorted);

        Assertions.assertEquals(3, distinct);
    }
}





