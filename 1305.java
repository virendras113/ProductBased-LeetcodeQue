// 1305. All Elements in Two Binary Search Trees


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static ArrayList<Integer> arr;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        arr = new ArrayList<>();
        recur(root1);
        recur(root2);
        Collections.sort(arr);
        return arr;
    }
    public static void recur(TreeNode root){
        if(root == null){
            return;
        }
        arr.add(root.val);
        recur(root.right);
        recur(root.left);
    }
}
