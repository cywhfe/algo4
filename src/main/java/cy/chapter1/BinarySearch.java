package cy.chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找返回索引位置
     *
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
//            if (rank(key, whitelist) < 0) {
            if (rankMe(key, whitelist) < 0) {
                StdOut.print(key);
            }
        }
    }

    /**
     * 数组a是有序的
     * lo是起点，hi是终点
     * mid是起点和终点之间的中值
     * 用key与a[mid]比较，当小于中间值，hi下降；当大于中间值，lo上升，否则等于mid；
     * 异常情况用负数表示
     *
     * @param key
     * @param a
     * @return
     */
    public static int rankMe(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
