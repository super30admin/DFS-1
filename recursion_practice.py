# import math
# class Node(object):
#     def __init__(self,data):
#         self.data = data
#         self.left = None
#         self.right = None


# def min_path_sum(root):
#     if not root:
#         return 0
        
#     result = []
#     path = []
    
#     helper(root, path, result)
#     print(result)
#     minimum_path_sum = float("inf")
#     idx = None
#     for i in range (len(result)):
#         if sum(result[i]) < minimum_path_sum:
#             minimum_path_sum = sum(result[i])
#             idx = i
    
    
#     return  result[idx] 
    
    
# def helper(root, path, result):
    
#     if not root:
#         return 
    
#     path.append(root.data)
    
#     if not root.left and not root.right: # optimise here: check if path sum is min and delete last stored path and update to new one
#         # leaf node
#         result.append(path.copy())
    
#     helper(root.left, path, result)
#     helper(root.right, path, result)
    
#     path.pop()



# # def min_sum(root):
# #     if root == None:
# #         return 0
# #     result = root.data
# #     leftresult = math.inf
# #     rightresult = math.inf
# #     if (root.left == None) and (root.right == None):
# #         return result
# #     else:
# #         if (root.left != None):
# #             leftresult = min_sum(root.left)
# #         if (root.right != None):
# #             rightresult = min_sum(root.right)
# #         if (leftresult < rightresult):
# #             result += leftresult
# #         else:
# #             result += rightresult
# #     return result

# root = Node(4)
# root.left = Node(5)
# root.right = Node(6)
# root.left.left = Node(2)
# root.left.right = Node(3)
# root.right.left = Node(1)
# root.right.right = Node(8)

# # root = Node(1)
# # root.left = Node(2)
# # root.right = Node(3)
# print (min_path_sum(root))







# import math
# class Node(object):
#     def __init__(self,data):
#         self.val = data
#         self.left = None
#         self.right = None

# def maxPathSum(root):
        
#     if not root:
#         return 0
    
#     def dfs(root):
#         nonlocal maximum_sum
#         # base case
#         if not root:
#             return 0
        
#         # logic
#         left_subtree = max(dfs(root.left), 0)
#         right_subtree = max(dfs(root.right), 0)
        
#         maximum_sum = max(maximum_sum, left_subtree + right_subtree + root.val)
        
#         return max(left_subtree, right_subtree) + root.val
      
#     maximum_sum = float("-inf")  
#     dfs(root)
    
#     return maximum_sum
        
    
# root = Node(-10)
# root.left = Node(9)
# root.right = Node(20)
# root.right.left = Node(15)
# root.right.right = Node(7)


# print (maxPathSum(root))









import math
class Node(object):
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None
        
def isBalanced(root):
        
    # if null node it is balanced
    if root == None:
        return True
    
    # starting from root, obtain left & right depths
    ldepth = depth(root.left)
    rdepth = depth(root.right)
    
    
    # check if they breach, if not continue validating subtrees if balanced also -- just if this passes does not mean it is balanced
    if abs(ldepth - rdepth) > 1:
        
        return False
    
    else:
        # now check subtree and see if they are balanced, if yes proceed to right subtree,
        # while gettings left depths & right for these, if any one subtree is  not valid, in line 19 it breaches, dont need to check other
        
        return isBalanced(root.left) and isBalanced(root.right)
    
        
        
def depth(root):
        
    if root == None:
        return 0
    return 1 + max(depth(root.left), depth(root.right))
    
    
root = Node(3)
root.left = Node(9)
root.right = Node(20)
root.right.left = Node(15)
root.right.right = Node(7)

print(isBalanced(root))
