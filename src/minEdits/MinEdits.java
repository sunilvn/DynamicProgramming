package minEdits;

import java.util.Arrays;

public class MinEdits {
	public static void main(String[] args) {
		/*
		 * String S1 = "hoe to aeterc a wesite en htlm"; String S2 =
		 * "how to create a website in html";
		 */
		String S1 = "hoe to aetercawa";
		String S2 = "howto  createawe";
		int val = naive(S1, S2, S1.length(), S2.length());
		System.out.println(val);
		int edit1[][] = new int[S1.length() + 1][S2.length() + 1];
		for (int[] is : edit1) {
			Arrays.fill(is, -1);
			// System.out.println(Arrays.toString(is));
		}
		int val1 = editTopDown(S1, S2, S1.length(), S2.length(), edit1);
		System.out.println(val1);
		/*
		 * for (int[] is : edit1) { System.out.println(Arrays.toString(is)); }
		 */
	}

	private static int naive(String s1, String s2, int m, int n) {
		if (m == 0)
			return n;
		if (n == 0)
			return m;
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return naive(s1, s2, m - 1, n - 1);
		} else {
			return 1 + min(naive(s1, s2, m, n - 1), naive(s1, s2, m - 1, n), naive(s1, s2, m - 1, n - 1));
		}
	}

	/*
	 * top down DP approach
	 */
	private static int editTopDown(String s1, String s2, int m, int n, int[][] edit1) {
		if (m == 0) {
			edit1[m][n] = n;
			return edit1[m][n];
		}
		if (n == 0) {
			edit1[m][n] = m;
			return edit1[m][n];
		}
		if (edit1[m][n] != -1)
			return edit1[m][n];
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			edit1[m][n] = editTopDown(s1, s2, m - 1, n - 1, edit1);
		} else {
			edit1[m][n] = 1 + min(editTopDown(s1, s2, m, n - 1, edit1), editTopDown(s1, s2, m - 1, n, edit1),
					editTopDown(s1, s2, m - 1, n - 1, edit1));
		}
		return edit1[m][n];
	}

	private static int min(int a, int b, int c) {
		if (a < b && a < c)
			return a;
		if (b < c && b < a)
			return b;
		return c;
	}
}