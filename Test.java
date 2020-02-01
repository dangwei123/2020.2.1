class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int min=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            res=Math.max(res,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return res;
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            int tmp=dp0;
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,tmp-prices[i]);
        }
        return dp0;
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            if(i==0){
                dp[0][0]=0;
                dp[0][1]=-prices[0];
            }else{
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][0];
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int[][][] dp=new int[prices.length][3][2];
        for(int i=0;i<prices.length;i++){
            for(int j=2;j>0;j--){
                if(i==0){
                    dp[0][j][0]=0;
                    dp[0][j][1]=-prices[0];
                }else{
                    dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }
            }
        }
        return dp[prices.length-1][2][0];
    }
}

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
        if(k>prices.length/2){
            return maxProfit(prices);
        }
        int[][][] dp=new int[prices.length][k+1][2];
        for(int i=0;i<prices.length;i++){
            for(int j=k;j>0;j--){
                if(i==0){
                    dp[0][j][0]=0;
                    dp[0][j][1]=-prices[0];
                }else{
                    dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }
            }
        }
        return dp[prices.length-1][k][0];
    }
    private int maxProfit(int[] prices){
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            int tmp=dp0;
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,tmp-prices[i]);
        }
        return dp0;
    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            int tmp=dp0;
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,tmp-prices[i]-fee);
        }
        return dp0;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int dp0=0;
        int dp1=Integer.MIN_VALUE;
        int pre=0;
        for(int i=0;i<prices.length;i++){
            int tmp=dp0;
            dp0=Math.max(dp0,dp1+prices[i]);
            dp1=Math.max(dp1,pre-prices[i]);
            pre=tmp;
        }
        return dp0;
    }
}

