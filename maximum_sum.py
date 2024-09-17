http://pythontutor.com/visualize.html#mode=edit

class Node(object):
    def __init__(self,data):
        self.val = data
        self.left = None
        self.right = None

def maxPathSum(root):
        
    if not root:
        return 0
    
    def dfs(root):
        nonlocal maximum_sum
        # base case
        if not root:
            return 0
        
        # logic
        left_subtree = max(dfs(root.left), 0)
        right_subtree = max(dfs(root.right), 0)
        
        maximum_sum = max(maximum_sum, left_subtree + right_subtree + root.val)
        
        return max(left_subtree, right_subtree) + root.val
      
    maximum_sum = float("-inf")  
    dfs(root)
    
    return maximum_sum
        
    
root = Node(-10)
root.left = Node(9)
root.right = Node(20)
root.right.left = Node(15)
root.right.right = Node(7)


print (maxPathSum(root))
