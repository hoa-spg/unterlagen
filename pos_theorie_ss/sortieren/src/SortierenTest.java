import java.util.Random;

class SortierenTest {

    private int[] a = {3, -4, 9, 6, 0, -4, 5, 7, 1};

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Random rnd = new Random();
        a = new int[100_000];
        for (int i=0; i<a.length; i++) {
            a[i] = rnd.nextInt(100_000);
        }
    }

    @org.junit.jupiter.api.Test
    void sortierenBubbleSortEinfach() {
        Sortieren.bubbleSort(a);
        assertSorted(a);
    }

    @org.junit.jupiter.api.Test
    void sortierenBubbleSortOptimiert() {
        Sortieren.bubbleSortOptimiert(a);
        assertSorted(a);
    }

    @org.junit.jupiter.api.Test
    void sortierenInsertionSort() {
        Sortieren.insertionSort(a);
        assertSorted(a);
    }

    @org.junit.jupiter.api.Test
    void sortierenSelectionSort() {
        Sortieren.selectionSort(a);
        assertSorted(a);
    }

    @org.junit.jupiter.api.Test
    void sortierenHeapSort() {
        Sortieren.heapSort(a);
        assertSorted(a);
    }

    @org.junit.jupiter.api.Test
    void sortierenQuickSort() {
        Sortieren.quickSort(a);
        assertSorted(a);
    }

    @org.junit.jupiter.api.Test
    void sortierenMergeSort() {
        Sortieren.mergeSort(a);
        assertSorted(a);
    }

    private void assertSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            assert(a[i] <= a[i+1]);
        }
    }

    private void printArray(int[] a) {
        for (int i=0; i<a.length; i++) {
            System.out.print((i!=0 ? ", " : "") + a[i]);
        }
        System.out.println();
    }

}
