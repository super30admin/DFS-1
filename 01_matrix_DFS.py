# Time Complexity : Add - O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode : No - Time Exceeded
# Any problem you faced while coding this : No
'''

1. Initially 1's replaced with a very large value, to make sure they are not revsiited when BFS is performed
2. DFS is started when element == 0, all neighbours are explored. 
3. All paths from all 0's are explored and the minimum distance at at any element is min of previous min and current level
'''

import sys
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        # if not m
        rows = len(matrix)
        cols = len(matrix[0])
        
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == 1:
                    matrix[i][j] = sys.maxsize
                    
        # print ("initial", matrix)
                    

        for i in range(rows):
            for j in range(cols):
                
                if matrix[i][j] == 0:
                    # print (i,j)
                    self._dfs(matrix, i,j, 1)
                # print (matrix)
                    
        return matrix
                    
                    
    def _dfs(self, matrix, i, j, level):
        
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        
        for dir_x, dir_y in dirs:
            new_x = i + dir_x
            new_y = j + dir_y
            if new_x >= 0 and new_x < len(matrix) and new_y >= 0 and new_y < len(matrix[0]) and matrix[new_x][new_y] > level:  
                matrix[new_x][new_y] = min(level, matrix[new_x][new_y])
                self._dfs(matrix, new_x, new_y, level+1)
                    
        