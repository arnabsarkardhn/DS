package src.arnab.dp;

class LongestSubSequence {
	
	public int lis(int array[]) {
		int result = 0, j = 0, i = 0;
		int lis[] = new int[array.length];
		for(j = 0; j < array.length; j++) 
			lis[j] = 1;
		
		for(i = 1; i < array.length; i++) {
			for(j = 0; j < i; j++) {
				if(array[i] > array[j] && lis[i] < lis[j] + 1) {
					lis[i] = 1 + lis[j];
				}
			}
		}
		
		for(i = 0; i < lis.length; i++) {
			if(result < lis[i])
				result = lis[i];
		}
		return result;
	}
}


public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = //{ 10, 22, 9, 33, 21, 50, 41, 60 };
				{1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2};
		System.out.println("LIS :" +new LongestSubSequence().lis(array));
	}

}
