public class BubbleSort {

    static int[] a = {37, 12, 45, 2, 18, 25, 7, 30, 50, 1, 19, 5};

    static void setArray(int[] arr) {
        a = arr;
    }

    static void bubbleSort() {
        bubbleSort(true);
    }

    static void bubbleSort(boolean print) {
        boolean vertauscht = true;
        while (vertauscht) {
            vertauscht = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i + 1] < a[i]) {
                    swap(i, i + 1);
                    vertauscht = true;
                }
            }
        }
    }

    static void bubbleSortOptimiert(boolean print) {
        boolean vertauscht = true;
        int durchlauf = 1;
        while (vertauscht) {
            vertauscht = false;
            for (int i = 0; i < a.length - durchlauf; i++) {
                if (a[i + 1] < a[i]) {
                    swap(i, i + 1);
                    vertauscht = true;
                }
            }
            durchlauf++;
        }

    }
    static void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static void printLine() {
        StringBuilder line = new StringBuilder();
        for (int val : a) {
            line.append(center(String.valueOf(val), 6));
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
        printLine();
        System.out.println();
        bubbleSort();
    }
}
