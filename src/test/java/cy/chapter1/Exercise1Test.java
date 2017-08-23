package cy.chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static edu.princeton.cs.algs4.StdRandom.random;
import static org.junit.Assert.*;

public class Exercise1Test {

    @Test
    public void test1() throws Exception {
        System.out.println((0 + 15) / 2);
        System.out.println(2.0e-6);
        System.out.println(2.0e-6 * 1_000_000000.1);
        System.out.println(true && false || true && true);

        //java貌似修正了float和double的精度问题
        System.out.println(1.e-12 == Math.pow(10, -12));
        System.out.println(1e-12 == Math.pow(10, -12));
        System.out.println(1e-5 == Math.pow(10, -5));
        System.out.println(1.e-12);
        System.out.println(1e-12);
        System.out.println(1e-5);
        System.out.println(Math.pow(10, -5));
        System.out.println((float) Math.pow(10, -5));

        System.out.println(1.0 == 1);
        System.out.println((float) 1.00 - 0.050);

        BigDecimal bigDecimal = new BigDecimal(1.01d);
        System.out.println(bigDecimal.doubleValue() == 1.01f);//此处又有精度损失
        System.out.println(bigDecimal.doubleValue() - 1.01f);
        System.out.println(bigDecimal.doubleValue() - 1.01d);
        System.out.println(new BigDecimal(0.00001).doubleValue() - Math.pow(10, -5));

    }

