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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return cmp(p).equals(cmp(q));
        
    }
    private List<List<Integer>> cmp(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> currentList = new ArrayList<>();
            int size = queue.size();

            for(int i =0;i<size;i++){
                TreeNode currentNode =  queue.poll();
                if (currentNode == null) {
                currentList.add(null);
                continue; 
            }
                currentList.add(currentNode.val);
                 queue.offer(currentNode.left);
                 queue.offer(currentNode.right);
            }
            result.add(currentList);
        }
        return result;
        
    
    }
}