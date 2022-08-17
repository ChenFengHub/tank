package com.cf.tank.strategy.comparator;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-17 07:07:51
 */
public class Sorter<T> {
    public void sort(T[] arr, Comparator<T> comparator) {
        // 从小到大排序
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compareTo(arr[j], arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }
    private void swap(T[]arr, int pos, int minPos) {
        T temp = arr[pos];
        arr[pos] = arr[minPos];
        arr[minPos] = temp;
    }
}
