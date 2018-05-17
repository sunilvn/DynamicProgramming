package steps;

// find the total number to cover required distance using following steps : 1,2,3
public class TotalWays {

	public static void main(String[] args) {

		// total distance is 5 steps
		int count = findSteps(40);
		System.out.println(count);
		long count1 = findStepsBP(50);
		System.out.println(count1);
	}

	private static long findStepsBP(int steps) {

		long dp[] = new long[steps + 1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		for (int j = 3; j <= steps; j++) {
			dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
		}
		return dp[steps];
	}

	private static int findSteps(int steps) {
		if (steps < 0)
			return 0;
		if (steps == 0)
			return 1;
		else {
			int count = findSteps(steps - 1) + findSteps(steps - 2) + findSteps(steps - 3);
			return count;
		}
	}

}
