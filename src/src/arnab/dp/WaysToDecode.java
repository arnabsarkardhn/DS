package src.arnab.dp;

class Decode {
	
	public int decode(String digit) {
		int dp[] = new int[digit.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= digit.length(); i++)
	    {
	        dp[i] = 0;
	        if (digit.charAt(i-1) > '0')
	            dp[i] = dp[i-1];
	 
	        if (digit.charAt(i-2) == '1' || (digit.charAt(i-2) == '2' && digit.charAt(i-1) < '7') )
	            dp[i] += dp[i-2];
	    }
	    int x = dp[digit.length()];
	    return x;
	}
	
}

public class WaysToDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Decode().decode("12"));

	}

}
