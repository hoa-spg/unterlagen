public class Sortieren {
    public static void bubbleSort(int[] a) {
        BubbleSort.setArray(a);
        BubbleSort.bubbleSort(false);
    }

    public static void bubbleSortOptimiert(int[] a) {
        BubbleSort.setArray(a);
        BubbleSort.bubbleSortOptimiert(false);
    }

    public static void insertionSort(int[] a) {
        InsertionSort.setArray(a);
        InsertionSort.insertionSort(false);
    }

    public static void selectionSort(int[] a) {
        SelectionSort.setArray(a);
        SelectionSort.selectionSort(false);
    }

    public static void mergeSort(int[] a) {
        MergeSort.setArray(a);
        MergeSort.mergeSortIterative(false);
    }

    public static void quickSort(int[] a) {
        QuickSort.setArray(a);
        QuickSort.quicksort(0, a.length - 1, false);
    }

    public static void heapSort(int[] a) {
        HeapSort.setArray(a);
        HeapSort.heapSort(false);
    }
}
