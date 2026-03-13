public class SelectionSort {
    static int[] a = {37, 12, 45, 2, 18, 25, 7, 30, 50, 1, 19, 5};

    static void setArray(int[] arr) {
        a = arr;
    }

    static void selectionSort() {
        selectionSort(true);
    }

    static void selectionSort(boolean print) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                if (print) {
                    printLine(i, minIdx);
                }
                swap(i, minIdx);
            }
        }
    }

    static void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static void printLine(int i, int minIdx) {
        StringBuilder line = new StringBuilder();
        for (int idx = 0; idx < a.length; idx++) {
            int val = a[idx];
            if (idx == i) {
                line.append(center("(" + val + ")", 6));
            } else if (idx == minIdx) {
                line.append(center("[" + val + "]", 6));
            } else {
                line.append(center(String.valueOf(val), 6));
            }
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
        printLine(-1, -1);
        System.out.println();
        selectionSort();
    }
}
