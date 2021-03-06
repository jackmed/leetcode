public class MaxProfit2 {
    //方法二：贪心算法，如果第二天比今天高，就今天买第二天卖，时间复杂度为O(N)
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;

        int res = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];

        return res;
    }
}
