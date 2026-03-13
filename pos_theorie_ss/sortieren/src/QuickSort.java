public class QuickSort {

    static int[] a = {37, 12, 45, 2, 18, 25, 7, 30, 50, 1, 19, 5};

    static void setArray(int[] arr) {
        a = arr;
    }

    static void quicksort() {
        quicksort(0, a.length - 1, true);
    }

    static void quicksort(int left, int right) {
        quicksort(left, right, true);
    }

    static void quicksort(int left, int right, boolean print) {
        if (left < right) {
            int pidx = partition(left, right, print);
            quicksort(left, pidx - 1, print);
            quicksort(pidx + 1, right, print);
        }
    }

    // Variant of Hoare's partition scheme (used here)
    static int partition(int left, int right, boolean print) {
        int pivot = a[right];
        if (print) {
            printLine(right, true, false, left, right, null, null);
        }

        int i = left;
        int j = right - 1;
        while (i < j) {
            while (a[i] < pivot) {
                i += 1;
            }
            while (j > left && a[j] >= pivot) {
                j -= 1;
            }

            if (i < j) {
                swap(i, j, print);
                i += 1;
                j -= 1;
                if (print) {
                    printLine(-1, false, false, left, right, null, null);
                }
            }
        }

        if (i == j && a[i] < pivot) {
            i += 1;
        }

        if (a[i] != pivot) {
            swap(i, right, print);
        }

        if (print) {
            printLine(i, false, true, left, right, null, null);
            System.out.println();
        }
        return i;
    }

    // Lomuto's partition scheme (not used here)
    // static int partition2(int left, int right) {
    //     int pivot = a[right];
    //     int i = left;
    //     for (int j = left; j <= right; j++) {
    //         if (a[j] < pivot) {
    //             swap(i, j);
    //             printLine(-1, false, false, left, right, null, null);
    //             i += 1;
    //         }
    //     }
    //     swap(i, right);
    //
    //     printLine(i, false, false, left, right, null, null);
    //     System.out.println();
    //     return i;
    // }

    static void swap(int i, int j, boolean print) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        if (print) {
            printLine(-1, false, false, null, null, Math.min(i, j), Math.max(i, j));
        }
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
        StringBuilder line = new StringBuilder();
        for (int idx = 0; idx < a.length; idx++) {
            int val = a[idx];
            line.append((partitionLeftPos != null && idx == partitionLeftPos) ? ">" : " ");

            if (idx == pivotPos && pivotSelected) {
                line.append(center("(" + val + ")", 6));
            } else if (idx == pivotPos && pivotFinallyPlaced) {
                line.append(center("[" + val + "]", 6));
            } else if (swappedLeft != null && idx == swappedLeft) {
                line.append(center("l*" + val, 6));
            } else if (swappedRight != null && idx == swappedRight) {
                line.append(center("r*" + val, 6));
            } else {
                line.append(center(String.valueOf(val), 6));
            }

            line.append((partitionRightPos != null && idx == partitionRightPos) ? "<" : " ");
        }
        System.out.println(line);
    }

    static String center(String s, int width) {
        if (s.length() >= width) {
            return s;
        }
        int totalPadding = width - s.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        return " ".repeat(leftPadding) + s + " ".repeat(rightPadding);
    }

    public static void main(String[] args) {
        printLine(-1, false, false, 0, a.length - 1, null, null);
        System.out.println();
        quicksort(0, a.length - 1);
    }
}
