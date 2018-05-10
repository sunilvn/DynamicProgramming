package lcs;

import java.util.Arrays;

public class LCS {

	public static void main(String[] args) {

		/*
		 * String S2 = "ABCDGHA"; String S1 = "BCADHR";
		 */
		String S2 = "AGGTAB";
		String S1 = "GXTXAYB";
		int x = naivelcs(S1, S2, S1.length(), S2.length());
		System.out.println(x);

		int y = bottomUpLCS(S1, S2, S1.length(), S2.length());
		System.out.println(y);
		int lcs[][] = new int[S1.length() + 1][S2.length() + 1];
		for (int i = 0; i < lcs.length; i++)
			Arrays.fill(lcs[i], -1);
		int z = topdownlcs(S1, S2, S1.length(), S2.length(), lcs);
		print(lcs);
		System.out.println(z);
	}

	private static int topdownlcs(String s1, String s2, int i, int j, int[][] lcs) {
		//System.out.println(i+","+j);
		if (i == 0 || j == 0)
			return 0;
		if (lcs[i][j] != -1) {
			return  lcs[i][j];
		} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			lcs[i][j] =1+ topdownlcs(s1, s2, i - 1, j - 1, lcs);
			return lcs[i][j];
		} else {
			lcs[i][j - 1] = topdownlcs(s1, s2, i, j - 1, lcs);
			lcs[i - 1][j] = topdownlcs(s1, s2, i - 1, j, lcs);
			return max(lcs[i][j - 1], lcs[i - 1][j]);
		}
	}

	private static int bottomUpLCS(String s1, String s2, int len1, int len2) {

		int lcs[][] = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 || j == 0)
					lcs[i][j] = 0;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		print(lcs);

		return lcs[len1][len2];
	}

	private static void print(int[][] lcs) {
		System.out.println();
		for (int i = 0; i < lcs.length; i++) {
			for (int j = 0; j < lcs[i].length; j++) {
				System.out.print(lcs[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int naivelcs(String s1, String s2, int i, int j) {
		if (i == 0 || j == 0)
			return 0;
		if (s1.charAt(i - 1) == s2.charAt(j - 1))
			return 1 + naivelcs(s1, s2, i - 1, j - 1);
		else {
			return max(naivelcs(s1, s2, i - 1, j), naivelcs(s1, s2, i, j - 1));
		}

	}

	private static int max(int a, int b) {

		return a > b ? a : b;
	}

}
