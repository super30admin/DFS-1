// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, used inorder.length 
// instead of inodrer.length - 1 as end is inclusive

// approach: store root value and their correspinding index in inorder array 
// in map for O(1) lookup of root position
// then, in dfs manner, get root value from global index position, get its position from map, i.e rootIdx 
// create a root node with the root val, now rootIdx is used
// for left subtree, do dfs call with preorder, start, rootIdx - 1 
// for right subtree, do dfs call with preorder, rootIdx + 1, end 

// construct binary tree from preorder and inorder traversal

import java.util.HashMap;
import java.util.Map;

public class prob3 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int idx;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        map = new HashMap<>();
        // getting root position in O(1) time 
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1); // end is inclusive so length - 1
    }

    private TreeNode helper(int[] preorder, int start, int end){
        if(start > end) return null;

        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, end);
        return root;
    }
    
}
