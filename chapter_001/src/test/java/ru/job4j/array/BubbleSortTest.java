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
    @Test
    public void whenCheckSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {2, 3, 6, 8, 10, 11, 12, 15, 22, 50};
        boolean result = bubbleSort.checkSort(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenCheckNoSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {10, 11, 12, 15, 8, 6, 2, 3, 22, 50};
        boolean result = bubbleSort.checkSort(input);
        assertThat(result, is(false));
    }
    @Test
    public void whenMergeSortedArrays() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input1 = new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17, 60};
        int[] input2 = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 50};
        int[] result = bubbleSort.sortMerge(input1, input2);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 50, 60};
        assertThat(result, is(expect));
    }
}
