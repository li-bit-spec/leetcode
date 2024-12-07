import java.util.*;

/**
 * @author lhx
 * @project leetcode
 * @package PACKAGE_NAME
 * @date 2024/12/7 09:51
 * @description: 目标和：动态规划
 */
public class _494 {


	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.nextLine();
		int target = scanner.nextInt();

		String[] parts = input1.split("\\s+");
		int[] nums = new int[parts.length];

		int sum = 0;
		for(int i= 0;i<parts.length;i++){
			nums[i] = Integer.parseInt(parts[i]);
			sum += nums[i];
		}
		System.out.println(findTargetSumWays(nums, target));
		/*
		if(target>sum){
			System.out.println(0);
		}
		int left = (target + sum)/2;

		/*
		Arrays.sort(nums);
		backtracking(nums, left, 0,0);
		System.out.println(res.size());*/
	}
	public static int findTargetSumWays(int[] nums, int target){
		Arrays.sort(nums);
		int sum = 0;
		for(int num : nums){
			sum += num;
		}
		if(Math.abs(target)>sum){
			return 0;
		}
		if((sum+target)%2!=0){
			return 0;
		}
		int left = (target+sum)/2;
		int[] dp = new int[left + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int j = left; j >= num; j--) {
				dp[j] = dp[j] + dp[j - num];
			}
		}
		return dp[left];

		/*
		 动态规划，将问题转换为将 nums 数组放入容量为 left 的背包中, 总共有多少种方法。
		 dp[i][j] 表示装满容量为 j 的背包，用 [0,i]种物品共有 dp[i,j] 种方法。
		 递推公式：
		 （1）不放物品 i ：即背包容量为 j,不放物品 i，装满有dp[i-1][j] 种方法。
		 （2）放物品 i ：先空出物品 i 的容量，背包容量为(j-物品i容量)，放满背包有 dp[i-1][j-物品i容量] 种方法
		 即 dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
		*/
		/*
		int[][] dp = new int[nums.length][left+1];
		Arrays.sort(nums);
		// dp 初始化
		// 最上面一行
		// 当只有一种物品0的时候，恰好装满才为1，其余为0
		if(nums[0]<=left){
			dp[0][nums[0]] = 1;
		}
		// 最左侧 dp[i][0] = 1, 因为背包容量为0的时候只有一种方法
		// 特殊：当有nums[i] = 0,在[0,i]中共有 n 个nums[i]=0,则有 2^n 种方法。
		// 每个0可以取+/-，因此有2的n次方
		int n = 0;
		for(int i = 0;i<nums.length;i++){
			if(nums[i]==0){
				n++;
			}
			dp[i][0] = 1 << n;
		}

		for(int i=1;i<nums.length;i++){
			for(int j=1;j<=left;j++){
				if(nums[i]>j){
					// 只能不放nums[i]
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
				}
			}
		}
		return dp[nums.length-1][left];
		 */

	}
	/*
	static List<List<Integer>> res = new ArrayList<>();
	static List<Integer> path = new LinkedList<>();
	public static void backtracking(int[] nums, int target, int sum, int startIndex) {
		if(sum>target){
			return;
		}
		if(sum==target){
			res.add(new ArrayList<>(path));
			return;
		}
		for(int i = startIndex;i<nums.length;i++){
			sum+=nums[i];
			path.add(nums[i]);
			backtracking(nums, target, sum, i+1);
			// 回溯
			sum-=nums[i];
			path.remove(path.size() - 1);
		}
	}*/

}
