public class MergeSort {

    static int[] a = {37, 12, 45, 2, 18, 25, 7, 30, 50, 1, 19, 5};

    static void setArray(int[] arr) {
        a = arr;
    }

    static void mergeSortIterative() {
        mergeSortIterative(true);
    }

    static void mergeSortIterative(boolean print) {
        int n = a.length;
        int size = 1;
        int level = 0;

        while (size < n) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);

                if (mid < right) {
                    merge(left, mid, right);
                }
            }
            level += 1;
            if (print) {
                printLine(level, size);
            }
            size *= 2;
        }
    }

    static void merge(int left, int mid, int right) {
        int[] leftPart = new int[mid - left + 1];
        int[] rightPart = new int[right - mid];

        System.arraycopy(a, left, leftPart, 0, leftPart.length);
        System.arraycopy(a, mid + 1, rightPart, 0, rightPart.length);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                a[k] = leftPart[i];
                i += 1;
            } else {
                a[k] = rightPart[j];
                j += 1;
            }
            k += 1;
        }

        while (i < leftPart.length) {
            a[k] = leftPart[i];
            i += 1;
            k += 1;
        }

        while (j < rightPart.length) {
            a[k] = rightPart[j];
            j += 1;
            k += 1;
        }
    }

    static void printLine(int level, int size) {
        StringBuilder line = new StringBuilder();
        int step = size * 2;

        for (int idx = 0; idx < a.length; idx++) {
            if (idx % step == 0) {
                line.append("|");
            }
            line.append(center(String.valueOf(a[idx]), 6));
        }
        line.append("|");

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
        printLine(0, 1);
        System.out.println();
        mergeSortIterative();
    }
}
