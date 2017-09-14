package src.arnab.dp;

class Cut {

	int cuts[][];
	public Cut(int n) {
		cuts = new int[n][n];
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < n; j++) 
				cuts[i][j] = 0;
	}
	
	public int minimumSquare(int m, int n) {
	    int vertical_min = 999999;
	    int horizontal_min = 99999;
	     
	    if (m == n)
	        return 1;
	     
	    if (cuts[m][n] != 0)
	            return cuts[m][n];
	     
	    for(int i = 1; i < m; i++)
	    {
	        horizontal_min = Math.min(minimumSquare(i, n) + 
	                minimumSquare(m-i, n), horizontal_min); 
	    }
	     
	    for(int j = 1; j < n; j++)
	    {
	        vertical_min = Math.min(minimumSquare(m, j) + 
	                minimumSquare(m, n-j), vertical_min);
	    }
	    cuts[m][n] = Math.min(vertical_min, horizontal_min); 
	    return cuts[m][n];
	}
}

public class PaperCut {

	public static void main(String args[]) {
		Cut cut  = new Cut(100);
		System.out.println(cut.minimumSquare(3, 5));
	}
	
}
