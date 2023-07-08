// 368. Largest Divisible Subset
// Largest Divisible Subset.

// Approach - Recursion -> Memoization

class Solution {

    public static List<Integer> res;
    public static int dp[];

    public List<Integer> largestDivisibleSubset(int[] nums) {

        if(nums.length == 0){
            return res;
            
        }

        Arrays.sort(nums);

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        res = new ArrayList<>();

        helper(nums, 1, 0, new ArrayList<>());

        return res;
        
    }

    public static void helper(int nums[], int prev, int ind, List<Integer> tempRes){

        if(ind == nums.length){
            if(tempRes.size() > res.size()){
                res.clear();
                res.addAll(tempRes);
            //tempRes.clear();
            }
            return;
        }

        if(tempRes.size() > dp[ind] && nums[ind] % prev == 0 || prev % nums[ind] == 0){
            dp[ind] = tempRes.size();
            tempRes.add(nums[ind]);
            helper(nums, nums[ind], ind + 1, tempRes);
            tempRes.remove(tempRes.size() - 1);
        }

        helper(nums, prev, ind + 1, tempRes);

    }

}
