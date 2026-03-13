public class HeapSort {

    static int[] a = {37, 12, 45, 2, 18, 25, 7, 30, 50, 1, 19, 5}; 
    
    static void heapify(int n, int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < n && a[left] > a[largest]) {
                largest = left;
            }
            if (right < n && a[right] > a[largest]) {
                largest = right;
            }

            if (largest != i) {
                swap(i, largest);
                i = largest;
                continue;
            }
            break;
        }
    }

    static void buildMaxHeap(int n) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(n, i);
        }
    }

    static void setArray(int[] arr) {
        a = arr;
    }

    static void heapSort() {
        heapSort(true);
    }

    static void heapSort(boolean print) {
        int n = a.length;

        if (print) {
            System.out.println("Initial array:");
            printLine(-1, false, false, 0, n - 1, null, null);
            System.out.println();
        }

        buildMaxHeap(n);

        if (print) {
            System.out.println("After initial heap construction:");
            printLine(-1, false, false, 0, n - 1, null, null);
            System.out.println();
        }

        for (int end = n - 1; end > 0; end--) {
            if (print) {
                printLine(0, true, false, 0, end, null, null);
            }

            swap(0, end);
            if (print) {
                printLine(-1, false, false, 0, end - 1, null, null);

                heapify(end, 0);
                printLine(-1, false, false, 0, end - 1, null, null);
                System.out.println();
            } else {
                heapify(end, 0);
            }
        }
    }

    static void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static void printLine(
        int pivotPos,
        boolean pivotSelected,
        boolean pivotFinallyPlaced,
        Integer partitionLeftPos,
        Integer partitionRightPos,
        Integer swappedLeft,
        Integer swappedRight
    ) {
        int numWidth = 1;
        for (int value : a) {
            numWidth = Math.max(numWidth, String.valueOf(value).length());
        }
        int cellWidth = numWidth + 2;

        StringBuilder line = new StringBuilder();
        for (int idx = 0; idx < a.length; idx++) {
            String sval = String.format("%" + numWidth + "d", a[idx]);
            String cell;

            if (idx == pivotPos && pivotSelected) {
                cell = String.format("%" + cellWidth + "s", "(" + sval + ")");
            } else if (idx == pivotPos && pivotFinallyPlaced) {
                cell = String.format("%" + cellWidth + "s", "[" + sval + "]");
            } else {
                cell = String.format("%" + cellWidth + "s", " " + sval + " ");
            }

            if (partitionLeftPos != null && idx == partitionLeftPos) {
                line.append("| ");
            }
            line.append(cell);
            if (partitionRightPos != null && idx == partitionRightPos) {
                line.append(" |");
            }
            line.append("  ");
        }

        System.out.println(line.toString().stripTrailing());
    }

    public static void main(String[] args) {
        heapSort();
    }
}
