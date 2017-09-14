package src.arnab.dp;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int fibonacci[] = new int [10];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		for(int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		
		for(int i = 0; i < fibonacci.length; i++) {
			System.out.println(fibonacci[i]);
		}
		
	}

}
