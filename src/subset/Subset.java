package subset;

// Check if sum of elements of subset of the given array can give required sum 
public class Subset {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		int arr[] = { 3, 34, 4, 12, 5, 2, 55, 11, 22, 66, 44, 88, 22, 66, 84, 354, 54, 484, 3, 34, 4, 12, 5, 2, 55, 11,
				22,66,44,88,99,100 };// 22, 66, 44, 88, 22, 66, 84, 354, 54, 484 };//
		int sum = 99445;
		int n = arr.length;
		System.out.println(n);

		boolean flag = isSubSetSum(arr, sum, n);
		System.out.println(flag);
		System.out.print("Recursive : ");
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		boolean flag1 = isSubSetSumDP(arr, sum, n);
		System.out.println(flag1);
		System.out.print("DP : ");
		System.out.println(System.currentTimeMillis() - start);
	}

	private static boolean isSubSetSumDP(int[] arr, int sum, int n) {

		boolean dp[][] = new boolean[n + 1][sum + 1];

		for (int i = 1; i < sum + 1; i++) {
			dp[0][i] = false;
		}
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int s = 1; s <= sum; s++) {

				dp[i][s] = dp[i - 1][s];
				if (s >= arr[i - 1]) {
					dp[i][s] =dp[i][s] || dp[i - 1][s - arr[i - 1]];
				}
			}
		}
		return dp[n][sum];
	}

	// Recursive approach by checking for all combinations
	private static boolean isSubSetSum(int[] arr, int sum, int n) {

		if (n < 1)
			return false;
		if (sum == 0)
			return true;
		if (sum < 0)
			return false;
		else {
			return isSubSetSum(arr, sum, n - 1) || isSubSetSum(arr, sum - arr[n - 1], n - 1);
		}
	}

}
