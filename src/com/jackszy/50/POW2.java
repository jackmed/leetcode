public class POW2 {
    //方法二：暴力法，把x乘n次，时间复杂度O(N)，理论上可以，但是在leetcode上对于n特别大的情况运行会超出时间限制
    //注意边界，注意n可以为负数
    public double myPow(double x, int n) {
        if (n ==0 || x == 1)
            return 1;

        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }
}
