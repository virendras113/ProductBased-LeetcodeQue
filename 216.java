// 216. Combination Sum III
// Combination Sum with a twist.

// Approach - Backtracking

class Solution {

    public static int k;
    public static int n;
    public static List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int kD, int nD) {

        int arr[] = new int[9];

        for(int i=0; i<9; i++){
            arr[i] = i + 1;
        }

        res = new ArrayList<>();
        k = kD;
        n = nD;

        helper(arr, new ArrayList<>(), 0, 0);

        return res;
        
    }

    public static void helper(int arr[], List<Integer> child, int ind, int sum){

        if(child.size() > k || sum > n){
            return;
        }

        if(child.size() == k && sum == n){
            res.add(new ArrayList<>(child));
        }

        for(int i=ind; i<arr.length; i++){

            if(child.contains(arr[i])){
                continue;
            }

            child.add(arr[i]);
            helper(arr, child, i, sum + arr[i]);
            child.remove(child.size() - 1);

        }

    }
}
