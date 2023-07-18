// 2261. K Divisible Elements Subarrays

/* Approach - Sliding window to consider sub-arrays that satisfy the condition of K and P.
            - HashSet to keep only unique sub-arrays.
*/

class Solution {

    public static HashSet<List<Integer>> hset;

    public int countDistinct(int[] nums, int k, int p) {

        hset = new HashSet<>();

        int count = 0;

        int i = 0;

        for(int j=0; j<nums.length; j++){

            if(nums[j] % p == 0){
                count++;
            }

            while(count > k){
                if(nums[i] % p == 0){
                    count--;
                }
                i++;
            }

            helper(nums, i, j);

        }

        //System.out.println(hset);

        return hset.size();
        
    }

    public static void helper(int nums[], int s, int e){
        for(int i=s; i<=e; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=i; j<=e; j++){
                temp.add(nums[j]);
            }
            hset.add(temp);
        }
    }
}
