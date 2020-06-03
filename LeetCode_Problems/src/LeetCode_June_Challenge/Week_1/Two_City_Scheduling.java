package LeetCode_June_Challenge.Week_1;

import java.util.Arrays;
import java.util.Comparator;

public class Two_City_Scheduling {

	public static void main(String[] args) {
		int[][] costs = { { 20, 40 }, { 30, 75 }, { 50, 250 }, { 40, 100 } };
		System.out.println(twoCitySchedCost(costs));
		System.out.println(twoCitySchedCost1(costs));
		System.out.println(twoCitySchedCost2(costs));
	}

	public static int twoCitySchedCost(int[][] costs) {
		int n = costs.length / 2;
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
			}
		});
		for(int i[]: costs) {
			for(int j: i)
				System.out.print(j+" ");
			System.out.println();
		}
		int nA = 0, nB = 0, sum = 0;
		for (int[] cost : costs) {
			if ((cost[0] < cost[1] && nA < n) || nB == n) {
				sum += cost[0];
				nA++;
			} else {
				sum += cost[1];
				nB++;
			}
		}
		return sum;
	}

	public static int twoCitySchedCost1(int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return (a[1] - a[0]) - (b[1] - b[0]);
			}
		});
		int cost = 0;
		for (int i = 0; i < costs.length / 2; i++) {
			cost += costs[i][1] + costs[costs.length - i - 1][0];
		}
		return cost;
	}

	public static int twoCitySchedCost2(int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - a[1] - (b[0] - b[1]);
			}
		});
		int res = 0;
		for (int i = 0; i < costs.length / 2; i++) {
			res += costs[i][0];
		}
		for (int i = costs.length / 2; i < costs.length; i++) {
			res += costs[i][1];
		}
		return res;
	}
}
