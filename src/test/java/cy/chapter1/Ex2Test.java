package cy.chapter1;

import edu.princeton.cs.algs4.*;
import org.junit.Test;

public class Ex2Test {

    @Test
    public void ex1() throws Exception {
        Interval1D xinterval = new Interval1D(0.0, 0.5);
        Interval1D yinterval = new Interval1D(0.5, 1);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        int n = 1000;
        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform(0.0, 0.5);
            double y = StdRandom.uniform(0.5, 1);

            Point2D p = new Point2D(x, y);
            p.draw();

            double[] point = {x, y};
            arr[i] = point;
        }

        double val = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double instance = Math.sqrt(Math.pow(arr[j][0] - arr[i][0], 2) + Math.pow(arr[j][1] - arr[i][1], 2));
                if (val == 0)
                    val = instance;
                if (instance < val) {
                    val = Math.sqrt(Math.pow(arr[j][0] - arr[i][0], 2) + Math.pow(arr[j][1] - arr[i][1], 2));
                }
            }
        }
        System.out.println(val);
    }

    @Test
    public void ex2() throws Exception {
        double x = 0, y = 0;
        double[] vals = StdIn.readAllDoubles();
        Interval1D xinterval = new Interval1D(0.0, 0.5);
        if (xinterval.intersects(new Interval1D(x, y))) {
            StdOut.println(x + ' ' + y);
        }
    }

    @Test
    public void ex3() throws Exception {
        int N = 100;
        double min = .1;
        double max = .9;

        int contains = 0;
        int intersect = 0;
        Interval2D[] val = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            double x1 = StdRandom.uniform(min, max);
            double y1 = StdRandom.uniform(min, max);
            double x2 = StdRandom.uniform(min, max);
            double y2 = StdRandom.uniform(min, max);

            Interval1D interval1 = new Interval1D(x1 <= y1 ? x1 : y1, x1 >= y1 ? x1 : y1);
            Interval1D interval2 = new Interval1D(x2 <= y2 ? x2 : y2, x2 >= y2 ? x2 : y2);
            if (interval1.intersects(interval2)) {
               /* System.out.print(interval1.min() + interval1.max());
                System.out.println(interval2.min() + interval2.max());*/
                intersect++;
            }
            if (interval1.contains(x2)) {
                contains++;
            }

//            Interval2D interval2D = new Interval2D(interval1, interval2);
//            val[i] = interval2D;

            StdDraw.line(x1, y1, x2, y2);
        }
        System.out.println(intersect + '-' + contains);
        /*int nums = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (val[i].intersects(val[j])) {
                    nums++;
                }
            }
        }

        System.out.println(nums);*/
        System.out.println();
    }

    @Test
    public void ex6() throws Exception {
        System.out.println(isCircular("abc", "cba"));
    }

    public boolean isCircular(String source, String target){
        String s = "";
        char[] chars = source.toCharArray();
        for (int i = chars.length; i > 0; i--){
            s += chars[i - 1];
        }
        return s.equals(target);
    }

    @Test
    public void ex9() throws Exception {

    }

    @Test
    public void ex10() throws Exception {

    }

    @Test
    public void ex15() throws Exception {

    }

    public static int[] readInts(String name) {
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;

    }

    public static void main(String[] args) {

    }

    @Test
    public void isPalindrome() throws Exception {
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abcbab"));
    }

    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != s.charAt(N - 1 - i))
                return false;
        }
        return true;
    }

}
