# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        if not matrix: return [] 
        m = len(matrix)
        n = len(matrix[0])
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        q = deque()
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append((i,j))
                else:
                    matrix[i][j] = -1 # State change. Can also use visited set.
        while q:
            curr = q.popleft()
            # For every curr, check all 4 dirctns.
            for d in dirs:
                row = d[0] + curr[0]
                col = d[1] + curr[1]
                if row>=0 and col>=0 and row<m and col<n and matrix[row][col]==-1:
                    matrix[row][col] = matrix[curr[0]][curr[1]] + 1
                    q.append((row,col))
        
        return matrix