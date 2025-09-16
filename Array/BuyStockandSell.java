package Array;

// here we need to check if we are buying a stock suppose in 1 rupee then in which price we can sell it
// to maximize the profit
// for that we need to check in which day we have the minimum buying price and
// after that which day we have the highest selling price
// to get the maximum profit we are checking if the stock price is greater than my buying value
// if prices[i] is greater than my buying value then only we are calculating the maximum profit
// by calculating the difference between prices[i] with the minimum buying price
// to calculate the minimum buying price
// we are checking the min value with our initial bestbuy price and each prices[i]

public class BuyStockandSell {
    public static int maxProfit(int[] prices) {
        int maxProfit=0,bestBuy=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            //calculating max profit by checking the difference between
            //buying price and the selling price of that day
            if(prices[i]>bestBuy)
                maxProfit=Math.max(maxProfit,prices[i]-bestBuy);

            //minimum value of the array
            bestBuy=Math.min(bestBuy,prices[i]);
        }
        return maxProfit;
    }



    public static void main(String args[])
    {
        int[] stockPrice=new int[]{7,9,5,3,6,4};
        int maxProfit=maxProfit(stockPrice);
        System.out.println("Maximum Profit "+maxProfit);
    }
}
