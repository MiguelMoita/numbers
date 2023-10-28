package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {



    @Test
    public void deduplicate() {

        List<Integer> list = Arrays.asList(1,2,4,2,5);
        List<Integer> expected = Arrays.asList(1,2,4,5);

        GenericListSorter listSorted = Mockito.mock(GenericListSorter.class);
        Mockito.when(listSorted.sort(Mockito.anyList())).thenReturn(Arrays.asList(1,2,2,4,5));

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, listSorted);

        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void bug_deduplicate_8726(){

        List<Integer> list = Arrays.asList(1,2,4,2);
        List<Integer> expected = Arrays.asList(1,2,4);

        GenericListSorter listSorted = Mockito.mock(GenericListSorter.class);
        Mockito.when(listSorted.sort(Mockito.anyList())).thenReturn(Arrays.asList(1,2,2,4));

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, listSorted);

        Assertions.assertEquals(expected, distinct);

    }
}
