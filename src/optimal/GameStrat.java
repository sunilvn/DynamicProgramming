package optimal;

public class GameStrat {

	public static void main(String[] args) {

		// int arr[] = { 8, 15, 3, 7 };
		int arr[] = { 5, 3, 7, 10 };
		int n = arr.length;
		System.out.println(n);

		int max = getMaxSum(arr, 0, n - 1, 0);
		System.out.println(max);
		int maxdp = getMaxSumDP(arr, 0, n - 1, 0);
		System.out.println(max);
	}

	private static int getMaxSumDP(int[] arr, int start, int end, int sum) {

		if (start > end)
			return sum;

		return Math.max(
				Math.min(getMaxSum(arr, start + 2, end, sum + arr[start]),
						getMaxSum(arr, start + 1, end - 1, sum + arr[start])),
				Math.min(getMaxSum(arr, start + 1, end - 1, sum + arr[end]),
						getMaxSum(arr, start, end - 2, sum + arr[end])));
	}

	private static int getMaxSum(int[] arr, int start, int end, int sum) {

		if (start > end)
			return sum;

		return Math.max(
				Math.min(getMaxSum(arr, start + 2, end, sum + arr[start]),
						getMaxSum(arr, start + 1, end - 1, sum + arr[start])),
				Math.min(getMaxSum(arr, start + 1, end - 1, sum + arr[end]),
						getMaxSum(arr, start, end - 2, sum + arr[end])));
	}
}
