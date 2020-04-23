public class POW4 {
    //方法四：快速幂算法的循环迭代版本
    public double myPow(double x, int n) {
        if (n == 0 || x == 1)
            return 1;

        long N = n;
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }
        double res = 1;
        while (N > 0) {
            if ((N & 1) > 0) {
                res *= x;
            }
            x *= x;
            N = N >> 1;
        }
        return res;
    }
}
