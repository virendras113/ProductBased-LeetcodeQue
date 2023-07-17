// 581. Shortest Unsorted Continuous Subarray
// Approach - Two pointers pointing to the start and the end of the unsorted array!

class Solution {
    public int findUnsortedSubarray(int[] nums) {

        if(nums.length <= 1){
            return 0;
        }

        int dupli[] = Arrays.copyOfRange(nums, 0, nums.length);

        Arrays.sort(nums);

        if(Arrays.equals(nums, dupli)) return 0;

        int first = -1;
        int last = -1;

        for(int i=0; i<nums.length; i++){
            if(dupli[i] != nums[i]){
                first = i;
                break;
            }
        }

        for(int i=nums.length - 1; i>=0; i--){
            if(dupli[i] != nums[i]){
                last = i;
                break;
            }
        }

        if(first == last && first == -1){
            return 0;
        }

        return last - first + 1;
        
    }
}
