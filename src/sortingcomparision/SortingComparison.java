package sortingcomparision;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    public static void main(String[] args) {
        int arraySize = 10000; // Size of the array to be sorted
        int[] array = generateRandomArray(arraySize);

        System.out.println("Array Size: " + arraySize);

        // Bubble Sort
        int[] bubbleSortArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        bubbleSort(bubbleSortArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " ms");

        // Selection Sort
        int[] selectionSortArray = Arrays.copyOf(array, array.length);
        startTime = System.currentTimeMillis();
        selectionSort(selectionSortArray);
        endTime = System.currentTimeMillis();
        System.out.println("Selection Sort Time: " + (endTime - startTime) + " ms");

        // Insertion Sort
        int[] insertionSortArray = Arrays.copyOf(array, array.length);
        startTime = System.currentTimeMillis();
        insertionSort(insertionSortArray);
        endTime = System.currentTimeMillis();
        System.out.println("Insertion Sort Time: " + (endTime - startTime) + " ms");

        // Merge Sort
        int[] mergeSortArray = Arrays.copyOf(array, array.length);
        startTime = System.currentTimeMillis();
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Merge Sort Time: " + (endTime - startTime) + " ms");

        // Quick Sort
        int[] quickSortArray = Arrays.copyOf(array, array.length);
        startTime = System.currentTimeMillis();
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Quick Sort Time: " + (endTime - startTime) + " ms");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100000); // Random integers up to 100,000
        }
        return array;
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    private static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
