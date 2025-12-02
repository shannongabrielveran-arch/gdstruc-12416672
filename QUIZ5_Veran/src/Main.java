public class Main {
    public static void main(String[] args) {

        int numbers[] = {45, 67, 44, 24, 15, 88, -10};

        System.out.println(veranMethodSearch(numbers, 67));   // should find it
        System.out.println(veranMethodSearch(numbers, 454));  // should return -1
    }

    // "The Veran Method" – Even/Odd priority search
    // 1. Search all odd indices first (1, 3, 5, ...)
    // 2. If not found, search all even indices (0, 2, 4, ...)
    // 3. If still not found, return -1
    //
    // Works on UNSORTED arrays.
    public static int veranMethodSearch(int[] input, int value) {

        // Step 1: search odd indices
        for (int i = 1; i < input.length; i += 2) {
            if (input[i] == value) {
                return i;
            }
        }

        // Step 2: search even indices
        for (int i = 0; i < input.length; i += 2) {
            if (input[i] == value) {
                return i;
            }
        }

        // Step 3: value not found
        return -1;
    }

    // (You can keep these as reference if you want)
    public static int linearSearch(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (input[middle] == value) {
                return middle;
            } else if (value < input[middle]) { // value might be at left half
                end = middle - 1;
            } else { // value might be at right half
                start = middle + 1;
            }
        }

        return -1;
    }
}
