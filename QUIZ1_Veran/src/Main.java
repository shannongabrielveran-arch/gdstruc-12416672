void main() {
    int[] numbers = new int[10];

    numbers[0] = 10;
    numbers[1] = 90;
    numbers[2] = 50;
    numbers[3] = 30;
    numbers[4] = 60;
    numbers[5] = 80;
    numbers[6] = 40;
    numbers[7] = 70;
    numbers[8] = 20;
    numbers[9] = 100;

    System.out.println("Before bubble sort;");
    printArrayElement(numbers);

    bubbleSort(numbers);

    System.out.println("\n\nAfter bubble sort;");
    printArrayElement(numbers);
}

private static void bubbleSort(int[]arr)
{

    for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--);
    {
        int largestIndex = 0;

            for (int i = 0; i < i; i++)
            {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }


private static void printArrayElement(int[] arr)
    {
        for (int j : arr) {
            System.out.println(j);
        }
}