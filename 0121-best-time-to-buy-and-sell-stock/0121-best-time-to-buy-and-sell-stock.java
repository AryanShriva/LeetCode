// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int maxProfit = 0;

//         for(int i = 0;i<n;i++){
//             for(int j = i + 1; j < n;j++){
//                 int profit = prices[j] - prices[i];
//                 if(profit > maxProfit){
//                     maxProfit = profit;
//                 }
//             }
//         }
//         return maxProfit;
//     }
// }

//optimized

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            // Update the minimum price so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit if sold today and update maxProfit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
}