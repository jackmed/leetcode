public class MaxProfit3 {
    //方法三：峰谷法，相较于方法二，逻辑差不多，但是减少了交易次数
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;

        int i = 0;
        int res = 0;
        int valley = prices[0];
        int peak;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            res += peak - valley;
        }
        return res;
    }
}