    @Test
    public void exercise2() throws Exception {
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + "3");
    }

    @Test
    public void exercise3() throws Exception {
        int[] args = {1, 1, 1};
        check3Params(args);
        check3Params(new int[]{1, 2, 1});
    }

    private void check3Params(int[] args) {
        if (args.length != 3) {
            return;
        }
        if (args[0] == args[1] && args[0] == args[2] && args[1] == args[2]) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
    }

    @Test
    public void exercise5() throws Exception {
        double x = 0;
        isBetween0And1(x);
        isBetween0And1(1);
        isBetween0And1(0.5);
    }

    private void isBetween0And1(double x) {
        if (x > 0 && x < 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    @Test
    public void exercise6() throws Exception {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    @Test
    public void exercise7() throws Exception {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            System.out.println(t);
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);
    }

    @Test
    public void ex72() throws Exception {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);
    }

    @Test
    public void ex73() throws Exception {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        System.out.println(sum);
    }

    @Test
    public void ex8() throws Exception {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    @Test
    public void ex9() throws Exception {
        System.out.println(Integer.toBinaryString(100));

        String s = "";
        int i = 100;
        while (i > 0) {
            s = i % 2 + s;
            i = i / 2;
        }
        System.out.println(s);


//        for (int n = 100; n > 0; n /= 2) {
//            s = n % 2 + s;
//        }
//        System.out.println(s);

        System.out.println(100 >> 1);
    }

    @Test
    public void ex11() throws Exception {
        boolean[] booleans = {true, false, true, false};
        boolean[][] verix = {booleans, booleans, booleans, booleans};

        boolean[][] vals = new boolean[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                vals[i][j] = false;

        printEx11(verix);
        printEx11(vals);
    }

    public void printEx11(boolean[][] vals) {
        for (int i = 0; i < vals.length; i++) {
            System.out.println("");
            for (int j = 0; j < vals[i].length; j++)
                if (vals[i][j])
                    System.out.print(i + "-" + j + ":" + "*");
                else
                    System.out.print(i + "-" + j + ":" + " ");
        }
    }

    @Test
    public void ex12() throws Exception {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }

    @Test
    public void ex13() throws Exception {
        int[][] v = new int[][]{{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {4, 4, 4, 4, 4}};
        int[][] newV = reverseV(v);
        for (int i = 0; i < newV.length; i++) {
            System.out.println();
            for (int j = 0; j < newV[i].length; j++)
                System.out.print(newV[i][j]);
        }
    }

    private int[][] reverseV(int[][] vals) {
        if (vals.length <= 0)
            return null;
        if (vals[0].length <= 0) {
            return null;
        }

        int[][] newVals = new int[vals[0].length][vals.length];
        for (int i = 0; i < vals.length; i++)
            for (int j = 0; j < vals[i].length; j++)
                newVals[j][i] = vals[i][j];

        return newVals;
    }


    /**
     * log的数学计算推到公式是什么
     *
     * @throws Exception
     */
    @Test
    public void ex14() throws Exception {

    }

    @Test
    public void ex15() throws Exception {


    }

    private static int[] histogram(int[] a, int m) {
        int[] vals = new int[m];
        for (int i = 0; i < m; i++) {
            int num = 0;
            for (int j = 0; j < a.length; j++) {
                if (i == a[j]) {
                    num++;
                }
            }
            vals[i] = num;
        }
        return vals;
    }

    @Test
    public void ex16() throws Exception {
        System.out.println(exR1(6));
    }

    private static String exR1(int n) {
        if (n <= 0)
            return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    @Test
    public void ex18() throws Exception {
        System.out.println(1 / 2);
        System.out.println(mystery(2, 25));//62
        System.out.println(mystery(3, 11));

        System.out.println(mysteryMulti(2, 25));
        System.out.println(mysteryMulti(3, 11));

    }

    public static int mystery(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    /**
     * 千万不要敲错代码
     *
     * @param a
     * @param b
     * @return
     */
    public static int mysteryMulti(int a, int b) {
        if (b == 0)
            return 1;
        if (b % 2 == 0)
            return mysteryMulti(a * a, b / 2);
        return mysteryMulti(a * a, b / 2) * a;
    }

    @Test
    public void ex19() throws Exception {
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + fib(N));
    }

    private static long[] results = new long[10000];

    private static long fib(int n) {
        if (n > 1 && results[n] > 0) {
            return results[n];
        }

        if (n == 0) {
            results[0] = 0;
            return 0;
        }
        if (n == 1) {
            results[1] = 1;
            return 1;
        }
        long res = fib(n - 1) + fib(n - 2);
        results[n] = res;
        return res;
    }

    public static class Fibonacci {
        public static long F(int N) {
            if (N == 0) return 0;
            if (N == 1) return 1;
            return F(N - 1) + F(N - 2);
        }

        public static void main(String[] args) {
            long l = System.currentTimeMillis();
            for (int N = 0; N < 100; N++)
                StdOut.println(N + " " + F(N));
            System.out.println((System.currentTimeMillis() - l) / 1000);
        }
    }

    @Test
    public void ex20() throws Exception {
        System.out.println(Math.log(factorial(10)));
    }

    public static long factorial(int n) {
        if (n == 1) return 1;
        return factorial(n - 1) * n;
    }

    @Test
    public void ex21() throws Exception {
        String[] ins = In.readStrings("data/a.txt");
        for (String in : ins) {
            String[] split = in.split(" ");
            String name = split[0];
            Integer i1 = Integer.valueOf(split[1]);
            Integer i2 = Integer.valueOf(split[2]);

            StdOut.println(name + " " + i1 + " " + i2 + " " + String.format("%.3f", (double) i1 / i2));
        }
    }

    @Test
    public void ex22() throws Exception {
        int[] a = {1, 5, 6, 9, 11, 16, 20};
        System.out.println(rand(10, a, 0, a.length - 1));
    }

    public static int deep = 0;
    public static String s = "";

    public static long rand(int key, int[] a, int lo, int hi) {
        System.out.println(s + "lo-" + lo + ", hi-" + hi);
        deep++;
        s += "    ";

        if (lo > hi)
            return -1;

        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rand(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rand(key, a, mid + 1, hi);
        } else
            return mid;
    }

    @Test
    public void ex23() throws Exception {
        printRank("+", new int[]{1, 24, 6, 3, 7, 12, 54, 23}, 5);
        printRank("-", new int[]{1, 24, 6, 3, 7, 12, 54, 23}, 5);
    }

    private void printRank(String tag, int[] whitelist, int key) {
        Arrays.sort(whitelist);
//        while (!StdIn.isEmpty()) {
//            int key = StdIn.readInt();
        if (tag.equals("+")) {
            if (BinarySearch.rank(key, whitelist) < 0) {
                StdOut.print(key);
            }
        } else if (tag.equals("-")) {
            if (BinarySearch.rank(key, whitelist) >= 0) {
                StdOut.print(key);
            }
        }
//        }
    }

    @Test
    public void ex24() throws Exception {
        System.out.println(euclid(96, 56));
        System.out.println(euclid(1_111_111, 1_234_567));
    }

    /**
     * 最小公约数
     * a > b,
     * b 与a mod b 等价于 a与 b的最大公约数
     *
     * @param big
     * @param small
     * @return
     */
    public static long euclid(long big, long small) {
        if (big <= 0 || small <= 0) {
            return -1;
        }

        StdOut.println(big + ", " + small);
        if (small > big) {//两数交换
            long temp = small;
            small = big;
            big = temp;
        }

        if (big % small == 0)//能整除
            return small;
        else
            return euclid(small, big % small);//达到将维度的效果
    }

    @Test
    public void ex35() throws Exception {
        int n = 1000;

        while (n > 0) {
            double[] exact = getExact();
            double[] experim = getExperim(n);

            boolean result = true;
            for (int i = 2; i <= 2 * SIDES && result; i++) {
                StdOut.printf("%7.3f -%7.3f:%s ", exact[i], experim[i], Math.abs(exact[i] - experim[i]) < 0.03);
                result = Math.abs(exact[i] - experim[i]) < 0.03;
            }

            StdOut.println(n);
            n--;

            if (!result) break;
        }
    }


    private static double[] getExperim(int n) {
        double[] dist = new double[2 * SIDES + 1];

        for (int i = 0; i < n; i++)
            dist[throwDice()]++;

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= n;

        return dist;
    }

    private static int throwDice() {
        return StdRandom.uniform(1, SIDES + 1) + StdRandom.uniform(1, SIDES + 1);
    }

    public static final int SIDES = 6;

    private double[] getExact() {
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;

        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= 36.0;
        }

        return dist;
    }

    @Test
    public void ex36() throws Exception {
        /*double[] d1 = {3, 256, 7, 14, 64, 21, 67};
        double[] d2 = {213, 564, 21, 5, 24, 6, 3, 131, 20};

        Arrays.stream(d1).forEach(t -> System.out.print(t + ", "));
        System.out.println();
        Arrays.stream(d2).forEach(t -> System.out.print(t + ", "));
        System.out.println();

        shuffle(d1);
        shuffle(d2);

        Arrays.stream(d1).forEach(t -> System.out.print(t + ", "));
        System.out.println();
        Arrays.stream(d2).forEach(t -> System.out.print(t + ", "));
        System.out.println();*/

//        for (int i = 0; i < 10; i++)
//            System.out.println(StdRandom.bernoulli(0.5));
        shuffleMatrix(10, 5);
    }

    public static void shuffleMatrix(int m, int n) {
        double[][] statArr = initArr(m, m);//初始化

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int r = StdRandom.uniform(m - 1);
                statArr[j][r]++;
            }
        }

        //打印结果
        for (int i = 0; i < statArr.length; i++) {
            StdOut.println();
            for (int j = 0; j < statArr[i].length; j++)
                StdOut.print(statArr[i][j] + " ");
        }
    }

    public static double[][] initArr(int m, int n) {
        double[][] statArr = new double[m][m];
        for (int i = 0; i < statArr.length; i++) {
            for (int j = 0; j < statArr[i].length; j++)
                statArr[i][j] = 0;
        }
        return statArr;
    }

    public static void shuffle(double[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + StdRandom.uniform(n - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    @Test
    public void ex37() throws Exception {
        int m = 10, n = 5;
        double[][] statArr = initArr(m, m);//初始化

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int r = StdRandom.uniform(0, m - 1);
                statArr[j][r]++;
            }
        }

        //打印结果
        for (int i = 0; i < statArr.length; i++) {
            StdOut.println();
            for (int j = 0; j < statArr[i].length; j++)
                StdOut.print(statArr[i][j] + " ");
        }
    }

    public static void shuffleBad(double[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + StdRandom.uniform(0, n - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    @Test
    public void ex38() throws Exception {
        int[] vals = In.readInts("data/largeT.txt");
        int[] arr = In.readInts("data/largeW.txt");

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            if (rankForce(arr[i], vals) > 0)
                StdOut.print(arr[i] + ": true ");
            else
                StdOut.print(arr[i] + ": false ");
        }
        System.out.println("force finish: " + (System.currentTimeMillis() - start1));

        Arrays.sort(vals);
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            if (rank(arr[i], vals) > 0)
                StdOut.print(arr[i] + ": true ");
            else
                StdOut.print(arr[i] + ": false ");
        }
        System.out.println("binary finish: " + (System.currentTimeMillis() - start));
    }

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

    public static int rankForce(int key, int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key)
                return i;
        return -1;
    }

    @Test
    public void ex39() throws Exception {




    }
}


