# // Time Complexity : O(n*m)
# // Space Complexity : O(n*m)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

import collections
class Solution:
    def updateMatrix(self, matrix):
        
        queue = collections.deque()
        visited = set()
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]==0:
                    queue.append((i,j))
                    visited.add((i,j))
        
        while queue:
            x,y = queue.popleft()
            for d in dirs:
                new_i = d[0] + x
                new_j = d[1] + y
                if 0<=new_i<len(matrix) and 0<=new_j<len(matrix[0]) and (new_i,new_j) not in visited:
                    matrix[new_i][new_j] = matrix[x][y] + 1
                    visited.add((new_i,new_j))
                    queue.append((new_i,new_j))
        return matrix
                    