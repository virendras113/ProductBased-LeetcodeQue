// 396. Rotate Function
// You are given an integer array nums of length n. Return maximum length of Rotation Function.

class Solution {
    public int maxRotateFunction(int[] nums) {

        int size = nums.length;
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        long pSum = 0;

        for(int i=0; i<size; i++){
            pSum += nums[i];
            sum += nums[i] * i;
        }

        maxSum = Math.max(maxSum, sum);

        for(int i=size-1; i>0; i--){
            sum += pSum - (nums[i] * size);
            maxSum = Math.max(maxSum, sum);
        }

        return (int)maxSum;
        
    }
}
