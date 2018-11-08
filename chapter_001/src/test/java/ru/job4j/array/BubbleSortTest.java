package ru.job4j.array;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {10, 11, 12, 15, 8, 6, 2, 3, 22, 50};
        int[] result = bubbleSort.sort(input);
        int[] expect = new int[] {2, 3, 6, 8, 10, 11, 12, 15, 22, 50};
        assertThat(result, is(expect));
    }
}
