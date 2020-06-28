"""
// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        q = deque()
        
        r = len(matrix)
        c = len(matrix[0])
        
        q = deque()
        
        for i in range(r):
            for j in range(c):
                if matrix[i][j] == 0: #adding all zeroes to queue
                    q.append((i,j))
                else:
                    matrix[i][j] = -1 #so that a node is not visited more than once 
                
                
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        dist = 1
        
        while q:
            size = len(q)
            
            for s in range(size):
                cur = q.popleft()
                
                for d in dirs:
                    row = cur[0] + d[0]
                    col = cur[1] + d[1]
                
                    if row >= 0 and row < r and col >= 0 and col < c and matrix[row][col] == -1: #add to q only if it is not visited
                        matrix[row][col] = dist
                        q.append((row, col))
                        
            dist += 1 #update dist at every level
                
        return matrix
                
        