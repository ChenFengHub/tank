package com.cf.tank.strategy.comparable;


/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-17 21:21:19
 */
public class Sorter{
    public void sort(Comparable[] arr) {
        // 从小到大排序
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }
    private void swap(Comparable[]arr, int pos, int minPos) {
        Comparable temp = arr[pos];
        arr[pos] = arr[minPos];
        arr[minPos] = temp;
    }
}
