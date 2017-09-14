package src.arnab.dp;

class Palindrome {
	
	
	public int longestPalindrome(String palindrome) {
		int length = 0;
		int size = palindrome.length();
		boolean result[][] = new boolean[size][size];
		for(int i = 0; i < size; i++) {
			result[i][i] = true;
		}
		int i = 0, j = 0, initial = 0, diff = 1, end = 0, curr_len = 0, max_len = 0;
		for(i = 0; i < palindrome.length() - 1; i++) {
			initial = 0; end = 0;
			for(j = 0; end < palindrome.length() - 1; j++) {
				initial = j;
				end = diff + j;
				if(end == palindrome.length())
					break;
				if(palindrome.charAt(initial) == palindrome.charAt(end)) {
					System.out.println(palindrome.substring(initial, end + 1));
					result[initial][end] = true;
					curr_len = end - initial;
					if(curr_len > max_len)
						max_len = curr_len;
				}
			}
			diff++;
		}
		return max_len + 1;
	}
}

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Palindrome().longestPalindrome("forgeeksskeegfor"));
	}

}
