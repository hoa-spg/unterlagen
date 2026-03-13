public class InsertionSort {
    static int[] a = {37, 12, 45, 2, 18, 25, 7, 30, 50, 1, 19, 5};

    static void setArray(int[] arr) {
        a = arr;
    }

    static void insertionSort() {
        insertionSort(true);
    }

    static void insertionSort(boolean print) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j -= 1;
            }
            a[j + 1] = key;
            if (print) {
                printLine(j + 1, i);
            }
        }
    }

    static void printLine(int insertedIndex, int originalIndex) {
        StringBuilder line = new StringBuilder();
        for (int idx = 0; idx < a.length; idx++) {
            int val = a[idx];
            if (idx == originalIndex && idx == insertedIndex) {
                line.append(center("[" + val + "]|", 6));
            } else if (idx == insertedIndex) {
                line.append(center("[" + val + "]", 6));
            } else if (idx == originalIndex) {
                line.append(center(" " + val + "|", 6));
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
        insertionSort();
    }
}
