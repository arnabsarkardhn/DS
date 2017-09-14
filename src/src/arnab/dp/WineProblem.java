package src.arnab.dp;

class DP1 {
	int p[] = null;
	int cache[][];

	public DP1(int N) {
		p = new int[N];
		cache = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				cache[i][j] = -1;
	}
	
	/**
    * Description: Backtracking function to find maximum profit.
    * @param year : starts from 1 to N-1
    * @param be : beginning of price array
    * @param en : end of price array
    * @return : maximized profit
    */
    public int maxProfit(int year, int be, int en){
        if(be>en)
            return 0;
        return Math.max((this.maxProfit(year + 1, be + 1, en) + year * this.p[be]),
        		(this.maxProfit(year + 1, be, en - 1) + year * p[en]));
    }
    
    /**
	 * 1, 4, 2, 3
	 * 2, 8, 4, 6
	 * 3,12, 6, 9
	 * 4,16, 8,12
	 */
    public int maxDPProfit(int be, int en){
        if(be > en)
            return 0;
        if(cache[be][en] != -1)
            return cache[be][en];
        int year = this.p.length - (en-be+1) + 1;
        cache[be][en] = Math.max((this.maxDPProfit(be + 1, en) + year * p[be]),
        		(this.maxDPProfit(be, en - 1) + year * p[en]));
        return cache[be][en];
    }
}

public class WineProblem {

	public static void main(String[] args) {

		
		 DP1 dp = new DP1(4);
	     int p[] = new int[]{1,4,2,3};
	     dp.p = p;
	     int profit = dp.maxProfit(1, 0, 3);
	     System.out.println("Profit: " + profit);
	     
	     int dpprofit = dp.maxDPProfit(0, 3);
	        System.out.println("DP Profit: " + dpprofit);
	}

}
