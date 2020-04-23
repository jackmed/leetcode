public class POW3 {
    //方法三：递归分治实现，时间复杂度O(logN)，即官方题解的的快速幂算法
    public double myPow(double x, int n) {
        return powLong(x, (long)n);
    }

    //因为n取绝对值的时候有可能超出int范围，所以转为long来运算
    private double powLong(double x, long n) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 1 / powLong(x, -n);

        if (n % 2 == 0)
            return powLong(x * x, n / 2);
        return x * powLong(x * x, n / 2);
    }
}
