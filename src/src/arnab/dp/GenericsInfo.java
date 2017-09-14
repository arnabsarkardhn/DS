package src.arnab.dp;

import java.math.BigInteger;

public class GenericsInfo {

	
	public static void main(String args[]) {
		BigInteger account = new BigInteger("2239240806605492059");
		BigInteger mod = account.mod(new BigInteger("100"));
		System.out.println(mod);
				
		boolean result = mod.compareTo(new BigInteger("99")) < 0;
		
		System.out.println(result);
		
	}
	
}
