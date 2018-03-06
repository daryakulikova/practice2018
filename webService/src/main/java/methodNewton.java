public class methodNewton {
    public static double f(double[] x, double[] fx, double myx) {
        double ans = 0;
        for (int i = 0; i < x.length; i++) {
            int k[] = new int[i+1];
            double myf = 1;
            for (int j = 0; j < i+1; j++) {
                k[j] = j;
            }
            for (int j = 0; j < i; j++) {
                myf *= (myx - x[j]);
            }
            ans += myf * f1(fx, k, x);
        }
        return ans;
    }

    public static double f1(double[] fx, int[] k, double[] x) {
        if (k.length == 1) {
            return fx[k[0]];
        }
        if (k.length == 2) {
            return (fx[k[0]] - fx[k[1]]) / (x[k[0]] - x[k[1]]);
        }

        int[] k1 = new int[k.length - 1];
        int[] k2 = new int[k.length - 1];
        for (int i = 0; i < k.length - 1; i++) {
            k1[i] = k[i];
            k2[i] = k[i + 1];
        }
        return (f1(fx, k1, x) - f1(fx, k2, x)) / (x[k[0]] - x[k[k.length - 1]]);
    }
}
