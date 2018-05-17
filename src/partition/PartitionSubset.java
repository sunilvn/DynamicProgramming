package partition;

public class PartitionSubset {

	public static void main(String[] args) {

		int arr[] = { 3, 23, 41, 2, 66, 11 };

		int n = arr.length;
		int totalSum = 0;
		for (int i : arr)
			totalSum += i;
		System.out.println(totalSum);
		int value = findMin(arr, n, 0, totalSum);
		System.out.println(value);
		int dpvalue = findMinDP(arr, n);
		System.out.println(dpvalue);

	}

	private static int findMin(int[] arr, int n, int curSum, int totalSum) {

		if (n == 0)
			return Math.abs(totalSum - 2 * curSum);

		int a = findMin(arr, n - 1, curSum + arr[n - 1], totalSum);
		int b = findMin(arr, n - 1, curSum, totalSum);

		return Math.min(a, b);

	}

	private static int findMinDP(int arr[], int n) {

		int sum = 0;
		for (int i : arr) {
			sum += i;
		}

		boolean[][] dp = new boolean[n + 1][sum + 1];

		// adding true since 0 is possible with all the elements
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}
		// adding false where element is greater than sum 0
		for (int i = 1; i <= sum; i++) {
			dp[0][i] = false;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				// excluding current element
				dp[i][j] = dp[i - 1][j];
				// including current element only if else than sum
				if (j >= arr[i - 1]) {
					dp[i][j] = dp[i][j] | dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		int min = sum;
		for (int i = sum / 2; i >= 0; i--) {
			if (dp[n][i]) {
				min = sum - 2 * i;
				break;
			}
		}
		return min;
	}
}
