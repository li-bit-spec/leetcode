public class _213 {
    public static void main(String[] args){
        System.out.println(rob(new int[]{1,2,2,1}));
    }
    public static int rob(int[] nums){
        // 分为两种情况，取首不取尾，或者取尾不取首
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums,0,n-2),robRange(nums,1,n-1));
    }
    public static int robRange(int[] nums, int start, int end){
        int n = nums.length - 1;
//        int n = end - start + 1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for(int i = 2; i < n ; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[start + i]);
        }
        return dp[n-1];
    }
}
