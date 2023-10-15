'''
1. Level order -> nodes at each level. So we maintain a level variable
2. We maintain a list and answer. To the list we append the nodes at each level.
3. If the level increased then answer length wont be equal to level. So we append a new list to the answer.
4. We do a dfs and increase the level by 1 and call on left and right child. Return answer.

TC: O(n)
SC: O(n) -> list
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return None
        
        self.ans = []
        self.dfs(root,0)
        return self.ans
    
    def dfs(self,root: TreeNode, level: int):

        if root == None:
            return 
        
        if level == len(self.ans) :
            temp = []
            temp.append(root.val)
            self.ans.append(temp)
        else:
            self.ans[level].append(root.val)
        
        self.dfs(root.left, level+1)
        self.dfs(root.right,level+1)