package dev.romashov.gameOfLife;

/**
 * Literally only here to check off all project requirements.
 * None of these are used in the processing of Conway's
 * Game of Life.
 */
public class MiscAlgorithms {
    public static int max(int[] arr) {
        int max = arr[0];
        for (int n : arr) {
            if (n > max) max = n;
        }
        return max;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int n : arr) {
            if (n < min) min = n;
        }
        return min;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += n;
        return sum;
    }

    public static double mean(int[] arr) {
        return (double) sum(arr) / arr.length;
    }

    public static int mode(int[] arr) {
        int mode = arr[0];
        int modeCount = 1;
        for (int i : arr) {
            int count = frequency(arr, i);
            if (count > modeCount) {
                mode = i;
                modeCount = count;
            }
        }
        return mode;
    }

    public static boolean contains(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) return true;
        }
        return false;
    }

    public static int frequency(int[] arr, int num) {
        int count = 0;
        for (int i : arr) {
            if (i == num) count++;
        }
        return count;
    }

    public static boolean anyDivisible(int[] arr, int num) {
        for (int i : arr) {
            if (i % num == 0) return true;
        }
        return false;
    }

    public static boolean allDivisible(int[] arr, int num) {
        for (int i : arr) {
            if (i % num != 0) return false;
        }
        return true;
    }

    public static boolean hasDuplicates(int[] arr) {
        return (frequency(arr, mode(arr)) > 1);
    }

    public static int[] shiftRight(int[] arr) {
        int[] newArr = new int[arr.length];
        newArr[0] = arr[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    public static int[] shiftLeft(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        newArr[arr.length - 1] = arr[0];
        return newArr;
    }

    public static int[] reverse(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr.length - 1 - i] = arr[i];
        }
        return newArr;
    }

    public static void printConsecutivePairs(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.println("[" + arr[i - 1] + ", " + arr[i] + "]");
        }
    }

    public static int digitAtIndex(int n, int i) {
        return (n / (int) Math.pow(10, i)) % 10;
    }

    public static boolean isDivisible(int a, int b) {
        return a % b == 0 || b % a == 0;
    }
}
