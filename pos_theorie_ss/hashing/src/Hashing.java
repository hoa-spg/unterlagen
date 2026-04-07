import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hashing {
    static class ProbingHashTable {
        private final int m;

        ProbingHashTable(int m) {
            this.m = m;
        }

        private int h0(int key) {
            return key;
        }

        List<Integer[]> linearProbeSequence(int[] keys) {
            Integer[] table = new Integer[m];
            List<Integer[]> snapshots = new ArrayList<>();

            for (int key : keys) {
                int base = h0(key);
                int i = 0;
                boolean placed = false;

                while (i < m) {
                    int pos = (base + i) % m;
                    if (table[pos] == null) {
                        table[pos] = key;
                        snapshots.add(Arrays.copyOf(table, table.length));
                        placed = true;
                        break;
                    }
                    i += 1;
                }

                if (!placed) {
                    throw new RuntimeException("Hash table full, could not insert " + key);
                }
            }

            return snapshots;
        }

        List<Integer[]> quadraticProbeSequence(int[] keys) {
            Integer[] table = new Integer[m];
            List<Integer[]> snapshots = new ArrayList<>();

            for (int key : keys) {
                int base = h0(key);
                int i = 0;
                boolean placed = false;

                while (i < m) {
                    int pos = (base + i + i * i) % m;
                    if (table[pos] == null) {
                        table[pos] = key;
                        snapshots.add(Arrays.copyOf(table, table.length));
                        placed = true;
                        break;
                    }
                    i += 1;
                }

                if (!placed) {
                    throw new RuntimeException("Hash table full, could not insert " + key);
                }
            }

            return snapshots;
        }

        static int[] formatIndices(Integer[] table) {
            int[] indices = new int[table.length];
            for (int i = 0; i < table.length; i++) {
                indices[i] = i;
            }
            return indices;
        }

        static String[] formatValues(Integer[] table) {
            String[] values = new String[table.length];
            for (int i = 0; i < table.length; i++) {
                values[i] = table[i] == null ? "" : String.valueOf(table[i]);
            }
            return values;
        }
    }

    private static String joinRightAlignedInts(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(String.format("%2d", arr[i]));
        }
        return sb.toString();
    }

    private static String joinRightAlignedStrings(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            if (arr[i].isEmpty()) {
                sb.append("  ");
            } else {
                sb.append(String.format("%2s", arr[i]));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] keys = {10, 19, 31, 22, 14, 16};
        ProbingHashTable hashTable = new ProbingHashTable(8);

        System.out.println("Linear probing snapshots:");
        List<Integer[]> linearSnapshots = hashTable.linearProbeSequence(keys);
        for (int step = 0; step < linearSnapshots.size(); step++) {
            Integer[] table = linearSnapshots.get(step);
            int[] indices = ProbingHashTable.formatIndices(table);
            String[] values = ProbingHashTable.formatValues(table);

            System.out.println("After inserting " + keys[step] + ":");
            System.out.println("Index: " + joinRightAlignedInts(indices));
            System.out.println("Table: " + joinRightAlignedStrings(values));
            System.out.println();
        }

        System.out.println("Quadratic probing snapshots:");
        List<Integer[]> quadraticSnapshots = hashTable.quadraticProbeSequence(keys);
        for (int step = 0; step < quadraticSnapshots.size(); step++) {
            Integer[] table = quadraticSnapshots.get(step);
            int[] indices = ProbingHashTable.formatIndices(table);
            String[] values = ProbingHashTable.formatValues(table);

            System.out.println("After inserting " + keys[step] + ":");
            System.out.println("Index: " + joinRightAlignedInts(indices));
            System.out.println("Table: " + joinRightAlignedStrings(values));
            System.out.println();
        }
    }
}
