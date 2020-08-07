#Problem2 : https://leetcode.com/problems/01-matrix/(Solved using bfs)
#All test cases passed on Leetcode
#Time Complexity:  O(m x n) and Space Complexity: O(m x n) 
#m=no of rows; n=no of cols
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
  
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if(matrix == None or len(matrix) == 0):
            return matrix
        #find no of rows and columns
        nRows=len(matrix)
        nCols=len(matrix[0])
        # maintain a queue
        queue = deque()
        for r in range(nRows):
            for c in range(nCols):
        #   add all cells with value 0 to the queue and for other cells update value to -1
            
                if (matrix[r][c] == 0):
                    queue.append([r, c])
                    # visited[r][c] = True
                else:
                    matrix[r][c]=-1
        #next neighbours that will be processes  will have distance of 1 from zeroes
        distance=1
        #for 4 directions
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        
        while len(queue)>0:
            size=len(queue)
            for i in range(size):
                #pop the element from left side that is front of the queue
                curr=queue.popleft()
                for dir in dirs:
                    #get the new cells 
                    r=curr[0]+dir[0]
                    c=curr[1]+dir[1]
                    #boundary check conditions
                    if r>=0 and c>=0 and r<nRows and c<nCols and matrix[r][c]==-1:
                        matrix[r][c]=distance
                        queue.append([r,c])
            distance+=1
        return matrix
                
            
        
 