package indi.com.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] arr1 = {87, 96, 45, 78, 32, 1, 200, 133, 17, 65, 53, 9, 122};
        int[] arr2 = {87, 96, 45, 78, 32, 1, 200, 133, 17, 65, 53, 9, 122};
        QuickSort.sort1(arr1, 0, arr1.length - 1);
        QuickSort.sort2(arr2, 0, arr2.length - 1);
        System.out.println("QuickSort.sort1:" + Arrays.toString(arr1));
        System.out.println("QuickSort.sort2:" + Arrays.toString(arr2));
    }

    static class QuickSort {

        /**
         * 从小到大
         *
         * @param arr
         * @param left
         * @param right
         */
        public static void sort1(int[] arr, Integer left, Integer right) {
            if (left < right) {
                int i = left, j = right;
                int key = arr[left];
                while (i < j) {
                    //从右向左找第一个小于key的数
                    while (i < j && arr[j] > key) {
                        j--;
                    }
                    if (i < j) {
                        arr[i] = arr[j];
                        i++;
                    }
                    // 从左向右找第一个大于key的数
                    while (i < j && arr[i] < key) {
                        i++;
                    }
                    if (i < j) {
                        arr[j] = arr[i];
                        j--;
                    }
                    arr[i] = key;
                }
                sort1(arr, left, i - 1);
                sort1(arr, i + 1, right);
            }
        }

        /**
         * 方法2：
         *
         * @param arr
         * @param left
         * @param right
         * @return
         */
        public static int[] sort2(int[] arr, int left, int right) {
            if (left < right) {
                int partitionIndex = partition(arr, left, right);
                sort2(arr, left, partitionIndex - 1);
                sort2(arr, partitionIndex + 1, right);
            }
            return arr;
        }

        private static int partition(int[] arr, int left, int right) {
            // 设定基准值（pivot）
            int pivot = left;
            int index = pivot + 1;
            for (int i = index; i <= right; i++) {
                if (arr[i] < arr[pivot]) {
                    swap(arr, i, index);
                    index++;
                }
            }
            swap(arr, pivot, index - 1);
            return index - 1;
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}
