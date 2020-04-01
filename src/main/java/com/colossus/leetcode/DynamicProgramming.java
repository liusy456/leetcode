package com.colossus.leetcode;

/**
 * 动态规划
 */
public class DynamicProgramming {

    /**
     * 上下左右
     */
    int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};

    /**
     * 不同路径 lc-62
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        /**
         * dp[i][j]  表示到i,j的道路数
         */
        int[][] dp = new int[m][n];
        for (int i = 0;i<m;i++){
            dp[i][0] = 1;
        }
        for (int i = 0;i<n;i++){
            dp[0][i] = 1;
        }
        for (int i = 1 ;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
       return dp[m-1][n-1];
    }

    /**
     * 最小路劲和 lc-64
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m==0){
            return 0;
        }
        int n = grid[0].length;
        if(n== 0){
            return 0;
        }
        //dp[i][j] 为到达ij的最小路劲
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1;i<m;i++){
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        for (int i = 1;i<n;i++){
            dp[0][i] = grid[0][i]+dp[0][i-1];
        }

        for (int i =1 ;i<m;i++){
            for (int j =1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(dp.minPathSum(grid));
    }
}
