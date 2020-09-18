# Time Complexity : O(nm)
# Space Complexity : O(nm) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The only trick is to change 1 to inf for checking  matrix[r][c] + 1 < matrix[row][col] and use bfs
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(matrix) == 0 or matrix == None:
            return matrix
        
        queue = []
        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                if matrix[i][j] == 1:
                    matrix[i][j] = float('inf')
                elif matrix[i][j] == 0:
                    queue.append((i,j))
       
        dirs = [[-1,0], [1,0], [0,1], [0,-1]]
        
        while queue:
            front = queue.pop(0)
            r = front[0]
            c = front[1]
            for d in dirs:
                row = r + d[0]
                col = c + d[1]
                if row >= 0 and row < len(matrix) and col >=0 and col < len(matrix[0]) and matrix[r][c] + 1 < matrix[row][col]:
                    matrix[row][col] = matrix[r][c] + 1
                    queue.append((row,col))
        
        return matrix
