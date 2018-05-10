package lis;

import java.util.Arrays;

import javax.print.attribute.standard.RequestingUserName;

/*
 * 
 * Longest Increasing stackFsequence
 * 
 * Possible solutions :
 * 1. generate all combinations using binary sequence and check for the LIS O(2^n * n)
 * 
 * 2.
 * 
 */
public class LIS {

	static int max_ref = 1;
	static int lis[];
	static int x = 1;

	public static void main(String[] args) {

		int arr[] = { 10, 22, 9, 33, 21, 50, 60,70 };
		int n = arr.length;
		lis = new int[n ];
		Arrays.fill(lis, -1);
		System.out.println("Length of lis is " + lis(arr, n));
		x = 1;
		System.out.println("Length of lis is " + DPLis(arr, n, 1));
		x = 1;
		System.out.println("Length of lis is " + DPLis_bu(arr, n, 1));
	}

	private static int DPLis_bu(int[] arr, int n, int stackF) {

		int lisbu[]=new int[n];
		Arrays.fill(lisbu, 1);
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				
				System.out.println(x++ + "  " + Arrays.toString(lisbu) + "  " + stackF );
				if(arr[j]<arr[i] && lisbu[j]>=lisbu[i]){
					lisbu[i]=lisbu[j]+1;
				}
					
			}
		}
		return lisbu[n-1];
	}

	private static int lis(int[] arr, int n) {

		return naiveLis(arr, n, 1);

	}

	private static int naiveLis(int[] arr, int n, int stackF) {

		if (n == 1)
			return 1;
		int res = 0;
		int max_end = 1;

		for (int i = 1; i < n; i++) {

			System.out.print(x++ + "\t");
			System.out.println(stackF + "  " + arr[i - 1] + ":" + arr[n - 1]);
			res = naiveLis(arr, i, stackF + 1);

			if (arr[i - 1] < arr[n - 1] && res + 1 > max_end) {
				max_end = res + 1;
			}
		}
		if (max_ref < max_end)
			max_ref = max_end;
		return max_end;
	}

	// top down approach
	private static int DPLis(int[] arr, int n, int stackF) {

		if (n == 1)
			return 1;
		int res = 0;
		int max_end = 1;

		if (lis[n - 1] != -1)
			return lis[n - 1];

		for (int i = 1; i < n; i++) {

			System.out.println(x++ + " " +( i - 1) + "  " + Arrays.toString(lis) + "  " + stackF + "  " + arr[i - 1]
					+ ":" + arr[n - 1]);
			res = DPLis(arr, i, stackF + 1);
			//lis[i -1] = res;
			if (arr[i - 1] < arr[n - 1] && res >= max_end) {
				max_end = res + 1;
			}
		}
		lis[n - 1]=max_end;
		//System.out.println(x++ + " "+( n - 1)  + "  " + Arrays.toString(lis) + "  " + stackF );
		return lis[n - 1];
	
	}
}
